package com.example.android.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the library card view
        CardView library = (CardView) findViewById(R.id.menu_library);

        // Set a click listener on that View
        library.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Library CardView is clicked on.
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(libraryIntent);
            }
        });

        // Find the View that shows the Playlist card view
        CardView playlist = (CardView) findViewById(R.id.menu_playlist);

        // Set a click listener on that View
        playlist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(playlistIntent);
            }
        });

        // Find the View that shows the Trending card view
        CardView trending = (CardView) findViewById(R.id.menu_trending);

        // Set a click listener on that View
        trending.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent trendingIntent = new Intent(MainActivity.this, ContainerActivity.class);
                startActivity(trendingIntent);
            }
        });

        // Find the View that shows the music charts card view
        CardView charts = (CardView) findViewById(R.id.menu_charts);

        // Set a click listener on that View
        charts.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent chartsIntent = new Intent(MainActivity.this,ContainerActivity.class);
                startActivity(chartsIntent);
            }
        });
    }
}