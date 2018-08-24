package com.example.sandy.online_reservstion_system;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b,b1;
TextView tv;
EditText et1,et2;
DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=findViewById(R.id.button);
    b1=findViewById(R.id.button2);
    tv=findViewById(R.id.textView3);
    mydb=new DatabaseHelper(this);
    et1=(EditText)findViewById(R.id.editText2);
        et2=(EditText)findViewById(R.id.editText);
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(getApplicationContext(),signup.class);
            startActivity(i);
        }
    });

b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      String y=et2.getText().toString();
      String p=et1.getText().toString();
        Cursor cur=mydb.ShowData(y,p);
        if(cur!=null) {
            if(cur.getCount()>0) {
                cur.moveToFirst();
                Intent j = new Intent(getApplicationContext(), Login.class);
                startActivity(j);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Either username or password entered is wrong", Toast.LENGTH_LONG).show();
            }
        }
    }
});
tv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
     Intent i=new Intent(getApplicationContext(),forgot_password.class);
     startActivity(i);
    }
});


    }}

