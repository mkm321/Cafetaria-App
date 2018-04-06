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

public class IndianFragment extends Fragment{
    public IndianFragment(){}
    public  static ArrayList<Food> food;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.item_list, container, false);
        food = new ArrayList<>();
        food.add(new Food(R.string.anaan, R.drawable.amritsari_naan,R.string.fif));
        food.add(new Food(R.string.bc,R.drawable.butter_chicken,R.string.of));
        food.add(new Food(R.string.bnaan,R.drawable.butter_naan,R.string.fif));
        food.add(new Food(R.string.cs,R.drawable.chicken_seekh,R.string.of));
        food.add(new Food(R.string.cb,R.drawable.chole_bhature,R.string.fifty));
        food.add(new Food(R.string.chole,R.drawable.chole,R.string.tf));
        food.add(new Food(R.string.dmc,R.drawable.dal_makhani_combo,R.string.fifty));
        food.add(new Food(R.string.dm,R.drawable.dal_makhani,R.string.tf));
        food.add(new Food(R.string.lp,R.drawable.lacha_prantha,R.string.ten));
        food.add(new Food(R.string.mfr,R.drawable.manchurian_fried_rice,R.string.fifty));
        food.add(new Food(R.string.md,R.drawable.masala_dosa,R.string.fifty));
        food.add(new Food(R.string.mv,R.drawable.mix_veg,R.string.tf));
        food.add(new Food(R.string.nc,R.drawable.naan_chole,R.string.fifty));
        food.add(new Food(R.string.plc,R.drawable.paneer_lababdar_combo,R.string.seventy));
        food.add(new Food(R.string.pl,R.drawable.paneer_lababdar,R.string.fifty));
        food.add(new Food(R.string.pb,R.drawable.pav_bhaji,R.string.fourty));
        food.add(new Food(R.string.pn,R.drawable.plain_naan,R.string.ten));
        food.add(new Food(R.string.rc,R.drawable.rajmah_chawal,R.string.fifty));
        food.add(new Food(R.string.rice,R.drawable.rice,R.string.ten));
        food.add(new Food(R.string.roti,R.drawable.roti,R.string.five));
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
