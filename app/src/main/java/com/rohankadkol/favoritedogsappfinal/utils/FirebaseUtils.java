package com.rohankadkol.favoritedogsappfinal.utils;

import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rohankadkol.favoritedogsappfinal.MainActivity;
import com.rohankadkol.favoritedogsappfinal.pojos.Dog;

public final class FirebaseUtils {
    private FirebaseUtils() {}

    public static void addDog(String name, String breed, double age, String imageUrl, String notes, String likes, String dislikes) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("dogs1");
        String key = ref.push().getKey();
        Dog dog = new Dog(key, name, breed, age, imageUrl, notes, likes, dislikes);

        if (key != null) {
            ref.child(key).setValue(dog);
        }
    }
}
