package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityToFragment extends AppCompatActivity {

    EditText text;

    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
    }
    public void show(View v){
        Fragment1 frg1 = new Fragment1();
        Bundle bundle = new Bundle();
        input = text.getText().toString();
        bundle.putString("text",input);
        frg1.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment1Container, frg1).commit();
    }
}
