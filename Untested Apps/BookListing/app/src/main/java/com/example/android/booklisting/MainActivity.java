package com.example.android.booklisting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Book> arrayList;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<Book>();




        Button yourButton = (Button) new View(getBaseContext()).findViewById(R.id.button);
        //set onclicklistener for your button
        yourButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        useWebService();
                    }
                });












        //useWebService();


        /*BooksAdapter adapter = new BooksAdapter(this, arrayList, R.color.colorAccent);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);*/

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void useWebService() {
        Log.d("mylogs","webService1");
        Thread thread = new Thread(new Runnable() {
            //Log.d("mylogs","webService2");
            @Override
            public void run() {
                Log.d("mylogs","webService3");
                try {
                    WebService wb = new WebService();
                    String out = wb.doInBackground("hello");
                    Log.d("mylogs","webService4");
                    if (out == "Service not working. Please retry later.") {
                        TextView tv = (TextView) findViewById(R.id.output);
                        tv.setText(out);
                    } else {
                        com.example.android.booklisting.Parser parser = new com.example.android.booklisting.Parser();
                        arrayList = parser.parse(out);
                        //Parser parser = new Parser();
                        //arrayList = parser.parse(out);
                        /*TextView tv = (TextView) findViewById(R.id.output);
                        String a = Integer.toString(arrayList.size());
                        tv.setText("the size is "+ a + "full stop");*/
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
