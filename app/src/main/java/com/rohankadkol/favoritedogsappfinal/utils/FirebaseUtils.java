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
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("dogs");
        String key = ref.push().getKey();
        Dog dog = new Dog(key, name, breed, age, imageUrl, notes, likes, dislikes);

        if (key != null) {
            ref.child(key).setValue(dog);
        }
    }

    public static void editDog(Dog dog, String name, String breed, double age, String imageUrl, String notes, String likes, String dislikes) {
        dog.setName(name);
        dog.setBreed(breed);
        dog.setAge(age);
        dog.setImageUrl(imageUrl);
        dog.setNotes(notes);
        dog.setLikes(likes);
        dog.setDislikes(dislikes);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("dogs");

        ref.child(dog.getId()).setValue(dog);
    }

    public static void deleteDog(Dog dog) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("dogs").child(dog.getId());
        ref.removeValue();
    }
}
