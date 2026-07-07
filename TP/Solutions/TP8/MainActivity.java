package com.example.myapplication;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText majorInput;
    Spinner spinner;
    String[] years = {"L1", "L2", "L3", "M1"};
    String selectedYear, selectedLanguage;
    RadioButton french, english;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        majorInput = findViewById(R.id.majorInput);
        french = findViewById(R.id.french);
        english = findViewById(R.id.english);
        spinner = findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(MainActivity.this);
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        selectedYear = years[position];
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void viewDetail(View v) {
        Intent intent = new Intent(MainActivity.this, Detail.class);
        intent.putExtra("major", majorInput.getText().toString());
        intent.putExtra("year", selectedYear);
        if (french.isChecked()) {
            selectedLanguage = "french";
        } else if (english.isChecked()) {
            selectedLanguage = "english";
        }
        intent.putExtra("language", selectedLanguage);
        startActivity(intent);
    }

    public void displaySettings(View v) {
        Intent intent1 = new Intent(MainActivity.this, Final.class);
        intent1.putExtra("actionType", "settings");
        startActivityForResult(intent1, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1) {
            if (resultCode == RESULT_OK) {
                if(data != null) {
                    String name = data.getStringExtra("name");
                    Toast.makeText(MainActivity.this, name + " you changed the settings", Toast.LENGTH_SHORT).show();
                }
                    majorInput.setVisibility(View.GONE);
                    spinner.setEnabled(false);

                }
            else if(resultCode == RESULT_CANCELED){
                majorInput.setVisibility(View.VISIBLE);
                spinner.setEnabled(true);
            }
        }
    }
}