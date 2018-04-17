package com.example.akshay.recyclerviewclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrl = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate Started");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmap: Bitmap started");


        mImageUrl.add("https://static.amazon.jobs/locations/23/thumbnails/Bangalore_thumb.jpg?1456283961");
        mNames.add("Bangalore");


        mImageUrl.add("https://lonelyplanetimages.imgix.net/a/g/hi/t/7485b46b2aa78a9c4e8384f3f40dca15-mumbai-bombay.jpg?sharp=10&vib=20&w=1200");
        mNames.add("Mumbai");

        mImageUrl.add("https://i0.wp.com/www.karnataka.com/wp-content/uploads/2011/12/murudeshwar-beach-mangalore.jpg?fit=740%2C431&ssl=1");
        mNames.add("Mangalore");

        mImageUrl.add("http://www.pridehotel.com/blog/wp-content/uploads/2018/01/1-1.jpg");
        mNames.add("Chennai");


        mImageUrl.add("https://media-cdn.tripadvisor.com/media/photo-s/01/85/33/7e/charminar-the-brand-of.jpg");
        mNames.add("Hyderabad");

        mImageUrl.add("https://discoverpune.com/wp-content/uploads/2016/01/heritage-walk-shaniwar-wada.jpg");
        mNames.add("Pune");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: Started");
        RecyclerView recyclerView = findViewById(R.id.rv);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames,mImageUrl,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
