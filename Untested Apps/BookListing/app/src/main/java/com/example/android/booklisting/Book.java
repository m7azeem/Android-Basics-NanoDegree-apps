package com.example.android.booklisting;

/**
 * Created by Muhammad Azeem on 26/06/2016.
 */
public class Book {

    String title="no book found";
    String Author= "no author found";

    public Book(String title, String author) {
        this.title = title;
        Author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}
