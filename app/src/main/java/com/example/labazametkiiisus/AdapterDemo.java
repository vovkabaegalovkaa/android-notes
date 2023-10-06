package com.example.labazametkiiisus;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class AdapterDemo extends FragmentStateAdapter {
private static List<DemoFragment> zametki = new ArrayList<>();

public static void  addZametki(String name, String text){
    Zametka zametka = new Zametka(name, text);
    DemoFragment demoFragment = new DemoFragment(zametka);
    zametki.add(demoFragment);
}
    public static String getZametkiTitle(int position){
        return zametki.get(position).zametka.name;
    }
    public static int getZametkiLength(){
        return zametki.size();
    }

    public static void removeZametka(int i){
        zametki.remove(i);
    }
    public AdapterDemo(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = zametki.get(position);
        return fragment;
    }


    @Override
    public int getItemCount() {
        return zametki.size();
    }
}
