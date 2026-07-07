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
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
 Spinner spinner1;
 ListView list1;
 TextView text1;
 String selected, message;
    String[] brand = {"Samsung", "Apple"};
    String[] SamsungDevices = {"Galaxy S20", "Galaxy Z", "Note 10"};
    String[] AppleDevices = {"Iphone 12", "Iphone SE", "Iphone 14"};
    String brandName;
    ArrayAdapter<String> adapter1, adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        spinner1 = findViewById(R.id.spinner1);
        list1 = findViewById(R.id.list1);
        text1 = findViewById(R.id.text1);
        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, brand);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);
        list1.setOnItemClickListener(this);
        }

        public void onItemSelected(AdapterView<?> parent, View v, int position, long id){
                if(position == 0){
                    adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SamsungDevices);
                    brandName = brand[position];
                }else if(position == 1){
                    adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, AppleDevices);
                    brandName = brand[position];
                }
                list1.setAdapter(adapter2);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}

        public void send(View v){
            Intent intent = new Intent( this, Choice.class);
            intent.putExtra("model", selected);
            intent.putExtra("brand", brandName);
            startActivityForResult(intent, 2);
        }

        protected void onActivityResult(int requestCode, int resultCode, Intent intent ){
            super.onActivityResult(requestCode, resultCode, intent);

            if (resultCode == RESULT_OK){
                if(intent!=null){
                   message = intent.getStringExtra("message");
                    text1.setText(message);
                }
            }
            else if(resultCode == RESULT_CANCELED){
                if(intent!=null){
                    message = intent.getStringExtra("message");
                    text1.setText(message);
                }
            }
        }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {selected =  adapter2.getItem(position);}
}

