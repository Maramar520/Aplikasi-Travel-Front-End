package com.example.travellerapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Deskripsi extends AppCompatActivity {

    private ImageView imagedesc;
    private TextView titledesc,  descriptiondesc;
    private Button cancel1, get1;
    private ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Description");

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        imagedesc = findViewById(R.id.image);
        titledesc = findViewById(R.id.title);
        descriptiondesc = findViewById(R.id.description);
        cancel1 = findViewById(R.id.cancel);
        get1 = findViewById(R.id.get);
        cart = findViewById(R.id.imageView1);

        imagedesc.setImageResource(getIntent().getExtras().getInt("image_id"));
        titledesc.setText(getIntent().getExtras().getString("title_id"));
        descriptiondesc.setText(getIntent().getExtras().getString("desc_id"));

        cancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Deskripsi.this, Daftar.class);
                startActivity(intent);
            }
        });

        get1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Deskripsi.this, Beli.class);
                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Deskripsi.this, Beli.class);
                startActivity(intent);
            }
        });

    }
}