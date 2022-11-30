package edu.northeastern.pettinder.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.northeastern.pettinder.R;
import edu.northeastern.pettinder.pojo.User;

public class MainActivity extends AppCompatActivity {
    private Button chatRoom;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        user = (User)intent.getSerializableExtra("user");
        chatRoom = (Button)findViewById(R.id.button);
        chatRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chatRoom();
            }
        });
    }

    /*private void chatRoom(){
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }*/
}