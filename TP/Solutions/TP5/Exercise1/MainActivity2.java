package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    
    TextView welcome;
    EditText course,grade;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        course = findViewById(R.id.course);
        welcome = findViewById(R.id.welcome);
        grade = findViewById(R.id.grade);

        Bundle info = getIntent().getExtras();
        if(info != null){
            name = info.getString("name");
            welcome.setText("Hello "+name+" Enter the course and your grade");
        }
    }
    public void result(View v){
        Intent resultIntent = new Intent();
        resultIntent.putExtra("mycourse", course.getText().toString());
        resultIntent.putExtra("mygrade", grade.getText().toString());
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    public void cancel(View v){
        setResult(RESULT_CANCELED);
        finish();
    }
}