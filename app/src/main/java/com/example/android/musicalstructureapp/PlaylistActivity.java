package com.example.android.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        //Populate the array list of First Playlist with song photo, song name and artist name
        ArrayList<Song> firstList = new ArrayList<Song>();
        firstList.add(new Song(R.drawable.broken_glass_sia, "Broken Glass", "Sia", Color.WHITE));
        firstList.add(new Song(R.drawable.flames_david_guetta_sia, "Flames", "David Guetta & Sia", Color.WHITE));
        firstList.add(new Song(R.drawable.free_woman_lady_gaga, "Free Woman", "Lady Gaga", Color.WHITE));
        firstList.add(new Song(R.drawable.free_woman1_lady_gaga, "Free Woman", "Lady Gaga", Color.BLACK));
        firstList.add(new Song(R.drawable.genius_sia_diplo_labrinth_lsd, "Genius", "Sia, Diplo Labrinth, LSD", Color.BLACK));
        firstList.add(new Song(R.drawable.love_punch_otsuka, "Love Punch", "Otsuka Ai", Color.BLACK));
        firstList.add(new Song(R.drawable.nonbinary_arca, "Nonbinary", "ARCA", Color.BLACK));
        firstList.add(new Song(R.drawable.ocean_eyes_billie_eilish, "Ocean Eyes", "Billie Eilish", Color.BLACK));
        firstList.add(new Song(R.drawable.sakuranbo_otsuka, "Sakuranbo", "Otsuka Ai", Color.BLACK));
        firstList.add(new Song(R.drawable.shape_of_you_ed_sheeran, "Shape of You", "Ed Sheeran", Color.WHITE));
        firstList.add(new Song(R.drawable.sorry_justin_bieber, "Sorry", "Justin Bieber", Color.BLACK));
        firstList.add(new Song(R.drawable.together_sia, "Together", "Sia", Color.BLACK));


        // Link the adapter to recycle the array list of items to the list view
        //SongAdapterForHList itemsAdapter = new SongAdapterForHList(this, firstList);
        //ListView firstPlaylist = (ListView) findViewById(R.id.first_playlist_listView);
        //firstPlaylist.setAdapter(itemsAdapter);

        // pass array into RecyclerAdapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(firstList);
        RecyclerView recyclerview = (RecyclerView) findViewById(R.id.recycler_view);



    }
}