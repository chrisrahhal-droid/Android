package com.example.myapplication;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BlankFragment extends Fragment {

    private String[] items = {"Fadi", "Pierre", "Roza", "Mira", "Jean"};
    private String[] profiles = {"Admin", "User", "Student", "Employee", "Teacher"};

    ListView listView;
    ArrayAdapter<String> adapter;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        
        listView = view.findViewById(R.id.listview);

        adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_single_choice, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, itemView, position, id) -> {
            String name = items[position];
            String profile = profiles[position];

            // Find the second fragment
            BlankFragment2 frg2 = (BlankFragment2) getParentFragmentManager().findFragmentById(R.id.fragmentB);
            if (frg2 != null) {
                frg2.sendData(name, profile);
            }
        });

        return view;
    }
}
