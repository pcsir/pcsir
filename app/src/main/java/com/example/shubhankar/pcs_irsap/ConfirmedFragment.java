package com.example.shubhankar.pcs_irsap;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import com.example.shubhankar.pcs_irsap.DatabaseHelper;


public class ConfirmedFragment extends Fragment {

    private RecyclerView recyclerView;
    private DatabaseHelper databaseHelper;
    private ArrayList<Item> arrayList = new ArrayList<Item>();
    private Cursor cursor;
    private ConfirmedListAdapter confirmedListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.confirmed_list_layout,container,false);
        recyclerView = viewGroup.findViewById(R.id.confirmedRecycler);
        loadDatabase();
        return viewGroup;
    }

    public void loadDatabase(){
        databaseHelper = new DatabaseHelper(getActivity());
        try {
            databaseHelper.checkAndCopyDatabse();
            databaseHelper.openDatabse();
        }catch (SQLiteException e){
            e.printStackTrace();
        }

        try {

            cursor = databaseHelper.QueryData("select * from");
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        Item item = new Item();
                        item.setName(cursor.getString(1));
                        arrayList.add(item);
                    } while (cursor.moveToNext());
                }
            }
        }catch (SQLiteException e){
            e.printStackTrace();
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        confirmedListAdapter = new ConfirmedListAdapter(getActivity(),arrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(confirmedListAdapter);



    }





}
