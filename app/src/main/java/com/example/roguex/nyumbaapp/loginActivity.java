package com.example.roguex.nyumbaapp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;



class loginActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private FirebaseAuth.AuthStateListener mAuthListener;


    private GoogleSignInClient mGoogleSignInClient;
    private Handler mHandler;
    FirebaseAuth mAuth;
    String mCurrentUser;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() != null){
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }





        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null){

                    startActivity(new Intent(loginActivity.this, MainActivity.class));
                }else
                {

                }
            }
        };


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, 1021);

            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == 1021) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                handleSignInResult(account);
                Log.w("Onresults", account.getEmail().toString()+" signInResult:failed code");
            } catch (ApiException e) {
                e.printStackTrace();
            }

        }
    }


    private void handleSignInResult(final GoogleSignInAccount account) {

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getEmail(), null);
        Task<AuthResult> login = mAuth.signInWithEmailAndPassword(account.getEmail(), "password");
        login.addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>()
        {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Intent intent = new Intent(loginActivity.this, MainActivity.class);
                    startActivity(intent);
                    mGoogleSignInClient.signOut();
                }else
                {
                    register(account);
                }
            }
        });

    }

    private void register(GoogleSignInAccount account)
    {
        mAuth.createUserWithEmailAndPassword(account.getEmail(), "password")
                .addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Intent intent = new Intent(loginActivity.this, MainActivity.class);
                            startActivity(intent);
                            mGoogleSignInClient.signOut();
                        }else {

                            Toast.makeText(loginActivity.this, task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



}



