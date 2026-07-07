package com.example.exercise1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity{

    EditText name;
    TextView message;
    String course,grade;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        message = findViewById(R.id.message);
    }

    public void addGrade(View v){
        String n = name.getText().toString();
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("name",n);
        startActivityForResult(intent,1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        
                if(resultCode == RESULT_OK) {
                    Bundle info = data.getExtras();
                    if (info != null) {
                        course = info.getString("mycourse");
                        grade = info.getString("mygrade");
                    }
                    message.setText("Your course is " + course + " and your grade is " + grade);
                }else if(resultCode == RESULT_CANCELED){
                    message.setText("You didn't enter your course and your grade");
                    return;
                }
        }
}


