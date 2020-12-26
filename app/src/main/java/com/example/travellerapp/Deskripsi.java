package com.example.travellerapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Deskripsi extends AppCompatActivity {

    private ImageView image;
    private TextView title,  description, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Description");

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        image = findViewById(R.id.image);
        title = findViewById(R.id.title);
        //description = findViewById(R.id.description);
        //price = findViewById(R.id.price);

        byte[] bytes = getIntent().getByteArrayExtra("image");
        String mtitle = getIntent().getStringExtra("title");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        title.setText(mtitle);
        image.setImageBitmap(bmp);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}