package com.example.workstation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    EditText studentName;

    ListView courseList;

    ArrayAdapter<String> adapter;

    TextView chosenCourse;

    CheckBox credits;

    String messageWithCredits="", messageWithoutCredits="";

    String[] courses = {"none", "I2201", "I3350"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        studentName = findViewById(R.id.studentName);
        chosenCourse = findViewById(R.id.chosenCourse);
        credits = findViewById(R.id.credits);
        courseList = findViewById(R.id.courseList);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 ,courses);
        courseList.setAdapter(adapter);
        courseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = studentName.getText().toString();
                if(position == 0){
                    Toast.makeText(MainActivity.this, "Select your course", Toast.LENGTH_SHORT).show();
                }
                else if(position == 1){
                    chosenCourse.setText("I2201:L2");
                    messageWithCredits = "Hello " + name + " your course is i2201 (5 credits), the level is L2";
                    messageWithoutCredits = "Hello " + name + " your course is i2201, The level is L2";
                }else if(position == 2){
                    chosenCourse.setText("I3350:L3");
                    messageWithCredits = "Hello " + name + " your course is i3350 (6 credits), the level is L3";
                    messageWithoutCredits = "Hello " + name + " your course is i3350, the level is L3";
                }
            }
        });
    }

    public void ok(View v) {
        Bundle bundle = new Bundle();
        if (credits.isChecked()) {
            bundle.putString("message", messageWithCredits);
        } else {
            bundle.putString("message", messageWithoutCredits);
        }
        Fragment frag1 = new Fragment1();
        frag1.setArguments(bundle);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment, frag1).commit();
    }
}



