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

    public static final String TITLE = "title";


    public static DemoFragment getNewInstance(String position){
        DemoFragment pageFragment = new DemoFragment();
        Bundle args = new Bundle();
        args.putString(TITLE, position);
        pageFragment.setArguments(args);
        return pageFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((TextView)view.findViewById(R.id.textView)).setText(getArguments().getString(TITLE));
    }
}