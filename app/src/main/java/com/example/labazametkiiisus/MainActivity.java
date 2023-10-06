package com.example.labazametkiiisus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context = null;
    DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbAdapter = new DBAdapter(this);
        setContentView(R.layout.activity_main);
        if(context == null){
            context = getApplicationContext();
        }
        Button button = findViewById(R.id.button);
        Button delete = findViewById(R.id.buttondelete);
        if(AdapterDemo.getZametkiLength() == 0)
            dbAdapter.getAll();
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager2 = findViewById(R.id.pager);

        AdapterDemo adapterDemo = new AdapterDemo(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapterDemo);


        new TabLayoutMediator(tabLayout, viewPager2,(tab, position) -> {
            tab.setText(AdapterDemo.getZametkiTitle(position));
        }).attach();



        button.setOnClickListener(v -> {
            Intent intent = new Intent(context, addZametka.class);
            startActivity(intent);
            finish();
        });

        delete.setOnClickListener(v -> {
            if(AdapterDemo.getZametkiLength() == 0)
                Toast.makeText(this, "Stop",Toast.LENGTH_SHORT).show();
            else {
                dbAdapter.deleteOne(AdapterDemo.getZametkiTitle(viewPager2.getCurrentItem()));
                AdapterDemo.destroyZametki();
                dbAdapter.getAll();
                Intent intent = new Intent(this, mybad.class);
                startActivity(intent);
                finish();
            }
        });
    }
}