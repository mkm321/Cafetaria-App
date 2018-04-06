package com.example.android.cafeteriaapp;

public class Food {
    private int Name;
    private int imageId;
    private  int price;
    public Food(int Name1, int resource,int p){
        Name=Name1;
        imageId=resource;
        price=p;
    }
    public  int getName(){
        return Name;
    }
    public int getImageResourceId(){
        return imageId;
    }
    public int getPrice(){ return price;}
}
