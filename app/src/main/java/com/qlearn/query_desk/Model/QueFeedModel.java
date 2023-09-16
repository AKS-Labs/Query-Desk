package com.qlearn.query_desk.Model;

public class QueFeedModel {

    int profile;
    String userName, bio, userQue;

    public QueFeedModel(int profile, String userName, String bio, String userQue) {
        this.profile = profile;
        this.userName = userName;
        this.bio = bio;
        this.userQue = userQue;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUserQue() {
        return userQue;
    }

    public void setUserQue(String userQue) {
        this.userQue = userQue;
    }
}
