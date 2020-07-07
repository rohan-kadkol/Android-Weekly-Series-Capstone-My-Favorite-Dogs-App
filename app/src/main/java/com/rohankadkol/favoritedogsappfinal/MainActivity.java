package com.rohankadkol.favoritedogsappfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rohankadkol.favoritedogsappfinal.adapters.DogsAdapter;
import com.rohankadkol.favoritedogsappfinal.pojos.Dog;
import com.rohankadkol.favoritedogsappfinal.utils.FirebaseUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DogsAdapter.DogClickInterface {
    private static final String TAG = MainActivity.class.getSimpleName();
    List<Dog> dogs = new ArrayList<>();

    DogsAdapter mDogsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Dog dog = new Dog("Bobby", "German Shepherd", 2.5, "https://upload.wikimedia.org/wikipedia/commons/d/d0/German_Shepherd_-_DSC_0346_%2810096362833%29.jpg", "Good Dog", "Belly rubs", "Touching his face");
//        dogs.add(dog);
//        dogs.add(dog);
//        dogs.add(dog);
//        dogs.add(dog);
//        dogs.add(dog);
//        dogs.add(dog);
//        dogs.add(dog);
//        dogs.add(dog);
//        dogs.add(dog);
//        dogs.add(dog);
//        dogs.add(dog);
//        dogs.add(dog);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("dogs1");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Dog> dogs = new ArrayList<>();
                Dog dog;
                for(DataSnapshot s : snapshot.getChildren()) {
                    dog = s.getValue(Dog.class);
                    dogs.add(dog);
                }
                mDogsAdapter.updateDogs(dogs);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        setupRecyclerView();
        setupFab();

//        FirebaseUtils.addDog(dog);
    }

    private void setupRecyclerView() {
        RecyclerView rvDogs = findViewById(R.id.rv_dogs);
        mDogsAdapter = new DogsAdapter(this, dogs, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);

        rvDogs.setAdapter(mDogsAdapter);
        rvDogs.setLayoutManager(manager);
        rvDogs.setHasFixedSize(true);
        rvDogs.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void setupFab() {
        FloatingActionButton fab = findViewById(R.id.fab_new_dog);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditActivity.class);
                intent.putExtra(getString(R.string.add_edit_key), getString(R.string.add_key));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(Dog dog) {
        Intent intent = new Intent(this, DogActivity.class);
        intent.putExtra(getString(R.string.dog_key), dog);
        startActivity(intent);
    }
}
