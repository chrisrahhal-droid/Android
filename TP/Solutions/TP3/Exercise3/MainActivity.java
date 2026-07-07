package com.example.exercise1;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends Activity {

    EditText input;
    ListView words;
    ArrayAdapter<String> adapter;
    ArrayList<String> addedWords= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        words = findViewById(R.id.words);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, addedWords);
        words.setAdapter(adapter);
    }

    public void addAndDelete(View v) {
        String a = input.getText().toString();
        addedWords.add(a);
        if (adapter.isEmpty()) {
            Toast.makeText(this, "The EditText is empty", Toast.LENGTH_SHORT).show();
        } else {
            input.setText("");
        }
    }

    public void showList(View v) {
        if (words.getAdapter().isEmpty()) {
            Toast.makeText(this, "The List is empty", Toast.LENGTH_SHORT).show();
        } else {
            words.setVisibility(View.VISIBLE);
        }
    }
}