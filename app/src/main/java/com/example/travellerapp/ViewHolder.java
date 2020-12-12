package com.example.travellerapp;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder(View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String title, String image){
        TextView mTitleTv = mView.findViewById(R.id.rTitleTv);
        ImageView mImageTv = mView.findViewById(R.id.rImageView);

        mTitleTv.setText(title);
        Picasso.get().load(image).into(mImageTv);

    }
}
