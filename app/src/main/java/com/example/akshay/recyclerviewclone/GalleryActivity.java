package com.example.akshay.recyclerviewclone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Akshay on 12-02-2018.
 */

public class GalleryActivity extends AppCompatActivity{
    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: Gallery activity called");
        getIncomingIntent();
    }
    
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intent");

        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_names")){
            Log.d(TAG, "getIncomingIntent: found intent extras");
            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_names");

            setImage(imageUrl,imageName);
        }
    }

    private void setImage(String imageUrl,String imageName){
        Log.d(TAG, "setImage: Setting image and name to widgets");

        TextView tvImageDescription = (TextView) findViewById(R.id.tvImageDescription);
        tvImageDescription.setText("This is the pictutre of "+imageName);

        ImageView imgImage = (ImageView) findViewById(R.id.imgImage);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(imgImage);
    }
}
