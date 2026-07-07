package com.example.myapplication;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Game extends AppCompatActivity {

    RadioButton yes, no;
    CheckBox fin;
    TextView team1, team2;
    String team1in, team2in;
    RadioGroup radiog;
    EditText score1, score2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        team1 = findViewById(R.id.team1);
        team2 = findViewById(R.id.team2);
        fin = findViewById(R.id.fin);
        radiog = findViewById(R.id.radiog);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
            Bundle info = getIntent().getExtras();
            if(info!=null){
                team1in = info.getString("team1");
                team2in = info.getString("team2");
                team1.setText(team1in);
                team2.setText(team2in);
            }

    }
    public void finalf(View v){
        if(fin.isChecked()) {
            radiog.setVisibility(View.VISIBLE);
        }else {
            radiog.setVisibility(View.GONE);
        }
        }
    public void cancel(View v) {

        Intent intent = new Intent(this, MainActivity.class);

        if (yes.isChecked()) {
            intent.putExtra("res", "Final match canceled");
        } else if (no.isChecked() || !fin.isChecked()) {
            intent.putExtra("res", "Game canceled");
        }

        setResult(RESULT_CANCELED, intent);
        finish();
    }


    public void end(View v){
        String a, b;
        a = score1.getText().toString();
        b = score2.getText().toString();
        int sc1 = Integer.parseInt(a);
        int sc2 = Integer.parseInt(b);

        if(sc1 == sc2){
            Toast.makeText(this, "equality is not allowed", LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, MainActivity.class);
            if(sc1 > sc2) {
                intent.putExtra("res", "The winner is "+team1.getText().toString());
            }else{
                intent.putExtra("res", "The winner is "+team2.getText().toString());
            }
            setResult(RESULT_OK, intent);
            finish();
        }

    }

}
