    package com.example.exercise1;
    import android.animation.ArgbEvaluator;
    import android.app.AlertDialog;
    import android.content.DialogInterface;
    import android.graphics.Color;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;
    import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {
        EditText DisableMe;
        TextView HideMe,Colorme;

        Button Disable,Green,Close;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            HideMe = findViewById(R.id.HideMe);
            DisableMe = findViewById(R.id.DisableMe);
            Disable = findViewById(R.id.Disable);
            Colorme = findViewById(R.id.Colorme);
            Green = findViewById(R.id.Green);
            Close = findViewById(R.id.Close);
        }

        public void hide(View v){
            HideMe.setVisibility(View.INVISIBLE);

        }
        public void show(View v){
            HideMe.setVisibility(View.VISIBLE);
        }
        boolean a = false;
        public void disable(View v){
                if(!a){
                    DisableMe.setEnabled(false);
                    DisableMe.setText("Enable Me");
                    Disable.setText("Enable");
                    a = true;
                }
                else{
                    DisableMe.setEnabled(true);
                    DisableMe.setText("Disable Me");
                    Disable.setText("Disable");
                    a = false;
                }
            }
            String color = "g";
            public void green(View v){
                if(color.equals("g")) {
                    Colorme.setBackgroundColor(Color.parseColor("#00FF00"));
                    Green.setText("Red");
                    color = "r";
                }
                else if(color.equals("r")){
                    Colorme.setBackgroundColor(Color.parseColor("#FF0000"));
                    Green.setText("Blue");
                    color = "b";
                }
                else if(color.equals("b")){

                    Colorme.setBackgroundColor(Color.parseColor("#0000FF"));
                    Green.setText("Green");
                    color = "g";
                }
            }
            public void reset(View v){
                DisableMe.setEnabled(true);
                Disable.setText("Disable");
                Green.setText("Green");
                Colorme.setBackground(null);
                HideMe.setVisibility(View.VISIBLE);
            }
        public void close(View v){
                finishAffinity();
        }




    }
