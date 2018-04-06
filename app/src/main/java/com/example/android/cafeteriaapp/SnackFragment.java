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

public class SnackFragment extends Fragment{
    public SnackFragment(){}
    public  static ArrayList<Food> food;
    GridView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.item_list, container, false);
        food = new ArrayList<Food>();
        food.add(new Food(R.string.be, R.drawable.boiled_eggs,R.string.fif));
        food.add(new Food(R.string.burger,R.drawable.burger,R.string.thirty));
        food.add(new Food(R.string.ff,R.drawable.french_fries,R.string.thirty));
        food.add(new Food(R.string.maggi,R.drawable.maggi,R.string.tf));
        food.add(new Food(R.string.noodles,R.drawable.noodles,R.string.thirty));
        food.add(new Food(R.string.pk,R.drawable.paneer_kulcha,R.string.twenty));
        food.add(new Food(R.string.patty,R.drawable.patty,R.string.fif));
        food.add(new Food(R.string.rp,R.drawable.red_pasta,R.string.fifty));
        food.add(new Food(R.string.samosa,R.drawable.samosa,R.string.ten));
        food.add(new Food(R.string.sandwich,R.drawable.sandwich,R.string.twenty));
        food.add(new Food(R.string.wp,R.drawable.white_pasta,R.string.fifty));
        FoodAdapter adapter = new FoodAdapter(getActivity(),food,R.color.colorPrimary);
        listView = (GridView) rootView.findViewById(R.id.list);
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
