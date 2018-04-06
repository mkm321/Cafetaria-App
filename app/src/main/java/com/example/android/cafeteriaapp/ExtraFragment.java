package com.example.android.cafeteriaapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExtraFragment extends Fragment{
    public ExtraFragment(){}
    public  static ArrayList<Food> food;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.item_list, container, false);
        food = new ArrayList<Food>();
        food.add(new Food(R.string.ice30, R.drawable.ice_30,R.string.thirty));
        food.add(new Food(R.string.ice40,R.drawable.ice_40,R.string.fourty));
        food.add(new Food(R.string.ice10,R.drawable.ice10,R.string.ten));
        food.add(new Food(R.string.choco5,R.drawable.munch,R.string.five));
        food.add(new Food(R.string.choco10,R.drawable.star,R.string.ten));
        FoodAdapter adapter = new FoodAdapter(getActivity(),food,R.color.colorPrimary);
        GridView listView = (GridView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
