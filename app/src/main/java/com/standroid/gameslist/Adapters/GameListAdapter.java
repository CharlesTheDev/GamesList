package com.standroid.gameslist.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.standroid.gameslist.Models.VideoGame;
import com.standroid.gameslist.R;

import java.util.ArrayList;

/**
 * Created by cstandafer on 1/18/2018.
 */

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameViewHolder>{

    private Context c;
    private ArrayList<VideoGame> videoGames;

    public GameListAdapter(ArrayList<VideoGame> videoGames) {
        this.videoGames = videoGames;
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        c = parent.getContext();
        View itemView = LayoutInflater.from(c)
                .inflate(R.layout.list_item_video_game, parent, false);
        return new GameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        VideoGame vG = videoGames.get(position);
        holder.bind(vG);
    }

    @Override
    public int getItemCount() {
        return videoGames.size();
    }

    public class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mTitleTV;
        TextView mGenreTV;
        TextView mRatingTV;

        public GameViewHolder(View itemView) {
            super(itemView);

            mTitleTV = (TextView)itemView.findViewById(R.id.tv_game_title);
            mGenreTV = (TextView)itemView.findViewById(R.id.tv_game_genre);
            mRatingTV = (TextView)itemView.findViewById(R.id.tv_game_rating);

            itemView.setOnClickListener(this);
        }

        public void bind(VideoGame vG){
            mTitleTV.setText(vG.title);
            mGenreTV.setText(vG.genre);
            mRatingTV.setText(String.valueOf(vG.rating));
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            VideoGame vG = videoGames.get(pos);

            Toast.makeText(c, "Clicked : " + vG.title, Toast.LENGTH_SHORT).show();
        }
    }
}
