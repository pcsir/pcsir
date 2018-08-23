package com.example.shubhankar.pcs_irsap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ConfirmedListAdapter extends RecyclerView.Adapter<ConfirmedListAdapter.MyViewHolder>{

    private List<String> mData;
    private LayoutInflater mInflater;

    ConfirmedListAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }


    @NonNull
    @Override
    public ConfirmedListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = mInflater.inflate(R.layout.confirmed_list_layout, viewGroup, false);
        return new ConfirmedListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        String animal = mData.get(position);
        myViewHolder.mTextView.setText(animal);

    }





    @Override
    public int getItemCount() {
      return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // TODO: whatever views you need to bind
        public TextView mTextView;
       // public ImageView mImageView;

        public MyViewHolder(View v) {
            super(v); // done this way instead of view tagging
            mTextView = (TextView) v.findViewById(R.id.text1);
         //   mImageView = (ImageView) v.findViewById(R.id.imageview);
        }
    }
}
