package com.example.topquiz.model;

public class User {

    private String mFirstName;
    private int mUserScore;

    public String getFirstName() {

        return mFirstName;
    }

    public void setFirstName(String firstName) {

        mFirstName = firstName;
    }

    public int getUserScore() {

        return mUserScore;
    }

    public void setUserScore(int userScore) {

        mUserScore = userScore;
    }

    @Override
    public String toString() {
        return "User{" +
                "mFirstName='" + mFirstName + '\'' + mUserScore +
                '}';
    }
}
