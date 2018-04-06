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

public class DrinkFragment extends Fragment{
    public DrinkFragment(){}
    public  static ArrayList<Food> food;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.item_list, container, false);
        food = new ArrayList<Food>();
        food.add(new Food(R.string.cans, R.drawable.cans,R.string.fourty));
        food.add(new Food(R.string.cold_coffee,R.drawable.cold_coffee,R.string.thirty));
        food.add(new Food(R.string.coffee,R.drawable.coffee,R.string.ten));
        food.add(new Food(R.string.tea,R.drawable.tea,R.string.ten));
        food.add(new Food(R.string.cold_drink,R.drawable.cold_drinks,R.string.thf));
        food.add(new Food(R.string.flavoured,R.drawable.flavoured_milk,R.string.twenty));
        food.add(new Food(R.string.fruit,R.drawable.fruit_bears,R.string.thirty));
        food.add(new Food(R.string.ice,R.drawable.iced_tea,R.string.thirty));
        food.add(new Food(R.string.lassi,R.drawable.lassi,R.string.batti));
        food.add(new Food(R.string.milk,R.drawable.milk,R.string.tf));
        food.add(new Food(R.string.red_bull,R.drawable.red_bull,R.string.hundred));
        food.add(new Food(R.string.soya,R.drawable.soya_milk_packet_mr_growth_250x250,R.string.twenty));
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
