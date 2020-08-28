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

    }

    public static void editDog(Dog dog, String name, String breed, double age, String imageUrl, String notes, String likes, String dislikes) {
        dog.setName(name);
        dog.setBreed(breed);
        dog.setAge(age);
        dog.setImageUrl(imageUrl);
        dog.setNotes(notes);
        dog.setLikes(likes);
        dog.setDislikes(dislikes);

    }

    public static void deleteDog(Dog dog) {

    }
}
