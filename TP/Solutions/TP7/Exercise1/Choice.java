package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Choice extends AppCompatActivity {
    TextView text1;

    EditText price;

    RadioButton black, blue;

    String color, a, b, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choice);
        text1 = findViewById(R.id.text1);
        price = findViewById(R.id.price);
        black = findViewById(R.id.black);
        blue = findViewById(R.id.blue);
        Bundle info = getIntent().getExtras();
        if(info!=null){
             a = info.getString("model");
             b = info.getString("brand");
            text1.setText(a);
        }
    }

    public void cancel(View v){
        Intent intent = new Intent();
        intent.putExtra("message", "You have canceled your order");
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    public void _continue(View v){
        if(black.isChecked()){
            color = black.getText().toString();
        }else if(blue.isChecked()){
            color = blue.getText().toString();
        }
        Intent intent = new Intent(this, Order.class);
        intent.putExtra("price", price.getText().toString());
        intent.putExtra("color", color );
        intent.putExtra("model", a);
        intent.putExtra("brand", b);
        startActivityForResult(intent,1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK)
            if (data != null) {
                message = data.getStringExtra("message");

                Intent intent = new Intent();
                intent.putExtra("message", message);
                setResult(RESULT_OK, intent);
                finish();
            }
    }
}

