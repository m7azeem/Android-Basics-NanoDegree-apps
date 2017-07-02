package com.example.android.booktest;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Muhammad Azeem on 27/06/2016.
 */
public class Parser {

    public ArrayList<Book> books = new ArrayList<Book>();
    private static final String TAG = "MyActivity";


    public ArrayList<Book> parse(String JsonData1){
        try {
            JSONObject jObject = new JSONObject(JsonData1);
            JSONArray jArray = jObject.getJSONArray("items");
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jArt = (JSONObject) jArray.get(i);
                //JSONObject jArticle = jArray.getJSONObject(i);
                JSONObject jArticle = jArt.getJSONObject("volumeInfo");
                String title = jArticle.getString("title");
                String author = jArticle.getJSONArray("authors").toString();
                System.out.println("hello" + title);
                //adding to arraylist
                books.add(new Book(title, author));


                Log.v(TAG,"aaaa"+books.get(i).getTitle()+"aaaa"+books.get(i).getAuthor()+"aaaa");
            }

        } catch (JSONException e) {

            e.printStackTrace();
            /*e.toString()*/
        }

        return books;
    }
}