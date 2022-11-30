
package edu.northeastern.pettinder.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import edu.northeastern.pettinder.R;
import edu.northeastern.pettinder.fragment.FriendAdapter;
import edu.northeastern.pettinder.fragment.FriendItem;
import edu.northeastern.pettinder.pojo.User;

public class ChatActivity extends AppCompatActivity {
    private User user;
    private List<FriendItem> friends;
    private FriendAdapter friendAdapter;
    private RecyclerView recyclerView;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().getRoot();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent intent = getIntent();
        user = (User)intent.getSerializableExtra("user");
        recyclerView = findViewById(R.id.friendList);
        friendAdapter = new FriendAdapter(getApplicationContext(), friends);
        root.child("friends").child(user.getEmail()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    String name = ds.getKey();
                    friends.add(new FriendItem(name));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(friendAdapter);

        friendAdapter.setOnItemClickListener(new FriendAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                chatRoom(position);
            }
        });
    }

    public void chatRoom(int position){
        //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(items.get(position).URL));
        //startActivity(browserIntent);
    }
}
