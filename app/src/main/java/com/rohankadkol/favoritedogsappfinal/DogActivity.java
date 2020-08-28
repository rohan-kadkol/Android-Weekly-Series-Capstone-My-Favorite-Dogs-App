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
import android.widget.Toast;

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

        // TODO (11): Create a FirebaseDatabase instance and call it database
        // FirebaseDatabase database = FirebaseDatabase.getInstance();
        // TODO (12): Using this instance, create a DatabaseReference to the path "dogs/<dogId>". Name it "ref".
        // DatabaseReference ref = database.getReference("dogs").child(dogId);

        // TODO (13): Add a ValueEventListener to ref.
        // ref.addValueEventListener(new ValueEventListener() {});

        // Within onDataChange()
        // TODO (14): Convert the DataSnapshot into a Dog object using snapshot.getValue(Dog.class). Save this to mDog.
        // TODO (15): Call the populateViews() method and pass mDog as a parameter.
        // @Override
        // public void onDataChange(@NonNull DataSnapshot snapshot) {
        //     mDog = snapshot.getValue(Dog.class);
        //     populateViews(mDog);
        // }

        // Within onCancelled()
        // TODO (16): Show a Toast with an appropriate error message
        // @Override
        // public void onCancelled(@NonNull DatabaseError error) {
        //     Toast.makeText(DogActivity.this, getResources().getQuantityString(R.plurals.download_error_dogs, 1, 1), Toast.LENGTH_SHORT).show();
        // }

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
        TextView tvLikes = findViewById(R.id.tv_likes);
        TextView tvDislikes = findViewById(R.id.tv_dislikes);
        TextView tvNotes = findViewById(R.id.tv_notes);

        String imageUrl = dog.getImageUrl().equals("") ? "a" : dog.getImageUrl();
        Picasso.get().load(imageUrl).error(R.drawable.ic_broken_image).into(ivDog);
        tvName.setText(dog.getName());
        tvBreed.setText(StringUtils.getBreedString(this.getResources(), dog.getBreed()));
        tvAge.setText(StringUtils.getAgeDisplayString(this.getResources(), dog.getAge()));
        tvLikes.setText(dog.getLikes());
        tvDislikes.setText(dog.getDislikes());
        tvNotes.setText(dog.getNotes());

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
