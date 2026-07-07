package com.example.myapplication;

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
    
    TextView text1;
    EditText colorinput;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
            text1 = findViewById(R.id.text1);
            colorinput = findViewById(R.id.colorinput);

            Bundle info = getIntent().getExtras();
            if(info != null){
                name = info.getString("carname");
                text1.setText("Enter the color of your car:"+ name);
            }

    }
    public void addModel(View v){
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
        intent.putExtra("color", colorinput.getText().toString());
        intent.putExtra("carname", name);
        startActivity(intent);
    }
}