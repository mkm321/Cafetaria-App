package com.example.android.cafeteriaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    String card_number,pass,card_name,email_s,phone_s,pass1,pass2;
    EditText cardNumber,password,confirmPassword,cardName,email,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        cardName = (EditText) findViewById(R.id.card_name_input_edit_signup);
        cardNumber = (EditText) findViewById(R.id.card_input_edit_signup);
        password = (EditText) findViewById(R.id.password_input_edit_signup);
        confirmPassword = (EditText) findViewById(R.id.confirm_password_input_edit_signup);
        email = (EditText) findViewById(R.id.email_input_edit_signup);
        phone = (EditText) findViewById(R.id.phone_input_edit_signup);
        Button fetch = (Button) findViewById(R.id.signup_btn_signup);
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass1=password.getText().toString();
                pass2 = confirmPassword.getText().toString();
                if(!pass1.equals(pass2)){
                    Toast.makeText(getApplicationContext(),"Password didn't match",Toast.LENGTH_SHORT).show();
                }
                else {
                    card_name = cardName.getText().toString();
                    card_number = cardNumber.getText().toString();
                    email_s = email.getText().toString();
                    phone_s = phone.getText().toString();
                    pass = password.getText().toString();
                    if(card_number.isEmpty() || card_number.isEmpty() || email_s.isEmpty()){
                        Toast.makeText(getApplicationContext(),"Fields can not be left empty!",Toast.LENGTH_SHORT).show();
                    }
                    else if(pass.length()<=8){
                        Toast.makeText(getApplicationContext(),"Password minimum length is 8",Toast.LENGTH_SHORT).show();
                    }
                    else if(phone_s.length()!=10){
                        Toast.makeText(getApplicationContext(),"Phone number should be 10 digits.",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        User user = new User(pass, email_s, card_name, phone_s);
                        myRef.child("users").child(card_number).setValue(user);
                        Toast.makeText(getApplicationContext(), "Signed Up succesfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
