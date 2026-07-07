package com.example.myapplication;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {

    EditText firstName, lastName;
    Button submitButton;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        // Find views
        firstName = view.findViewById(R.id.firstName);
        lastName = view.findViewById(R.id.lastName);
        submitButton = view.findViewById(R.id.submitButton);

        // Set click listener
        submitButton.setOnClickListener(v -> {
            String fname = firstName.getText().toString();
            String lname = lastName.getText().toString();

            // Create Fragment2 and pass data via Bundle
            Fragment2 frag2 = new Fragment2();
            Bundle bundle = new Bundle();
            bundle.putString("firstName", fname);
            bundle.putString("lastName", lname);
            frag2.setArguments(bundle);

            // Replace the container with Fragment2
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment2Container, frag2)
                    .commit();
        });

        return view;
    }
}
