package com.example.labazametkiiisus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter extends SQLiteOpenHelper {
    private static final String MY_TABLE = "MY_TABLE";
    private static final String COLUMN_NAME = "COLUMN_NAME";
    private static final String COLUMN_TEXT = "COLUMN_TEXT";

    public DBAdapter(@Nullable Context context) {
        super(context, "new.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + MY_TABLE + " (" + COLUMN_NAME + " TEXT, " + COLUMN_TEXT + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void DeleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(MY_TABLE, null, null);
        db.close();
    }
    public void addOne(String name, String text){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_TEXT, text);
        AdapterDemo.addZametki(name, text);
        db.insert(MY_TABLE, null, cv);
        db.close();
    }

    public void getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(MY_TABLE, null, null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                int id_n = cursor.getColumnIndex(COLUMN_NAME);
                int id_t = cursor.getColumnIndex(COLUMN_TEXT);
                AdapterDemo.addZametki(cursor.getString(id_n), cursor.getString(id_t));
            }while (cursor.moveToNext());
        }
        db.close();
    }

    public void deleteOne(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(MY_TABLE, COLUMN_NAME + "= " +"'" +AdapterDemo.getZametka(name)+"'",null );
        db.close();
    }
}
