package com.example.labazametkiiisus;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class AdapterDemo extends FragmentStateAdapter {
private static List<Zametka> zametki = new ArrayList<>();

public static void  addZametki(String name, String text){
    Zametka zametka = new Zametka(name, text);
    zametki.add(zametka);
}
    public static String getZametkiTitle(int position){
        return zametki.get(position).name;
    }
    public static void destroyZametki(){
        zametki.clear();
    }
    public static int getZametkiLength(){
        return zametki.size();
    }

    public static void removeZametka(int i){
        zametki.remove(i);
    }
    public static String getZametka(String title){
        for(Zametka z : zametki){
            if (title.equals(z.name))
                return z.name;
        }
        return null;
    }
    public AdapterDemo(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Zametka fragment = zametki.get(position);
        return fragment;
    }


    @Override
    public int getItemCount() {
        return zametki.size();
    }
}
