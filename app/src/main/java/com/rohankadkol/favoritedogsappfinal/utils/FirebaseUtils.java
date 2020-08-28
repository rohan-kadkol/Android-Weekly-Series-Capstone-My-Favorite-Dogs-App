package com.rohankadkol.favoritedogsappfinal.utils;

import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rohankadkol.favoritedogsappfinal.MainActivity;
import com.rohankadkol.favoritedogsappfinal.pojos.Dog;

public final class FirebaseUtils {
    private static final String TAG = FirebaseUtils.class.getSimpleName();

    private FirebaseUtils() {}

    public static void addDog(String name, String breed, double age, String imageUrl, String notes, String likes, String dislikes) {
        // TODO (1): Create a FirebaseDatabase instance and call it database
        // FirebaseDatabase database = FirebaseDatabase.getInstance();
        // TODO (2): Using this instance, create a DatabaseReference to the path "dogs". Name it "ref".
        // DatabaseReference ref = database.getReference("dogs");
        // TODO (3): Create a variable called key that stores the key of the new dog.
        // String key = ref.push().getKey();
        // TODO (4): Create a new Dog object using the above key the method parameters
        // Dog dog = new Dog(key, name, breed, age, imageUrl, notes, likes, dislikes);

        // TODO (5): If the key is not null, add the dog object to the "/dogs/<dogId>" path
        // if (key != null) {
        //     ref.child(key).setValue(dog);
        // }
    }

    public static void editDog(Dog dog, String name, String breed, double age, String imageUrl, String notes, String likes, String dislikes) {
        dog.setName(name);
        dog.setBreed(breed);
        dog.setAge(age);
        dog.setImageUrl(imageUrl);
        dog.setNotes(notes);
        dog.setLikes(likes);
        dog.setDislikes(dislikes);

        // TODO (6): Create a FirebaseDatabase instance and call it database
        // FirebaseDatabase database = FirebaseDatabase.getInstance();
        // TODO (7): Using this instance, create a DatabaseReference to the path "dogs". Name it "ref".
        // DatabaseReference ref = database.getReference("dogs");

        // TODO (8): Set the value of the "/dogs/<dogId>" path to the dog variable passed as a parameter
        // ref.child(dog.getId()).setValue(dog);
    }

    public static void deleteDog(Dog dog) {
        // TODO (9): Create a FirebaseDatabase instance and call it database
        // FirebaseDatabase database = FirebaseDatabase.getInstance();
        // TODO (10): Using this instance, create a DatabaseReference to the path "dogs/<dogId>". Name it "ref".
        // DatabaseReference ref = database.getReference("dogs").child(dog.getId());
        // TODO (11): Remove the value at the ref's path
        // ref.removeValue();
    }
}
