package com.example.roguex.nyumbaapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.radioGroup).setOnClickListener(new View.OnClickListener() {

            //Method for the first radio button.
            @Override
            public void onClick(View view) {
                RadioGroup mRadioGroup = findViewById(R.id.radioGroup);
                mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        final RadioButton nakawaDivision = findViewById(R.id.nakawa);
                        final RadioButton kampalaDivision = findViewById(R.id.kampala);
                        final RadioButton makindyeDivision = findViewById(R.id.makindye);
                        final RadioButton rubagaDivision = findViewById(R.id.rubaga);

                        Button continueButton = findViewById(R.id.continueBtn);
                        continueButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (nakawaDivision.isChecked()){
                                    //Toast displays message once a radio button has been tapped.
                                    Toast.makeText(MainActivity.this, "Showing Apartments in Nakawa", Toast.LENGTH_SHORT).show();
                                    Intent listActivity1 = new Intent(MainActivity.this, listActivity.class);
                                    startActivity(listActivity1);
                                }else if (kampalaDivision.isChecked()){
                                    Toast.makeText(MainActivity.this, "Showing Apartments in Kampala Central", Toast.LENGTH_SHORT).show();
                                    Intent listActivity2 = new Intent(MainActivity.this, listActivity2.class);
                                    startActivity(listActivity2);
                                }else if (makindyeDivision.isChecked()){
                                    Toast.makeText(MainActivity.this, "Showing Apartments in Makindye", Toast.LENGTH_SHORT).show();
                                    Intent listActivity3 = new Intent(MainActivity.this, listActivity3.class);
                                    startActivity(listActivity3);
                                }else if (rubagaDivision.isChecked()){
                                    Toast.makeText(MainActivity.this, "Showing Apartments in Rubaga", Toast.LENGTH_SHORT).show();
                                    Intent listActivity4 = new Intent(MainActivity.this, listActivity4.class);
                                    startActivity(listActivity4);
                                }
                            }
                        });
                    }
                });

            }


        });
    }

}