package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    TextView name;

    RadioButton beginner, expert;

    CheckBox showLevel;

    Button button;

    String text;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        name = view.findViewById(R.id.name);
        beginner = view.findViewById(R.id.beginner);
        expert = view.findViewById(R.id.expert);
        showLevel = view.findViewById(R.id.showLevel);
        button = view.findViewById(R.id.button);

        if(getArguments()!=null) {
           String fName = getArguments().getString("firstName");
           String lName = getArguments().getString("lastName");
           name.setText(fName+" "+lName);
       }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showLevel.isChecked()){
                    if(beginner.isChecked()) {
                        text = "Your level is Beginner";
                    }else if(expert.isChecked()){
                        text = "Your level is: Expert";
                    }
                }else{
                    text = "We can't show your level";
                }
                Bundle bundle = new Bundle();
                bundle.putString("result", text);

                Fragment3 frg3 = new Fragment3();
                frg3.setArguments(bundle);

                getFragmentManager().beginTransaction().replace(R.id.fragment3, frg3).commit();
            }
        });



        return view;
    }
}