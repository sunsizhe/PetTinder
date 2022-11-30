package edu.northeastern.pettinder.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String email;
    private String password;
    private ArrayList<User> friends;

    public User(){}

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, ArrayList<User> friends){
        this.email = email;
        this.password = password;
        this.friends = friends;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }
}
