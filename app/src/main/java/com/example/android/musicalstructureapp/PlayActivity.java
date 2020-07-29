package com.example.android.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    // need to keep track of current position for forward and backwards button
    // so created a member variable instead of local variable
    int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //get the intent from LibraryActivity in order to get the extra information that was passed
        Intent intent = getIntent();
        // get the drawable ID from info sent together with the intent
        int imageID = intent.getIntExtra("drawableID", R.drawable.broken_glass_sia);
        // assign that drawable ID onto the main imageView in the playActivity
        ImageView playingSongImage = (ImageView) findViewById(R.id.playing_song_imageView);
        playingSongImage.setImageResource(imageID);
        playingSongImage.setScaleType(ImageView.ScaleType.FIT_CENTER);

        // get the songs array list from the previous Activity
        final ArrayList<Song> songs = (ArrayList<Song>) intent.getSerializableExtra("libraryList");

        // get the position of the previous song from the previous Activity
        mPosition = intent.getIntExtra("position", 0);
        Log.v("PlayActivity***", "position passed in is " + mPosition);

        // Use recycler to display the songs in a ListView
        SongAdapterForVList itemsAdapter = new SongAdapterForVList(this, songs);
        final ListView playingListView = (ListView) findViewById(R.id.playing_list_view); // find the view
        playingListView.setAdapter(itemsAdapter);

        // Set a click listener on an item in that playingListView
        playingListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            // The code in this method will be executed when an item in the playingListView is clicked on.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // need to know which position was clicked on as member variable to use in my forward
                // and backwards button
                mPosition = position;
                Intent playlistIntent = new Intent(PlayActivity.this, PlayActivity.class);
                // get the Song object (1 imgae id and 2 text) at clicked position
                Song currentSongArrayItem = (Song) playingListView.getItemAtPosition(position);
                // get the image id from the current Song object
                int drawableID = currentSongArrayItem.getImageResourceId();
                // pass in the image id via the intent
                playlistIntent.putExtra("drawableID", drawableID );
                // pass in the whole songs list via the intent
                playlistIntent.putExtra("libraryList", (Serializable) songs);
                // pass in the position of this Song object
                playlistIntent.putExtra("position", position);
                startActivity(playlistIntent);
            }
        });

        // Set a click listener on the forward button
        ImageView forwardButton = (ImageView) findViewById(R.id.stepForwardButton);
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // refresh the page so intent is coming back to the same activity page
                Intent playlistIntent = new Intent(PlayActivity.this, PlayActivity.class);
                // increase the position in the arraylist by 1 since moving forward
                if (mPosition+1 < songs.size()) {
                    mPosition += 1;
                }
                    else {mPosition = 0;
                }
                // get the Song object (which is an image with 2 texts) in the position mPosition
                Song nextSongArrayItem = (Song) playingListView.getItemAtPosition(mPosition);
                // get the image id in that Song object
                int drawableID = nextSongArrayItem.getImageResourceId();
                // pass these information via the intent so it can be retrieved and displayed as the next Song
                // as will as the whole list of songs
                playlistIntent.putExtra("drawableID", drawableID );
                playlistIntent.putExtra("libraryList", (Serializable) songs);
                playlistIntent.putExtra("position", mPosition);
                startActivity(playlistIntent);
            }
        });

        // Set a click listener on the backwards button
        ImageView backwardsButton = (ImageView) findViewById(R.id.stepBackButton);
        backwardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playlistIntent = new Intent(PlayActivity.this, PlayActivity.class);
                if (mPosition - 1 > -1) {
                    mPosition -= 1;
                }
                else {mPosition = songs.size()-1;
                }
                Song nextSongArrayItem = (Song) playingListView.getItemAtPosition(mPosition);
                int drawableID = nextSongArrayItem.getImageResourceId();
                playlistIntent.putExtra("drawableID", drawableID );
                playlistIntent.putExtra("libraryList", (Serializable) songs);
                playlistIntent.putExtra("position", mPosition);
                startActivity(playlistIntent);
            }
        });

        // Find the home Image button
        ImageView homeButton = (ImageView) findViewById(R.id.home_imageView);

        // Set a click listener on the home image button
        homeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // set a toast to pretend for now that the song is playing
    public void giveToastPlaying(View view) {
        Toast.makeText(this, "Playing", Toast.LENGTH_SHORT).show();
    }
}