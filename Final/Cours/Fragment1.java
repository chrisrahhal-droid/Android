package com.example.workstation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class Fragment1 extends Fragment {

    TextView message;

    Button validate;

    RadioButton english, french;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_1, container, false);
        message = view.findViewById(R.id.message);
        validate = view.findViewById(R.id.validate);
        english = view.findViewById(R.id.english);
        french = view.findViewById(R.id.french);
        if(getArguments() != null){
            message.setText(getArguments().getString("message"));
        }
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "";
                Bundle bundle = new Bundle();
                if(french.isChecked()){
                    msg = "french";
                }else if(english.isChecked()){
                    msg = "english";
                }
                bundle.putString("message", msg);
                Fragment frag2 = new Fragment2();
                frag2.setArguments(bundle);
                getParentFragmentManager().beginTransaction().replace(R.id.fragment, frag2).commit();
            }
        });
        return view;
    }
}