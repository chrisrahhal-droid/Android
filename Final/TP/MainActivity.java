package com.example.workstation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;


public class MainActivity extends AppCompatActivity {

    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.message);
    }

    public void add(View v) {
        Intent intent = new Intent(MainActivity.this, SimplePreferences.class);
        startActivity(intent);
    }

    public void show(View v){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isConf = prefs.getBoolean("conf", false);
        if(isConf){
            message.setText("Confirm: Yes");
        }else{
            message.setText("Confirm: No");
        }
    }
}



