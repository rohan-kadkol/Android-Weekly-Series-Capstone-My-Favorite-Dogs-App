package com.rohankadkol.favoritedogsappfinal.pojos;

import android.os.Parcel;
import android.os.Parcelable;

public class Dog implements Parcelable {
    public static final double EMPTY_AGE = -1;

    private String id;
    private String name;
    private String breed;
    private double age;
    private String imageUrl;
    private String notes;
    private String likes;
    private String dislikes;

    public Dog() {
    }

    public Dog(String id, String name, String breed, double age, String imageUrl, String notes, String likes, String dislikes) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.imageUrl = imageUrl;
        this.notes = notes;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDislikes() {
        return dislikes;
    }

    public void setDislikes(String dislikes) {
        this.dislikes = dislikes;
    }

    protected Dog(Parcel in) {
        name = in.readString();
        breed = in.readString();
        age = in.readDouble();
        imageUrl = in.readString();
        notes = in.readString();
        likes = in.readString();
        dislikes = in.readString();
    }

    public static final Creator<Dog> CREATOR = new Creator<Dog>() {
        @Override
        public Dog createFromParcel(Parcel in) {
            return new Dog(in);
        }

        @Override
        public Dog[] newArray(int size) {
            return new Dog[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(breed);
        dest.writeDouble(age);
        dest.writeString(imageUrl);
        dest.writeString(notes);
        dest.writeString(likes);
        dest.writeString(dislikes);
    }
}
