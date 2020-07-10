package com.example.android.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //get the intent from LibraryActivity
        Intent intent = getIntent();

        // get the drawable ID from info sent together with the intent
        int imageID = intent.getIntExtra("drawableID", R.drawable.broken_glass_sia);
        // assign that drawable ID onto the main imageView in the playActivity
        ImageView playingSongImage = (ImageView) findViewById(R.id.playing_song_imageView);
        playingSongImage.setImageResource(imageID);
        playingSongImage.setScaleType(ImageView.ScaleType.FIT_CENTER);

        // get the songs list from LibraryActivity
        final ArrayList<Song> songs = (ArrayList<Song>) intent.getSerializableExtra("libraryList");

        // Use recycler to display the songs in a ListView
        SongAdapterForVList itemsAdapter = new SongAdapterForVList(this, songs);
        final ListView playingListView = (ListView) findViewById(R.id.playing_list_view);
        playingListView.setAdapter(itemsAdapter);

        // Set a click listener on an item in that playingListView
        playingListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            // The code in this method will be executed when an item in the playingListView is clicked on.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playlistIntent = new Intent(PlayActivity.this, PlayActivity.class);
                Song currentSongArray = (Song) playingListView.getItemAtPosition(position);
                int drawableID = currentSongArray.getImageResourceId();
                playlistIntent.putExtra("drawableID", drawableID );
                playlistIntent.putExtra("libraryList", (Serializable) songs);
                startActivity(playlistIntent);
            }
        });


    }

    public void giveToast(android.view.View view) {
        Toast.makeText(this, "Playing", Toast.LENGTH_SHORT).show();
    }











}