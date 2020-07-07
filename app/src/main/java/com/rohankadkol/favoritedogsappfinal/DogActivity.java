package com.rohankadkol.favoritedogsappfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rohankadkol.favoritedogsappfinal.pojos.Dog;
import com.rohankadkol.favoritedogsappfinal.utils.AlertDialogUtils;
import com.rohankadkol.favoritedogsappfinal.utils.FirebaseUtils;
import com.rohankadkol.favoritedogsappfinal.utils.StringUtils;
import com.squareup.picasso.Picasso;

public class DogActivity extends AppCompatActivity {
    Dog mDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);

//        mDog = getIntent().getParcelableExtra(getString(R.string.dog_key));
        String dogId = getIntent().getStringExtra(getString(R.string.dog_id_key));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("dogs").child(dogId);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mDog = snapshot.getValue(Dog.class);
                populateViews(mDog);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void populateViews(Dog dog) {
        if (dog == null) {
            return;
        }

        ImageView ivDog = findViewById(R.id.iv_dog);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvBreed = findViewById(R.id.tv_breed);
        TextView tvAge = findViewById(R.id.tv_age);

        String imageUrl = dog.getImageUrl().equals("") ? "a" : dog.getImageUrl();
        Picasso.get().load(imageUrl).error(R.drawable.ic_broken_image).into(ivDog);
        tvName.setText(dog.getName());
        tvBreed.setText(StringUtils.getBreedString(this.getResources(), dog.getBreed()));
        tvAge.setText(StringUtils.getAgeDisplayString(this.getResources(), dog.getAge()));

        setTitle(mDog.getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dog_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        } else if (item.getItemId() == R.id.action_edit) {
            Intent intent = new Intent(this, AddEditActivity.class);
            intent.putExtra(getString(R.string.add_edit_key), getString(R.string.edit_key));
            intent.putExtra(getString(R.string.dog_key), mDog);
            startActivity(intent);
        } else if (item.getItemId() == R.id.action_delete) {
            AlertDialogUtils.showDeleteAlertDialog(this, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    FirebaseUtils.deleteDog(mDog);
                    DogActivity.this.finish();
                }
            }, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
//            FirebaseUtils.deleteDog(mDog);
        }
        return true;
    }
}
