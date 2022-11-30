package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class result extends AppCompatActivity {
    TextView message;
    TextView otvet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        message = (TextView) findViewById(R.id.textView5);
        otvet = (TextView) findViewById(R.id.textView6);

        otvet.setText(getIntent().getStringExtra("key"));



    }

    public void backgame(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }




}