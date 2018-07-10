package com.example.roguex.nyumbaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Radio group activity
        findViewById(R.id.radioGroup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton nakawa = findViewById(R.id.nakawa);
                RadioButton kampala = findViewById(R.id.kampala);
                RadioButton makindye = findViewById(R.id.makindye);
                RadioButton rubaga = findViewById(R.id.rubaga);

                if (nakawa.isChecked()) {
                    Log.v("MainActivity", "Nakawa Division " + nakawa);
                    Intent listActivity = new Intent(MainActivity.this, listActivity.class);
                    startActivity(listActivity);
                } else if (kampala.isChecked()) {
                    Log.v("MainActivity", "Kampala Central Division " + kampala);
                    Intent listActivity3 = new Intent(MainActivity.this, listActivity3.class);
                    startActivity(listActivity3);
                } else if (makindye.isChecked()) {
                    Log.v("MainActivity", "Makindye Division " + makindye);
                    Intent listActivity2 = new Intent(MainActivity.this, listActivity2.class);
                    startActivity(listActivity2);
                } else if (rubaga.isChecked()) {
                    Log.v("MainActivity", "Rubaga Division" + rubaga);
                    Intent listActivity4 = new Intent(MainActivity.this, listActivity4.class);
                    startActivity(listActivity4);
                } else {
                    //No gender selected.
                }
            }
        });

    }

    public void loginBtn(View view) {
    }
}