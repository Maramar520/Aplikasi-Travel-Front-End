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

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClickListener.onItemLongClick(v, getAdapterPosition());
                return true;
            }
        });
    }

    public void setDetails(Context ctx, String title, String image){
        TextView mTitleTv = mView.findViewById(R.id.rTitleTv);
        ImageView mImageTv = mView.findViewById(R.id.rImageView);

        mTitleTv.setText(title);
        Picasso.get().load(image).into(mImageTv);

    }

    private ViewHolder.ClickListener mClickListener;

    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);


    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}
