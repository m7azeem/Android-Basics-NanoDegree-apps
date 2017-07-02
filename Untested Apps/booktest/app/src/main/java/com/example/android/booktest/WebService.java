package com.example.android.booktest;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Muhammad Azeem on 27/06/2016.
 */
public class WebService extends AsyncTask<String, Integer, String> {
    public final String WEB_SERVER_URL = "https://www.googleapis.com/books/v1/volumes?q=";

    public String RequestGetData(String para)  {
        try {
            URL url = new URL(WEB_SERVER_URL + para + "&maxResults=10&key=AIzaSyCwxs0tEX3PPaVvVRRxpXJLVEQQDHfRR-g");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            String returnMsg = "";

            connection.setDoOutput(false);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setUseCaches(false);

            // Reads the reply from the web service
            int status = connection.getResponseCode();



            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 4.01; Windows NT)");

            if (status== HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String decodedString;


                while ((decodedString = in.readLine()) != null) {
                    returnMsg += decodedString;
                }

                in.close();
                connection.disconnect();

                return returnMsg;
            } else if (status == HttpURLConnection.HTTP_BAD_GATEWAY) {
                Log.d("mylogs", "failed");
                return "Service not working. Please retry later.";
            }


            return returnMsg;
        } catch (Exception e) {
            Log.d("mylogs", e.toString());
            return e.toString();
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        return RequestGetData(strings[0]);
    }
}
