package com.example.workspace;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {
    TextView nameTextView, musicTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(
                R.id.toolbar);
        setSupportActionBar(toolbar);


         nameTextView = findViewById(R.id.name);
         musicTextView = findViewById(R.id.music);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.selectPreference){
            Intent intent = new Intent(MainActivity.this, PreferenceActivity.class);
            startActivity(intent);
            return true;
        }
        if(item.getItemId() == R.id.title){
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.apply();

            nameTextView.setText("Your name is: No name set ");
            musicTextView.setText("Do you prefer music? No");

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onResume(){
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String name = prefs.getString("pref_name", "No name set");
        boolean music = prefs.getBoolean("pref_music", false);

        nameTextView.setText("Your name is: "+name);
        musicTextView.setText("Do you prefer music: "+(music ? "yes": "no"));


    }


}

