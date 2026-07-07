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

public class MainActivity3 extends AppCompatActivity {
    
    TextView text1;
    EditText carModel;
    String carname;
    String carcolor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        carModel = findViewById(R.id.carModel);
        text1 = findViewById(R.id.text1);
        
        Bundle info = getIntent().getExtras();
        if(info!= null) {
            carname = info.getString("carname");
            carcolor = info.getString("color");
        }
    text1.setText("Enter the model of your "+carcolor+" "+carname+" car");
    }
    public void OK(View v){
        Intent intent = new Intent(MainActivity3.this, MainActivity.class);
        intent.putExtra("carName", carname);
        intent.putExtra("carColor", carcolor);
        intent.putExtra("carModel", carModel.getText().toString());
        startActivity(intent);
    }

}