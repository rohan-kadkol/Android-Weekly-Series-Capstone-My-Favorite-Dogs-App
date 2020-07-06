package com.rohankadkol.favoritedogsappfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rohankadkol.favoritedogsappfinal.adapters.DogsAdapter;
import com.rohankadkol.favoritedogsappfinal.pojos.Dog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Dog> dogs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dog dog = new Dog("Bobby", "German Shepherd", 2.5, "https://upload.wikimedia.org/wikipedia/commons/d/d0/German_Shepherd_-_DSC_0346_%2810096362833%29.jpg", "Good Dog", "Belly rubs", "Touching his face");
        dogs.add(dog);
        dogs.add(dog);
        dogs.add(dog);
        dogs.add(dog);
        dogs.add(dog);
        dogs.add(dog);
        dogs.add(dog);
        dogs.add(dog);
        dogs.add(dog);
        dogs.add(dog);
        dogs.add(dog);
        dogs.add(dog);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView rvDogs = findViewById(R.id.rv_dogs);
        DogsAdapter adapter = new DogsAdapter(this, dogs);
        LinearLayoutManager manager = new LinearLayoutManager(this);

        rvDogs.setAdapter(adapter);
        rvDogs.setLayoutManager(manager);
        rvDogs.setHasFixedSize(true);
    }
}
