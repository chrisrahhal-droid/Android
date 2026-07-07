package com.example.exercise1;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
    TextView SelectedCourse;
    ListView courseListView;
    String [] courses = {"Info 400","Info 402","Info 403","Info 407","Info 409","Info 430","Info 433","Info 439"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SelectedCourse = findViewById(R.id.SelectedCourse);
        courseListView = findViewById(R.id.courseListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);
        courseListView.setAdapter(adapter);
        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SelectedCourse.setText(courses[position]);
            }
        });

        }
    }
    