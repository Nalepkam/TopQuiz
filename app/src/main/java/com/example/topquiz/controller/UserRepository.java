package com.example.topquiz.controller;

import com.example.topquiz.TinyDB;
import com.example.topquiz.model.User;

import java.util.ArrayList;

public class UserRepository {

    private TinyDB mTinydb;
    private static final String TINYDB_KEY_PLAYERS_LIST = "TINYDB_KEY_PLAYERS_LIST";


    public UserRepository(TinyDB mtinyDb) {
        mTinydb =  mtinyDb;
    }


    public ArrayList<User> getPlayersList(){
        ArrayList<Object> playerObjects = mTinydb.getListObject(TINYDB_KEY_PLAYERS_LIST, User.class);
        ArrayList<User> players = new ArrayList<User>();

        if (playerObjects == null){
            return players;
        }

        for(Object objs : playerObjects){
            players.add((User)objs);
        }

        return players;
    }

    public void setPlayersList(ArrayList<User> players){

        ArrayList<Object> playerObjects = new ArrayList<Object>();
        if(players != null && !players.isEmpty()){

            for(User player : players){
                playerObjects.add((Object) player);

            }
        }

        mTinydb.putListObject(TINYDB_KEY_PLAYERS_LIST, playerObjects);
    }

}
