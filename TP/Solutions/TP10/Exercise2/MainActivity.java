package com.example.workspace;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.preference.PreferenceManager;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void selectPreferences(View v){
        Intent intent = new Intent(MainActivity.this, PreferenceActivity.class);
        startActivity(intent);
    }

    public void showPreferences(View v){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String title = prefs.getString("pref_title","No title");
        String lock = prefs.getString("pref_lock_screen","none");
        boolean activateLanguage = prefs.getBoolean("pref_activate_language", false);
        Set<String> languages = prefs.getStringSet("pref_language", new HashSet<>());

        StringBuilder message = new StringBuilder();

        message.append("Title of Preferences: ").append(title).append("\n");
        message.append("Lock Screen: ").append(lock).append("\n");
        message.append("Activate Language: ").append(activateLanguage ? "Yes" : "No").append("\n");
        message.append("Languages: ").append(languages.isEmpty() ? "None" : TextUtils.join(", ",languages));

        new AlertDialog.Builder(this)
                .setTitle("Detail Preferences")
                .setMessage(message.toString())
                .setPositiveButton("OK", null)
                .show();
    }

    public void deletePreferences(View v){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);


        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
        //or prefs.edit().clear().apply();
        Toast.makeText(this, "Preferences deleted", Toast.LENGTH_SHORT).show();
    }


}

