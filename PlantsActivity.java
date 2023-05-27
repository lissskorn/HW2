package com.mirea.kt.datastorageapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PlantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants);
        ArrayList<Plants> plants = new ArrayList<>();
        plants.add(new Plants("rose", "rose", true));
        RecyclerView rcView = findViewById((R.id.see));
        PlantsAdapter adapter = new PlantsAdapter(plants);
        rcView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcView.setAdapter((adapter));

    }
}