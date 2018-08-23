package com.example.shubhankar.pcs_irsap;

import android.content.Context;
import android.database.Cursor;
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

    View view;
    DatabaseHelper databaseHelper=DatabaseHelper.getDatabaseHelperInstance();
    ArrayList personNames,sap;
    RecyclerView recyclerView;
    ConfirmedListAdapter confirmedListAdapter;
    LinearLayoutManager linearLayoutManager;
    Cursor cursor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view=inflater.inflate(R.layout.fragment_confirmed, container, false);
        personNames = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7"));

        databaseHelper = new DatabaseHelper(getActivity());

        recyclerView=view.findViewById(R.id.confirmedRecycler);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView

        confirmedListAdapter = new ConfirmedListAdapter(getContext(), personNames);
        recyclerView.setAdapter(confirmedListAdapter); // set the Adapter to RecyclerView
populateListView();


        return view;
    }

    private void populateListView() {
        Log.d("abc", "populateListView: Displaying data in the ListView.");
        ArrayList<String> arrayList = new ArrayList<>();
        confirmedListAdapter = new ConfirmedListAdapter(getContext(),personNames);
        recyclerView.setAdapter(confirmedListAdapter);

        cursor = databaseHelper.getData();
        if(cursor.moveToFirst()){
            do {
                arrayList.add("abc");
            } while (cursor.moveToNext());
        }
        confirmedListAdapter.notifyDataSetChanged();
    }




}
