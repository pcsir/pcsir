package com.example.shubhankar.pcs_irsap;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SetViewHolder extends RecyclerView.ViewHolder{
    public TextView textView;
    public SetViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text1);

    }
}
