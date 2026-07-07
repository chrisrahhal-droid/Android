package com.example.workstation;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Fragment2 extends Fragment {

    TextView message;

    Button close;

    public Fragment2() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_2, container, false);
            message = view.findViewById(R.id.message);
            close = view.findViewById(R.id.close);
            if(getArguments() != null){
                String msg = getArguments().getString("message");
                message.setText(msg);
            }
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getParentFragmentManager().beginTransaction().remove(Fragment2.this).commit();
                }
            });
        return view;
    }
}
