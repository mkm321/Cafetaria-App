package com.example.android.cafeteriaapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food>{
    TextView Name;
    Button button;
    Button add;
    Button sub;
    TextView qty;
    int quant;
    public FoodAdapter(Context context, ArrayList<Food> foods, int a){
        super(context,0,foods);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Food local_word = getItem(position);
         Name= (TextView) listItemView.findViewById(R.id.name_list_item);
        Name.setText(local_word.getName());
        ImageView image = (ImageView) listItemView.findViewById(R.id.iv_list_item);
        image.setImageResource(local_word.getImageResourceId());
        TextView price = (TextView) listItemView.findViewById(R.id.pr_list_item);
        price.setText(local_word.getPrice());
        qty = (TextView) listItemView.findViewById(R.id.qty_edit_text);
        add = (Button) listItemView.findViewById(R.id.add_button);
        sub = (Button) listItemView.findViewById(R.id.sub_button);
        button = (Button) listItemView.findViewById(R.id.btn);
        final View finalListItemView = listItemView;
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty = (TextView) finalListItemView.findViewById(R.id.qty_edit_text);
                quant= Integer.parseInt(qty.getText().toString());
                quant++;
                qty.setText(Integer.toString(quant));
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty = (TextView) finalListItemView.findViewById(R.id.qty_edit_text);
                quant= Integer.parseInt(qty.getText().toString());
                if(quant>0) {
                    quant--;
                    qty.setText(Integer.toString(quant));
                }
                else{
                    Toast.makeText(getContext(),"Quantity cannot be less than 0",Toast.LENGTH_SHORT).show();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty = (TextView) finalListItemView.findViewById(R.id.qty_edit_text);
                quant= Integer.parseInt(qty.getText().toString());
               Name = (TextView) finalListItemView.findViewById(R.id.name_list_item);
               String s = Name.getText().toString();
               if(quant==0){
                   Toast.makeText(getContext(),"Quantity must be more than 0",Toast.LENGTH_SHORT).show();
               }
               else {
                   qty.setText("0");
                   Toast.makeText(getContext(), "I'm clicked " + s, Toast.LENGTH_SHORT).show();
               }
            }
        });
        return listItemView;
    }
}
