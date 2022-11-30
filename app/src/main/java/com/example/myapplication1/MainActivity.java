package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button Yes,No;
    TextView fcolor;
    TextView scolor;
    TextView timep;
    int count;
    int right;
    int mode,di;
    String[] textcolor;
    String score;
    Resources res;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Yes=(Button) findViewById(R.id.button1);
        No=(Button) findViewById(R.id.button2);
        fcolor=(TextView) findViewById(R.id.textView3);
        scolor=(TextView) findViewById(R.id.textView4);
        TextView txtseconds = (TextView) findViewById(R.id.textView);
        Button btnStart = (Button) findViewById(R.id.button);
        timep = (TextView) findViewById(R.id.textView8);

        res = getResources();
        textcolor = res.getStringArray(R.array.textcolor);

        right = 0;
        fcolor.setText(textcolor[count]);
        scolor.setText(textcolor[count]);

        di = Integer.parseInt((getIntent().getStringExtra("key1")));

        if(di == 80){
            mode = 80000;
        }
        else if(di == 60){
            mode = 60000;
        }
        else if(di == 30){
            mode = 30000;
        }

        View.OnClickListener oclbtn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountDownTimer my_timer = new CountDownTimer(mode, 1000) {
                    @Override
                    public void onTick(long l) {
                        txtseconds.setText(Long.toString(l / 1000));
                    }

                    @Override
                    public void onFinish() {
                        txtseconds.setText("Игра завершена");
                        score = Integer.toString(right);
                        results();

                    }

                };
                my_timer.start();

                Yes.setOnClickListener(new View.OnClickListener()

                {
                    @Override
                    public void onClick (View v)
                    {
                        if (count <= 5 || fcolor != scolor) {
                            count++;
                            fcolor.setText(textcolor[count]);
                            scolor.setText(textcolor[count]);
                            right++;
                        } else {
                            count = 0;
                            fcolor.setText(textcolor[count]);
                            scolor.setText(textcolor[count]);
                        }


                        Random rnd = new Random();
                        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                        scolor.setTextColor(color);
                    }

                });
                No.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Random rnd = new Random();
                        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                        if (count <= 5 || fcolor == scolor){
                            count++;
                            fcolor.setText(textcolor[count]);
                            scolor.setText(textcolor[count]);
                            right++;
                        }else {
                            count = 0;
                            fcolor.setText(textcolor[count]);
                            scolor.setText(textcolor[count]);

                        }
                        scolor.setTextColor(color);
                    }

                });
            }
        };
        btnStart.setOnClickListener(oclbtn);
    }

    public void results(){
        Intent intent = new Intent(this,result.class);

        intent.putExtra("key",score);
        startActivity(intent);
    }


}

