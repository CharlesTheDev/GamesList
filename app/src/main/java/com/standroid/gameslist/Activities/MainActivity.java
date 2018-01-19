package com.standroid.gameslist.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.standroid.gameslist.Fragments.GameListFragment;
import com.standroid.gameslist.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameListFragment fragment = new GameListFragment();

        getFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }
}
