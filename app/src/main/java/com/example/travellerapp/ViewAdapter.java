package com.example.travellerapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.listViewHolder> {

    List<ViewModel> view_list;

    private Context context;

    public ViewAdapter(List<ViewModel> viewlist, Context context) {
        view_list = viewlist;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewAdapter.listViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent, false);
        listViewHolder listViewHolder = new listViewHolder(view);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter.listViewHolder holder, final int position) {

        holder.image.setImageResource(view_list.get(position).image_id);
        holder.title.setText(view_list.get(position).title_id);
        holder.desc.setText(view_list.get(position).desc_id);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), Deskripsi.class);
                intent.putExtra("image_id", view_list.get(position).image_id);
                intent.putExtra("title_id", view_list.get(position).title_id);
                intent.putExtra("desc_id", view_list.get(position).desc_id);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return view_list.size();
    }

    public class listViewHolder extends RecyclerView.ViewHolder {

        TextView title, desc;
        ImageView image;
        RelativeLayout relativeLayout;

        public listViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.rTitleTv);
            desc = itemView.findViewById(R.id.rDescTv);
            image = itemView.findViewById(R.id.rImageView);
            relativeLayout = itemView.findViewById(R.id.layout_id);
        }
    }
}
