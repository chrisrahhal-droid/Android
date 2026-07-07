package com.example.exercise1;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    Spinner yearspinner;
    ListView spinnerList;
    ArrayAdapter<String> adapter,yearadapter;
    String[] years ={"L1","L2","L3","M1"};
    String [] L1 = {"Info 100", "Info 102", "Info 103"};
    String [] L2 = {"Info 200", "Info 202", "Info 203"};
    String [] L3 = {"Info 300", "Info 302", "Info 303"};
    String [] M1 = {"Info 400", "Info 402", "Info 403"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yearspinner = findViewById(R.id.yearspinner);
        spinnerList = findViewById(R.id.spinnerList);
        yearadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,years);
        yearspinner.setAdapter(yearadapter);
        yearspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedYear = years[position];
                String[] selectedCourses;
                switch (selectedYear) {
                    case "L1":
                        selectedCourses = L1;
                        break;
                    case "L2":
                        selectedCourses = L2;
                        break;
                    case "L3":
                        selectedCourses = L3;
                        break;
                    default:
                        selectedCourses = M1;
                        break;
                }
                adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, selectedCourses);
                spinnerList.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerList.setAdapter(null);
            }
        });
    }

}

