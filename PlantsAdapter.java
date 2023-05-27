package com.mirea.kt.datastorageapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlantsAdapter extends RecyclerView.Adapter<PlantsAdapter.ViewHolder> {

    private ArrayList<Plants> plants;
     public PlantsAdapter(ArrayList<Plants> plant) {
         this.plants = plant;
     }
     public static class ViewHolder extends RecyclerView.ViewHolder {
         private final TextView nameView;
         private final TextView varietyView;
         private final TextView typeView;

         ViewHolder(View View) {
             super(View);
             nameView = View.findViewById(R.id.name);
             varietyView = View.findViewById(R.id.variety);
             typeView = View.findViewById(R.id.type);
         }
     }
    @NonNull
    @Override
    public PlantsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.item_plants), parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         Plants plant = plants.get(position);
         holder.nameView.setText(String.format("%s %s", plant.getName(), plant.getVariety(), plant.getType()));


    }

    @Override
    public int getItemCount() {
        return plants.size();
    }
}
