package com.example.exercise1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity{
    TextView courseName,courseCode,credits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseName = findViewById(R.id.coursename);
        courseCode = findViewById(R.id.coursecode);
        credits = findViewById(R.id.credits);
        registerForContextMenu(courseCode);
        registerForContextMenu(credits);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.info438) {
            courseName.setText("Course Name: Android, Java");
            courseCode.setText("Course Code:Info 438");
            credits.setText("Credits: 6 Cts");
        } else if (id == R.id.info439) {
            courseName.setText("Course Name: Final project");
            courseCode.setText("Course Code:Info 439");
            credits.setText("Credits: 6 Cts");
        }else if (id == R.id.reset){
            courseName.setText("Course Name:");
            courseCode.setText("Course Code:");
            credits.setText("Credits:");
        }
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        if (v.getId() == R.id.coursecode) {
            inflater.inflate(R.menu.context_menu, menu);

        } else if (v.getId() == R.id.credits) {
            inflater.inflate(R.menu.context_menu1, menu);

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.i2201) {
            courseName.setText("Course Name: HTML");
            courseCode.setText("Course Code:I2201");
            credits.setText("Credits: 3 Cts");
        } else if (id == R.id.i2207) {
            courseName.setText("Course Name: Reseau");
            courseCode.setText("Course Code:I2207");
            credits.setText("Credits: 5 Cts");
        }
     else if (id == R.id.i3302) {
         courseName.setText("Course Name: PHP");
        courseCode.setText("Course Code:I3302");
        credits.setText("Credits: 4 Cts");
    }
     else if (id == R.id.i3350) {
         courseName.setText("Course Name: BDD");
        courseCode.setText("Course Code:I3350");
        credits.setText("Credits: 4 Cts");
        }
            return true;
        }
    }