package com.example.akshay.recyclerviewclone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Akshay on 10-02-2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    Context context;

    public RecyclerViewAdapter(ArrayList<String> mImageNames, ArrayList<String> mImages, Context context) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder Called");

        Glide.with(context)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.cimg);

        holder.tvImageName.setText(mImageNames.get(position));
        holder.rlParentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick clicked on:"+ mImageNames.get(position));
                Toast.makeText(context,mImageNames.get(position),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context,GalleryActivity.class);
                intent.putExtra("image_url",mImages.get(position));
                intent.putExtra("image_names",mImageNames.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView cimg;
        TextView tvImageName;
        RelativeLayout rlParentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            cimg = (CircleImageView) itemView.findViewById(R.id.cimg);
            tvImageName = (TextView) itemView.findViewById(R.id.tvImgName);
            rlParentLayout = (RelativeLayout) itemView.findViewById(R.id.rlParentLayout);

        }
    }
}
