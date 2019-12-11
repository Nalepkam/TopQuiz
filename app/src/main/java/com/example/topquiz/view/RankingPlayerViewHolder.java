package com.example.topquiz.view;

import android.view.View;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.topquiz.R;
import com.example.topquiz.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RankingPlayerViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.activity_players_ranking_item_title) TextView textView;

    public RankingPlayerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithPlayer(User mPlayer){
        this.textView.setText(mPlayer.getFirstName() + " : " + mPlayer.getUserScore());
    }

}
