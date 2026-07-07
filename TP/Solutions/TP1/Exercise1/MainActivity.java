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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity {
EditText weight,height;
CheckBox inch;
RadioGroup select;
RadioButton rdMeter,rdCentimeter;
TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight = findViewById(R.id.weight);
        inch = findViewById(R.id.inch);
        height = findViewById(R.id.height);
        select = findViewById(R.id.select);
        rdMeter = findViewById(R.id.rdMeter);
        rdCentimeter = findViewById(R.id.rdCentimeter);
        tvResult = findViewById(R.id.tvResult);
    }

    public void CalculateBMI(View view) {
        String a = weight.getText().toString();
        int weightvalue = Integer.parseInt(a);
        String b = height.getText().toString();
        Double heightvalue = Double.parseDouble(b);
        double BMI = 0;
        if (inch.isChecked()) {
            select.clearCheck();
            BMI = weightvalue * 703 / (heightvalue * heightvalue);
        } else if (rdCentimeter.isChecked()) {
            heightvalue = heightvalue / 100.0;
        } else if (rdMeter.isChecked()) {
            BMI = weightvalue / (heightvalue * heightvalue);
        }

        if(BMI<18.5) {
            tvResult.setText("BMI category: Underweight");
        }
        else if(BMI<20){
            tvResult.setText("BMI category: Normal");
        }
        else if( BMI <30){
            tvResult.setText("BMI category: Overweight");
        }
        else{
            tvResult.setText("BMI category: Obese");
        }
        }

        public void Reset(View view){
            weight.setText("");
            height.setText("");
            inch.setChecked(false);
            select.clearCheck();
            tvResult.setText("Result: You must click on <Calculate BMI> to get a result.");
        }


    }


