package com.example.labazametkiiisus;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DemoFragment extends Fragment {


    Zametka zametka;

    public DemoFragment(Zametka z) {
        this.zametka = z;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_demo, container, false);
        TextView text = view.findViewById(R.id.textView);
        text.setText(zametka.text);
        return view;
    }
}