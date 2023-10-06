package com.example.labazametkiiisus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addZametka extends AppCompatActivity {

    private Context context = null;
    EditText editText;
    EditText name;
    DBAdapter dbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_zametka);
        dbAdapter = new DBAdapter(this);
        editText = findViewById(R.id.textzametki);
        name = findViewById(R.id.namezametki);
        if(context == null){
            context = getApplicationContext();
        }
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            if(TextUtils.isEmpty(editText.getText().toString()) || TextUtils.isEmpty(name.getText().toString())){
                Toast.makeText(getApplicationContext(), "Введите zametku", Toast.LENGTH_SHORT).show();
            }
            else {
                dbAdapter.addOne( name.getText().toString(),editText.getText().toString());
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}