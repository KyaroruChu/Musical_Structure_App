package com.example.android.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

// This is the page that shows all the songs in one's library

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        //Populate the array list of songs in one's library
        // Each song has a song photo, a song name and its related artist name
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(R.drawable.broken_glass_sia, "Broken Glass", "Sia", Color.WHITE));
        songs.add(new Song(R.drawable.flames_david_guetta_sia, "Flames", "David Guetta & Sia", Color.WHITE));
        songs.add(new Song(R.drawable.free_woman_lady_gaga, "Free Woman", "Lady Gaga", Color.WHITE));
        songs.add(new Song(R.drawable.free_woman1_lady_gaga, "Free Woman", "Lady Gaga", Color.BLACK));
        songs.add(new Song(R.drawable.genius_sia_diplo_labrinth_lsd, "Genius", "Sia, Diplo Labrinth, LSD", Color.BLACK));
        songs.add(new Song(R.drawable.love_punch_otsuka, "Love Punch", "Otsuka Ai", Color.BLACK));
        songs.add(new Song(R.drawable.nonbinary_arca, "Nonbinary", "ARCA", Color.BLACK));
        songs.add(new Song(R.drawable.ocean_eyes_billie_eilish, "Ocean Eyes", "Billie Eilish", Color.BLACK));
        songs.add(new Song(R.drawable.sakuranbo_otsuka, "Sakuranbo", "Otsuka Ai", Color.BLACK));
        songs.add(new Song(R.drawable.shape_of_you_ed_sheeran, "Shape of You", "Ed Sheeran", Color.WHITE));
        songs.add(new Song(R.drawable.sorry_justin_bieber, "Sorry", "Justin Bieber", Color.BLACK));
        songs.add(new Song(R.drawable.together_sia, "Together", "Sia", Color.BLACK));
        songs.add(new Song(R.drawable.all_i_have_jennifer_lopez, "All I Have", "Jennifer Loppez", Color.BLACK));
        songs.add(new Song(R.drawable.bad_guy_billie_eilish, "Bad Guy", "Billie Eilish", Color.WHITE));
        songs.add(new Song(R.drawable.better_together_jack_johnson, "Better Together", "Jack Johnson", Color.WHITE));
        songs.add(new Song(R.drawable.bleeding_love_leona_lewis, "Bleeding Love", "Leona Lewis", Color.WHITE));
        songs.add(new Song(R.drawable.by_your_side_sade, "By Your Side", "Sade", Color.BLACK));
        songs.add(new Song(R.drawable.empire_state_of_mind_alicia_keys, "Empire State of Mind", "Alicia Keys", Color.WHITE));
        songs.add(new Song(R.drawable.every_time_janet_jackson, "Every Time", "Janet Jackson", Color.WHITE));
        songs.add(new Song(R.drawable.get_her_back_robin_thicke, "Get Her Back", "Robin Thicke", Color.BLACK));
        songs.add(new Song(R.drawable.like_a_star_corinne_bailey_rae, "Like A Star", "Corinne Bailey Rae", Color.BLACK));
        songs.add(new Song(R.drawable.she_will_be_loved_maroon5, "She Will Be Loved", "Maroon 5", Color.WHITE));
        songs.add(new Song(R.drawable.true_colours_eva_cassidy, "True Colours", "Eva Cassidy", Color.BLACK));
        songs.add(new Song(R.drawable.xo_john_mayer, "XO", "John Mayer", Color.WHITE));
        songs.add(new Song(R.drawable.four_am_2_chainz_travis_scott, "4 AM", "2 Chainz, Travis Scott", Color.BLACK));
        songs.add(new Song(R.drawable.best_mode_a_boogie_wit_da_hoodie, "Best Mode", "a boogie with da hoodie", Color.BLACK));
        songs.add(new Song(R.drawable.bodak_yellow_cardi_b, "Bodak Yellow", "Cardi b", Color.BLACK));
        songs.add(new Song(R.drawable.boom_gucci_mane, "BOOM", "Tiesto, Sevenn", Color.WHITE));
        songs.add(new Song(R.drawable.destination_calabria_medikal, "Destination", "Calabria Medikal", Color.WHITE));
        songs.add(new Song(R.drawable.drift_away_felippe_mela, "Drift Away", "Felippe Mela", Color.BLACK));
        songs.add(new Song(R.drawable.godzilla_eminem, "Godzilla", "Eminem", Color.WHITE));
        songs.add(new Song(R.drawable.gucci_gang_lil_pump, "Gucci Gang", "Lil Pump", Color.WHITE));
        songs.add(new Song(R.drawable.loved_by_you_lordnox, "Loved by You", "Lordnox", Color.BLACK));
        songs.add(new Song(R.drawable.purple_lamborghini_skrillex_rick_ross, "Purple Lamborghini", "Skrillex, Rick Ross", Color.BLACK));
        songs.add(new Song(R.drawable.roxanne_arizona_zervas, "Roxanne", "Arizona Zervas", Color.BLACK));
        songs.add(new Song(R.drawable.spice_girl_amine, "Spice Girl", "Amine", Color.BLACK));

        // Create the customized SongAdapter
        SongAdapterForGrid itemsAdapter = new SongAdapterForGrid(this, songs);

        // Find the gridView display from xml
        final GridView libraryGridView = (GridView) findViewById(R.id.library_grid_view);
        libraryGridView.setAdapter(itemsAdapter);

        // Set a click listener on an item in that gridView
        libraryGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playlistIntent = new Intent(LibraryActivity.this, PlayActivity.class);
                //Codes for when user click on an item in the gridView, the page also display of all the songs in his/her library
                Song currentSongArray = (Song) libraryGridView.getItemAtPosition(position);
                int drawableID = currentSongArray.getImageResourceId();
                playlistIntent.putExtra("drawableID", drawableID);
                playlistIntent.putExtra("libraryList", (Serializable) songs);
                playlistIntent.putExtra("position", position);
                Log.v("LibraryActivity***", "position passed in as intent is " + position);
                startActivity(playlistIntent);
            }
        });

        // Find the home Image button
        ImageView homeButton = (ImageView) findViewById(R.id.home_imageView);

        // Set a click listener on the home image button
        homeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibraryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}