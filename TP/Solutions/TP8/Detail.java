package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Detail extends AppCompatActivity {

    ListView listView;
    String major, year, language;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        Bundle info = getIntent().getExtras();
        if(info != null){
            major = info.getString("major");
            year = info.getString("year");
            language = info.getString("language");
        }
        String[] details = {major, year, language};
        listView = findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(Detail.this, android.R.layout.simple_list_item_1, details);
        listView.setAdapter(adapter);
    }
    public void close(View v){
        Intent intent = new Intent(Detail.this, Final.class);
        intent.putExtra("actionType", "detail");
        startActivity(intent);
    }

}