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

public class BreakfastFragment extends Fragment {
    public  static ArrayList<Food> food;
    public BreakfastFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.item_list, container, false);
        food = new ArrayList<Food>();
        food.add(new Food(R.string.allu, R.drawable.allu_prantha,R.string.thirty));
        food.add(new Food(R.string.gobi,R.drawable.gobi_prantha,R.string.thirty));
        food.add(new Food(R.string.paneer,R.drawable.paneer_prantha,R.string.thirty));
        food.add(new Food(R.string.pyaaz,R.drawable.pyaaz_prantha,R.string.thirty));
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
