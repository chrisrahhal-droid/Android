package com.example.myapplication;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText team1, team2;

    TextView result;
    String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        team1 = findViewById(R.id.team1);
        team2 = findViewById(R.id.team2);
        result = findViewById(R.id.result);

    }

    public void next(View v) {
        Intent intent = new Intent(MainActivity.this, Game.class);
        intent.putExtra("team1", team1.getText().toString());
        intent.putExtra("team2", team2.getText().toString());
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && data != null) {
             res = data.getStringExtra("res");
             if(res != null){
                result.setText(res);
                result.setVisibility(View.VISIBLE);
            }
        }
    }
}