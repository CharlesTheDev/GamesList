package com.standroid.gameslist.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cstandafer on 1/18/2018.
 */


public class VideoGame {
    public static ArrayList<VideoGame> videoGames;

    public int id;
    public String title;
    public String description;
    public String genre;
    public float rating;

    public VideoGame(int id, String title, String genre, float rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
    }

    public static ArrayList<VideoGame> populateVideoGames(){
        videoGames = new ArrayList<VideoGame>();
        videoGames.add(new VideoGame(0, "Zelda: Ocarina of Time", "Adventure", 5f));
        videoGames.add(new VideoGame(1, "Halo 5", "Shooter", 4f));
        videoGames.add(new VideoGame(2, "Fallout 4", "Adventure", 3.7f));
        videoGames.add(new VideoGame(3, "Call Of Duty 1000", "Shooter", 2f));
        videoGames.add(new VideoGame(4, "Pokemon Gold", "Adventure", 4f));

        return videoGames;
    }
}
