package com.example.exercise1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    RadioButton Male,Female;
    EditText Height;

    TextView wResult;
    double weight = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Male = findViewById(R.id.Male);
        Female = findViewById(R.id.Female);
        Height = findViewById(R.id.Height);
        wResult = findViewById(R.id.wResult);
    }
    public void calculate(View v){
        String wr = wResult.getText().toString();
        String a = Height.getText().toString();
        double h = Double.parseDouble(a);
        if(Male.isChecked()){
            weight = h - 100 - ((h - 150) / 4);
        }
        else if(Female.isChecked()){
            weight = h - 100 -((h - 150 ) / 2);
        }

        wResult.setText(String.valueOf(weight));
    }
}


