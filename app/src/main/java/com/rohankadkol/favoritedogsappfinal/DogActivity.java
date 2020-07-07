package com.rohankadkol.favoritedogsappfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.rohankadkol.favoritedogsappfinal.pojos.Dog;
import com.rohankadkol.favoritedogsappfinal.utils.StringUtils;
import com.squareup.picasso.Picasso;

public class DogActivity extends AppCompatActivity {
    Dog mDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);

        mDog = getIntent().getParcelableExtra(getString(R.string.dog_key));
        populateViews(mDog);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        setTitle(mDog.getName());
    }

    private void populateViews(Dog dog) {
        ImageView ivDog = findViewById(R.id.iv_dog);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvBreed = findViewById(R.id.tv_breed);
        TextView tvAge = findViewById(R.id.tv_age);

        String imageUrl = dog.getImageUrl().equals("") ? "a" : dog.getImageUrl();
        Picasso.get().load(imageUrl).error(R.drawable.ic_broken_image).into(ivDog);
        tvName.setText(dog.getName());
        tvBreed.setText(StringUtils.getBreedString(this.getResources(), dog.getBreed()));
        tvAge.setText(StringUtils.getAgeDisplayString(this.getResources(), dog.getAge()));
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
        }
        return true;
    }
}
