package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class start extends AppCompatActivity {
    Button start, menu,popmenu;
    TextView diff;
    String diffu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        start = (Button) findViewById(R.id.button5);
        menu = (Button) findViewById(R.id.button6);
        diff = (TextView) findViewById(R.id.textView7);
        popmenu = (Button) findViewById(R.id.button8);
        registerForContextMenu(menu);
        addListenerOnButton();

        //Init PopupMenu
        PopupMenu popupMenu = new PopupMenu(
                this,
                popmenu);

        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.seconds_80) {

                } else if (id == R.id.seconds_60) {

                } else if (id == R.id.seconds_45) {
                }

                return false;
            }
        });

        popmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenu.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.time_menu, menu);
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.difficulty_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.easy:
                diff.setText("80");

                break;
            case R.id.medium:
                diff.setText("60");

                break;
            case R.id.hard:
                diff.setText("30");

                break;

        }

        return super.onOptionsItemSelected(item);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.easy:
                diff.setText("80");
                return true;
            case R.id.medium:
                diff.setText("60");
                return true;
            case R.id.hard:
                diff.setText("30");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    private void addListenerOnButton() {
        start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        diffu = diff.getText().toString();
                        next();


                    }
                }
        );
    }

    public void next(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("key1", diffu);
        startActivity(intent);
    }
}

