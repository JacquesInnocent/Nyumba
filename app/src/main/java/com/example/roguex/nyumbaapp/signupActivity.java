package com.example.roguex.nyumbaapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


//Button id = buttonBack

public class signupActivity extends AppCompatActivity {
    public Button loginInstead;
    public Button buttonSignup;

    EditText fullName, emailPhone, pinText;
    Button signup;
    //Firebase config variable goes here

    public void init(){
        Toast.makeText(this, "Back to Login page", Toast.LENGTH_SHORT).show();
        loginInstead = findViewById(R.id.loginInsteadButton);
        loginInstead.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(signupActivity.this, listActivity.class);
                startActivity(goBack);
            }
        });
    }
    public void init2(){
        Toast.makeText(this, "Signing up.", Toast.LENGTH_LONG).show();
        buttonSignup = findViewById(R.id.buttonSignup);
        buttonSignup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(signupActivity.this,MainActivity.class);
                startActivity(signup);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //Calling the methods for the 2 buttons
        init();
        init2();

        //For user input capture
        fullName = findViewById(R.id.fullName);
        emailPhone = findViewById(R.id.emailPhone);
        pinText = findViewById(R.id.pinText);

        //Radio button

        findViewById(R.id.genderGroup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton male =  findViewById(R.id.genderMale);
                RadioButton female =  findViewById(R.id.genderFemale);
                RadioButton other =  findViewById(R.id.genderOther);

                if(male.isChecked()) {
                    Log.v("signupActivity", "Male " + male);
                } else if(female.isChecked()) {
                    Log.v("signupActivity", "Female " + female);
                } else if (other.isChecked()){
                    Log.v("signupActivity", "Preferred not to say " + other);
                }

                else {
                    //No gender selected.
                }
            }
        });
    }

    public void onSubmitSign(View view){

    }
    public void loginInstead(View view ){
        Intent login = new Intent(signupActivity.this, MainActivity.class);
        startActivity(login);
    }
}
