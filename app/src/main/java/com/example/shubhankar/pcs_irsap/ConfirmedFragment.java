package com.example.shubhankar.pcs_irsap;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ConfirmedFragment extends Fragment {

    private String localjsonString = "{\"country\":[{\"country_name\":\"country1\",\"capital\":\"capital1\"},{\"country_name\":\"country2\",\"capital\":\"capital2\"},{\"country_name\":\"country3\",\"capital\":\"capital3\"}," +
            "{\"country_name\":\"country4\",\"capital\":\"capital4\"},{\"country_name\":\"country5\",\"capital\":\"capital5\"},{\"country_name\":\"country6\",\"capital\":\"capital6\"}," +
            "{\"country_name\":\"country7\",\"capital\":\"capital7\"},{\"country_name\":\"country8\",\"capital\":\"capital8\"},{\"country_name\":\"country9\",\"capital\":\"capital9\"}," +
            "{\"country_name\":\"country10\",\"capital\":\"capital10\"}]}";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirmed, container, false);
        initList();
        ListView listView = view.findViewById(R.id.confirmedList);

        SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(),countryList,android.R.layout.simple_list_item_1,new String[]{"country"},new int[]{android.R.id.text1});
        listView.setAdapter(simpleAdapter);

        // Inflate the layout for this fragment
        return view;


    }

    List<Map<String, String>> countryList = new ArrayList<Map<String, String>>();


    private void initList() {
        try {
            JSONObject jsonResponse = new JSONObject(localjsonString);
            JSONArray jsonMainNode = jsonResponse.optJSONArray("country");
            for (int i = 0; i < jsonMainNode.length(); i++) {
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                String name = jsonChildNode.optString("country_name");
                String number = jsonChildNode.optString("capital");
                String outPut = name + "--->" + number;
                countryList.add(createEmployee("country", outPut));
            }
        } catch (JSONException e) {
            //Toast.makeText(getApplicationContext(), "Error" + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private HashMap<String, String> createEmployee(String name, String number) {
        HashMap<String, String> employeeNameNo = new HashMap<String, String>();
        employeeNameNo.put(name, number);
        return employeeNameNo;
    }


}
