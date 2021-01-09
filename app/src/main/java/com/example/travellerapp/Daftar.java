package com.example.travellerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.smarteist.autoimageslider.SliderView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


public class Daftar extends AppCompatActivity {

    private Button map;
    private Button buy;
    private ImageView cart;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    SliderView sliderView;
    List<ImageSliderModel>imageSliderModelList;
    List<ViewModel> viewlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        imageSliderModelList = new ArrayList<>();
        sliderView = findViewById(R.id.imageSlider);
        map = findViewById(R.id.map);
        buy = findViewById(R.id.buy);
        cart = findViewById(R.id.cart);

        imageSliderModelList.add(new ImageSliderModel(R.drawable.satu));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.dua));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.tiga));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.empat));

        sliderView.setSliderAdapter(new ImageSliderAdapter(this, imageSliderModelList));

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Ticket App");
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mFirebaseDatabase = FirebaseDatabase.getInstance();
        //mRef = mFirebaseDatabase.getReference("Data");

        viewlist= new ArrayList<>();
        viewlist.add(new ViewModel(R.drawable.boro, "Borobudur", "Candi Borobudur terletak di Magelang"));
        viewlist.add(new ViewModel(R.drawable.pra, "Perambanan", "Candi Perambanan terletak di Jogjakarta"));

        ViewAdapter adapter =new ViewAdapter(viewlist, this);
        mRecyclerView.setAdapter(adapter);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Daftar.this, Beli.class);
                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Daftar.this, Beli.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}