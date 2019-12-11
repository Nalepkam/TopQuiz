package com.example.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.topquiz.R;
import com.example.topquiz.TinyDB;
import com.example.topquiz.model.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayersRankingActivity extends AppCompatActivity {

    private Button mSortByScoreBtn;
    private Button mSortByNameBtn;

    private ArrayList<User> mRankingList;
    private UserRepository mUserRepository;

    @BindView(R.id.activity_players_ranking_recycler_view) RecyclerView recyclerView;

    private PlayerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_ranking);
        ButterKnife.bind(this);



        mSortByScoreBtn = (Button) findViewById(R.id.activity_players_ranking_sortByScore_btn);
        mSortByNameBtn = (Button) findViewById(R.id.activity_players_ranking_sortByName_btn);

        TinyDB mTinyDB = new TinyDB(this);
        mUserRepository = new UserRepository(mTinyDB);
        mRankingList = mUserRepository.getPlayersList();

        this.configureRecyclerView();

        mSortByScoreBtn.setEnabled(false);

        mSortByScoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayByScore();
                mSortByScoreBtn.setEnabled(false);
                mSortByNameBtn.setEnabled(true);
            }
        });

        mSortByNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayByName();
                mSortByNameBtn.setEnabled(false);
                mSortByScoreBtn.setEnabled(true);
            }
        });

    }

    private void configureRecyclerView(){
        this.adapter = new PlayerAdapter(this.mRankingList);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void displayByScore(){
        mRankingList.sort((a, b) -> a.getUserScore() > b.getUserScore()?-1:1);
        this.adapter.refreshData(mRankingList);

    }

    private void displayByName(){
        mRankingList.sort((a, b) -> a.getFirstName().compareTo(b.getFirstName()));
        this.adapter.refreshData(mRankingList);

    }

}
