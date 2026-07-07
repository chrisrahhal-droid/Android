package com.example.exercise1;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends Activity {

    EditText input;
    ListView suggestions;
    String[] courses = {"Info 400", "Info 402", "Info 403", "Info 407", "Info 409", "Info 430", "Info 433", "Info 439",
            "Application Web", "Application Java",
            "Programmation Impérative I", "Programmation Impérative II",
            "XML", "PHP", "HTML", "XHTML"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        uggestions = findViewById(R.id.suggestions);
        adapter = new ArrayAdapter<>(this, android.sR.layout.simple_list_item_1, new ArrayList<>());
        suggestions.setAdapter(adapter);
        input.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                String Letter = s.toString().trim();
                adapter.clear();

                if (Letter.length() == 1) {
                    ArrayList<String> matches = new ArrayList<>();

                    for (String course : courses) {
                        if (course.toLowerCase().startsWith(Letter.toLowerCase())) {
                            matches.add(course);
                        }
                    }
                    adapter.addAll(matches);

                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }
}