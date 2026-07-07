package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Order extends AppCompatActivity {
    String price, color, model, brand, h="", c;
    Integer totalPrice = 0;
    CheckBox headphones, charger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);
        headphones = findViewById(R.id.headphones);
        charger = findViewById(R.id.charger);
        Bundle info = getIntent().getExtras();
        if(info!= null){
            price = info.getString("price");
            color = info.getString("color");
            model = info.getString("model");
            brand = info.getString("brand");
        }
    }
    public void _return(View v){
        finish();
    }
    public void order(View v){

        totalPrice += Integer.parseInt(price);
        if(headphones.isChecked()){
            h += "Headphones";
            totalPrice += 20;
        }
        if(charger.isChecked()){
            h += " Charger";
            totalPrice += 10;
        }

        Intent intent = new Intent();
        intent.putExtra("message", brand+" "+model+" "+color+" "+h+" "+totalPrice);

        setResult(RESULT_OK,intent);

        finish();

    }
}