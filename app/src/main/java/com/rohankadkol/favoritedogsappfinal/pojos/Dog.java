package com.rohankadkol.favoritedogsappfinal.pojos;

public class Dog {
    private String name;
    private String breed;
    private double age;
    private String imageUrl;
    private String description;
    private String likes;
    private String dislikes;

    public Dog() {
    }

    public Dog(String name, String breed, double age, String imageUrl, String description, String likes, String dislikes) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.imageUrl = imageUrl;
        this.description = description;
        this.likes = likes;
        this.dislikes = dislikes;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
