package com.example.myapplication;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    TextView result;
    EditText carname;
    String name, color, model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
            carname = findViewById(R.id.carname);
            result = findViewById(R.id.result);

            Bundle info = getIntent().getExtras();
            if(info!= null) {
                name = info.getString("carName");
                model = info.getString("carModel");
                color = info.getString("carColor");
                result.setText("Your car is "+name+" the color is "+color+" the model is "+model);
            }
    }
    public void addColor(View v){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("carname", carname.getText().toString());
        startActivity(intent);
    }



}