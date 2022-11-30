package edu.northeastern.pettinder.fragment;

public class FriendItem {
    String name;
    int image;

    public FriendItem() {
    }

    public FriendItem(String name) {
        this.name = name;
    }

    public FriendItem(String name, int image) {
        this.name = name;
        this.image = image;
    }
}
