package com.example.labazametkiiisus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Zametka extends Fragment {


    String name, text;

    public Zametka(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_demo, container, false);
        TextView text = view.findViewById(R.id.textView);
        text.setText(this.text);
        return view;
    }
}