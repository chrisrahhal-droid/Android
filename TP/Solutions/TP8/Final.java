package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Final extends AppCompatActivity {

    EditText nameInput;

    String actionType1, actionType2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final);
        nameInput = findViewById(R.id.nameInput);
    }

    public void yes(View v) {
        actionType1 = getIntent().getStringExtra("actionType");
        assert actionType1 != null;
        if (actionType1.equals("detail")) {
            Toast.makeText(Final.this, "Thank you " + nameInput.getText().toString(), Toast.LENGTH_SHORT).show();
        } else if (actionType1.equals("settings")) {
            Intent intent = new Intent();
            intent.putExtra("name", nameInput.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    public void cancel(View v) {
        actionType2 = getIntent().getStringExtra("actionType");
        assert actionType2 != null;
        if(actionType2.equals("settings")){
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            finish();
        }
         finish();
    }
}