package com.example.android.cafeteriaapp;

/**
 * Created by Mohit Mehndiratta on 15-03-2018.
 */

public class User {
    public String password;
    public String email;
    public String cardName;
    public String phone;
    public User(){}
    public User(String password,String email,String cardName,String phone){
        this.cardName=cardName;
        this.email=email;
        this.password=password;
        this.phone=phone;
    }
}
