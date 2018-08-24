package com.example.shubhankar.pcs_irsap;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class ConfirmedListAdapter extends RecyclerView.Adapter<SetViewHolder>{

    private Activity activity;
    List<Item> items;

    public ConfirmedListAdapter(Activity activity, List<Item> items){
        this.activity=activity;
        this.items=items;
    }
    @NonNull
    @Override
    public SetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.confirmed_list_layout,viewGroup,false);
        return new SetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SetViewHolder setViewHolder, int i) {
        setViewHolder.textView.setText("hi");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
