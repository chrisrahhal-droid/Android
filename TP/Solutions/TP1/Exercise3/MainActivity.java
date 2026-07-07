package com.example.exercise1;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
    RadioButton Temperature,Currency,Radio1,Radio2;
    EditText Value;
    TextView Result;
    double value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Temperature = findViewById(R.id.Temperature);
        Currency = findViewById(R.id.Currency);
        Radio1 = findViewById(R.id.Radio1);
        Radio2 = findViewById(R.id.Radio2);
        Value = findViewById(R.id.Value);
        Result = findViewById(R.id.Result);
    }
    public void updateLabels(View v){
        if(Temperature.isChecked()){
            Radio1.setChecked(true);
            Radio1.setText("C-F");
            Radio2.setText("F-C");
        }

        else if(Currency.isChecked()){
            Radio1.setChecked(true);
            Radio1.setText("Dollar-Euro");
            Radio2.setText("Euro-Dollar");
        }
    }
    public void convert(View v){
        String a = Value.getText().toString();
        double val = Double.parseDouble(a);
        if(Temperature.isChecked() ){
            if(Radio1.isChecked()) {
                val = 9/5 * val + 32;
            }
            else if(Radio2.isChecked()){
                val = (val-32)*5/9;
            }
        }
        else if(Currency.isChecked()) {
            if (Radio1.isChecked()) {
                val = 1.05 * val;
            } else if (Radio2.isChecked()) {
                val = 0.9 * val;
            }
        }
        Result.setText("Result :" + String.valueOf(val));
    }
}

