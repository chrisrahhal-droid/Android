package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment2 extends Fragment {

    TextView n, p;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank2, container, false);
        n = view.findViewById(R.id.name);
        p = view.findViewById(R.id.profile);
        return view;
    }
    public void sendData(String name, String profile){
        if(name != null && profile != null){
            n.setText("Name: "+name);
            p.setText("Profile: "+profile);
        }
    }

}