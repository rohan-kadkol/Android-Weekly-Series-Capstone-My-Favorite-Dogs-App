package com.rohankadkol.favoritedogsappfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.textfield.TextInputLayout;
import com.rohankadkol.favoritedogsappfinal.pojos.Dog;
import com.rohankadkol.favoritedogsappfinal.utils.FirebaseUtils;
import com.rohankadkol.favoritedogsappfinal.utils.StringUtils;

public class AddEditActivity extends AppCompatActivity {
    boolean mIsAdd;

    TextInputLayout tilName;
    TextInputLayout tilBreed;
    TextInputLayout tilAge;
    TextInputLayout tilImageUrl;
    TextInputLayout tilLikes;
    TextInputLayout tilDislikes;
    TextInputLayout tilNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        tilName = findViewById(R.id.til_name);
        tilBreed = findViewById(R.id.til_breed);
        tilAge = findViewById(R.id.til_age);
        tilImageUrl = findViewById(R.id.til_image_url);
        tilLikes = findViewById(R.id.til_likes);
        tilDislikes = findViewById(R.id.til_dislikes);
        tilNotes = findViewById(R.id.til_notes);

        setupIsAdd();
        setupTitle();
        setupActionBar();

        if (!mIsAdd) {
            Dog dog = getIntent().getParcelableExtra(getString(R.string.dog_key));
            populateFields(dog);
        }
    }

    private void setupIsAdd() {
        String addEdit = getIntent().getStringExtra(getString(R.string.add_edit_key));
        mIsAdd = addEdit.equals(getString(R.string.add_key));
    }

    private void setupTitle() {
        String addEdit = getIntent().getStringExtra(getString(R.string.add_edit_key));
        boolean isAdd = addEdit.equals(getString(R.string.add_key));
        if (isAdd) {
            setTitle(getString(R.string.add_page_title));
        } else {
            setTitle(getString(R.string.edit_page_title));
        }
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_edit_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        } else if (item.getItemId() == R.id.action_save) {
            if (validateDog()) {
                addDog();
                this.finish();
            }
        }
        return true;
    }

    private void addDog() {
        String name = tilName.getEditText().getText().toString().trim();
        String breed = tilBreed.getEditText().getText().toString().trim();
        String imageUrl = tilImageUrl.getEditText().getText().toString().trim();
        String likes = tilLikes.getEditText().getText().toString().trim();
        String dislikes = tilDislikes.getEditText().getText().toString().trim();
        String notes = tilNotes.getEditText().getText().toString().trim();

        String ageString = tilAge.getEditText().getText().toString().trim();
        double age = TextUtils.isEmpty(ageString) ? Dog.EMPTY_AGE : Double.parseDouble(ageString);

        FirebaseUtils.addDog(name, breed, age, imageUrl, notes, likes, dislikes);
    }

    private boolean validateDog() {
        String name = tilName.getEditText().getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            tilName.setError(getString(R.string.required_field_label));
            return false;
        }
        return true;
    }

    public void populateFields(Dog dog) {
        tilName.getEditText().setText(dog.getName());
        tilBreed.getEditText().setText(dog.getBreed());
        tilAge.getEditText().setText(StringUtils.getAgeFormString(dog.getAge()));
        tilImageUrl.getEditText().setText(dog.getImageUrl());
        tilLikes.getEditText().setText(dog.getLikes());
        tilDislikes.getEditText().setText(dog.getDislikes());
        tilNotes.getEditText().setText(dog.getNotes());
    }
}
