package com.example.newsapp;

public class News {
    private int id, image;
    private String publisher, title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public News(int id, int image, String publisher, String title) {
        this.id = id;
        this.image = image;
        this.publisher = publisher;
        this.title = title;
    }
}
