package edu.northeastern.pettinder.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import edu.northeastern.pettinder.R;
import edu.northeastern.pettinder.pojo.User;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText email;
    private EditText password;
    private User user;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().getRoot();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login2);
        email = findViewById(R.id.email2);
        password = findViewById(R.id.password2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.child("user").child(email.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        user = snapshot.getValue(User.class);
                        //email or password incorrect
                        if (user == null || !user.getPassword().equals(password.getText().toString())) {
                            // run some code
                            Toast.makeText(getApplicationContext(),"Email or password incorrect, try again!!",Toast.LENGTH_SHORT).show();
                        }
                        //email or password correct
                        else{
                           //open new activity
                            Toast.makeText(getApplicationContext(),"login succeed!!!",Toast.LENGTH_SHORT).show();
                            MainActivity();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(),"login failed!!!",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void MainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}