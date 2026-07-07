package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import android.os.Bundle;

public class Account extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Fragment1 fragment1 = new Fragment1();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment1, fragment1).commit();
    }
}
