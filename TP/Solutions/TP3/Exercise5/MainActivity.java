package com.example.exercise1;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    
    ListView itemsList;
    GridView selectedCourses;
    ArrayAdapter<String> adapter, adapter_G;
    List<String> showedCourses = new ArrayList<>();
    String [] courses ={"Info 400","Info 402", "Info 403","Info 407","Info 409","Info 430","Info 433","Info 439"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsList = findViewById(R.id.itemslist);
        selectedCourses = findViewById(R.id.selectedCourses);

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice,courses);
        itemsList.setAdapter(adapter);
        itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(!showedCourses.contains(courses[position])) {
                    showedCourses.add(courses[position]);
                }
            }
        });
    }

    public void display(View v){
        adapter_G = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,showedCourses);
        selectedCourses.setAdapter(adapter_G);
    }
}

