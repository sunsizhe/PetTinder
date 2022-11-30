package edu.northeastern.pettinder.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.northeastern.pettinder.R;

public class StartUpActivity extends AppCompatActivity {

    Button signUp;
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
        signUp = (Button) findViewById(R.id.signup);
        logIn = (Button) findViewById(R.id.login);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInActivity();
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpActivity();

            }
        });
    }

    public void logInActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void signUpActivity(){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
}