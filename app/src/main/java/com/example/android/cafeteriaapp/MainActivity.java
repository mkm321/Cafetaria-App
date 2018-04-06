package com.example.android.cafeteriaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextInputLayout password;
    EditText carNumberLogin,passwordLogin;
    String card_number,pass;
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* password = (TextInputLayout) findViewById(R.id.password_input_login);
        password.setHint("Password");*/
         database= FirebaseDatabase.getInstance();
         myRef = database.getReference("users");
        carNumberLogin = (EditText) findViewById(R.id.card_input_edit_login);
        passwordLogin = (EditText) findViewById(R.id.password_input_edit_login);
        Button login = (Button) findViewById(R.id.login_btn_login);
        Button signup = (Button) findViewById(R.id.signup_btn_login);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card_number = carNumberLogin.getText().toString();
                pass = passwordLogin.getText().toString();
                // Read from the database
                myRef.child(card_number).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        User user = dataSnapshot.getValue(User.class);
                        if(user==null){
                            Toast.makeText(getApplicationContext(),"Invalid Card Number",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            if (user.password.equals(pass)) {
                                Toast.makeText(getApplicationContext(), "User Logged in successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,homeActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Invalid password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Toast.makeText(getApplicationContext(),"Invalid card number",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
