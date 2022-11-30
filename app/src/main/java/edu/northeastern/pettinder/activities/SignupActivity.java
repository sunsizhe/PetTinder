package edu.northeastern.pettinder.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import edu.northeastern.pettinder.R;
import edu.northeastern.pettinder.pojo.User;

public class SignupActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button addUser;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().getRoot();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //FirebaseApp.initializeApp(this);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        addUser = (Button)findViewById(R.id.signup2);
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.hasChild(email.getText().toString())) {
// run some code
                            Toast.makeText(getApplicationContext(),"Email exist, try other one!!",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Map<String, Object> map = new HashMap<>();
                            User user = new User(email.getText().toString(), password.getText().toString());
                            map.put(email.getText().toString(), user);
                            root.child("user").updateChildren(map);
                            MainActivity();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(),"Add user failed!!!",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    public void MainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}