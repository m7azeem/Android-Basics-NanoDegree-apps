package com.example.android.booktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Book> arrayList = new ArrayList<Book>();



        try {
            final WebService wb = new WebService();
            Thread thread = new Thread(new Runnable() {
                //Log.d("mylogs","webService2");
                @Override
                public void run() {
                    String out = wb.doInBackground("hello");
                    Parser parser = new Parser();
                    Log.d("mylogs","webService7.1");
                    arrayList = parser.parse(out);
                }
            });
            Log.d("mylogs","webService4");
                    /*if (out == "Service not working. Please retry later.") {
                        Log.d("mylogs","webService5");
                        TextView tv = (TextView) findViewById(R.id.output);
                        tv.setText(out);
                        Log.d("mylogs","webService6");
                    } else {*/
            Log.d("mylogs","webService7");

            Log.d("mylogs","webService7.2");
            //Parser parser = new Parser();
            //arrayList = parser.parse(out);
            //TextView tv = (TextView) findViewById(R.id.output);
                    /*Intent buIntent = new Intent(MainActivity.this, DisplayListActivity.class);
                    startActivity(buIntent);*/
            BooksAdapter adapter = new BooksAdapter(this,parser.parse(out);,R.color.colorPrimaryDark);
            ListView listView = (ListView) findViewById(R.id.list);
            listView.setAdapter(adapter);

            Log.d("mylogs","webService7.3");
                        /*String a = Integer.toString(arrayList.size());
                        Log.d("mylogs","the size is "+ a + "full stop.");
                        tv.setText("the size is "+ a + "full stop.");
                        Log.d("mylogs","webService8");*/
            //}
        } catch (Exception e) {
            e.printStackTrace();
            /*TextView tv = (TextView) findViewById(R.id.output);
            tv.setText("error");*/
            Log.d("mylogs","webService9");

        }



    }
}
