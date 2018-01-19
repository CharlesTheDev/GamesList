package com.standroid.gameslist.Fragments;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.standroid.gameslist.Adapters.GameListAdapter;
import com.standroid.gameslist.Models.VideoGame;
import com.standroid.gameslist.R;

import java.util.ArrayList;

/**
 * Created by cstandafer on 1/18/2018.
 */

public class GameListFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<VideoGame>> {

    private static final int GAME_LOADER_ID = 0;

    private RecyclerView mGameListRV;
    private GameListAdapter adapter;
    private ProgressBar mProgressBar;

    private Context c;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_video_game_list, container, false);

        c = v.getContext();

        mProgressBar = (ProgressBar)v.findViewById(R.id.pb_load_indicator);

        mGameListRV = (RecyclerView)v.findViewById(R.id.rv_game_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(v.getContext(), LinearLayoutManager.VERTICAL, false);
        mGameListRV.setLayoutManager(layoutManager);
        getLoaderManager().initLoader(GAME_LOADER_ID, null, this);

        return v;
    }

    @Override
    public Loader<ArrayList<VideoGame>> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<ArrayList<VideoGame>>(c) {

            ArrayList<VideoGame> games = null;

            @Override
            protected void onStartLoading() {
                if(games != null) {}
                else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    forceLoad();
                }
            }

            @Override
            public ArrayList<VideoGame> loadInBackground() {
                ArrayList<VideoGame> jsonGameResponse = VideoGame.populateVideoGames();
                return jsonGameResponse;
            }

            public void deliverResult(ArrayList<VideoGame> data) {
                games = data;
                super.deliverResult(data);
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<VideoGame>> loader, ArrayList<VideoGame> data) {
        mProgressBar.setVisibility(View.INVISIBLE);
        adapter = new GameListAdapter(data);
        mGameListRV.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<VideoGame>> loader) {

    }
}
