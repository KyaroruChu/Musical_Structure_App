package com.example.android.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    private ArrayList<Song> mFirstList;
    private ArrayList<Song> mSecondList;
    private ArrayList<Song> mThirdList;
    private RecyclerView mRecyclerView1;
    private RecyclerView mRecyclerView2;
    private RecyclerView mRecyclerView3;
    private RecyclerViewAdapter mAdapter1;
    private RecyclerViewAdapter mAdapter2;
    private RecyclerViewAdapter mAdapter3;
    private RecyclerView.LayoutManager mLayoutManager1;
    private RecyclerView.LayoutManager mLayoutManager2;
    private RecyclerView.LayoutManager mLayoutManager3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);


        // create the various playlist ArrayLists
        createFirstList();
        createSecondList();
        createThirdList();
        // create the recyclerView for each playlist
        buildRecyclerView1();
        buildRecyclerView2();
        buildRecyclerView3();

        // Find the home Image button
        ImageView homeButton = (ImageView) findViewById(R.id.home_imageView);

        // Set a click listener on the home image button to go back to main page
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void createFirstList(){
        //Populate the array list of First Playlist with song photo, song name and artist name
        mFirstList = new ArrayList<Song>();
        mFirstList.add(new Song(R.drawable.broken_glass_sia, "Broken Glass", "Sia", Color.WHITE));
        mFirstList.add(new Song(R.drawable.flames_david_guetta_sia, "Flames", "David Guetta & Sia", Color.WHITE));
        mFirstList.add(new Song(R.drawable.free_woman_lady_gaga, "Free Woman", "Lady Gaga", Color.WHITE));
        mFirstList.add(new Song(R.drawable.free_woman1_lady_gaga, "Free Woman", "Lady Gaga", Color.BLACK));
        mFirstList.add(new Song(R.drawable.genius_sia_diplo_labrinth_lsd, "Genius", "Sia, Diplo Labrinth, LSD", Color.BLACK));
        mFirstList.add(new Song(R.drawable.love_punch_otsuka, "Love Punch", "Otsuka Ai", Color.BLACK));
        mFirstList.add(new Song(R.drawable.nonbinary_arca, "Nonbinary", "ARCA", Color.BLACK));
        mFirstList.add(new Song(R.drawable.ocean_eyes_billie_eilish, "Ocean Eyes", "Billie Eilish", Color.BLACK));
        mFirstList.add(new Song(R.drawable.sakuranbo_otsuka, "Sakuranbo", "Otsuka Ai", Color.BLACK));
        mFirstList.add(new Song(R.drawable.shape_of_you_ed_sheeran, "Shape of You", "Ed Sheeran", Color.WHITE));
        mFirstList.add(new Song(R.drawable.sorry_justin_bieber, "Sorry", "Justin Bieber", Color.BLACK));
        mFirstList.add(new Song(R.drawable.together_sia, "Together", "Sia", Color.BLACK));
    }

    public void createSecondList(){
        //Populate the array list of Second Playlist "Relaxed" with song photo, song name and artist name
        mSecondList = new ArrayList<Song>();
        mSecondList.add(new Song(R.drawable.all_i_have_jennifer_lopez, "All I Have", "Jennifer Loppez", Color.BLACK));
        mSecondList.add(new Song(R.drawable.bad_guy_billie_eilish, "Bad Guy", "Billie Eilish", Color.WHITE));
        mSecondList.add(new Song(R.drawable.better_together_jack_johnson, "Better Together", "Jack Johnson", Color.WHITE));
        mSecondList.add(new Song(R.drawable.bleeding_love_leona_lewis, "Bleeding Love", "Leona Lewis", Color.WHITE));
        mSecondList.add(new Song(R.drawable.by_your_side_sade, "By Your Side", "Sade", Color.BLACK));
        mSecondList.add(new Song(R.drawable.empire_state_of_mind_alicia_keys, "Empire State of Mind", "Alicia Keys", Color.WHITE));
        mSecondList.add(new Song(R.drawable.every_time_janet_jackson, "Every Time", "Janet Jackson", Color.WHITE));
        mSecondList.add(new Song(R.drawable.get_her_back_robin_thicke, "Get Her Back", "Robin Thicke", Color.BLACK));
        mSecondList.add(new Song(R.drawable.like_a_star_corinne_bailey_rae, "Like A Star", "Corinne Bailey Rae", Color.BLACK));
        mSecondList.add(new Song(R.drawable.she_will_be_loved_maroon5, "She Will Be Loved", "Maroon 5", Color.WHITE));
        mSecondList.add(new Song(R.drawable.true_colours_eva_cassidy, "True Colours", "Eva Cassidy", Color.BLACK));
        mSecondList.add(new Song(R.drawable.xo_john_mayer, "XO", "John Mayer", Color.WHITE));
    }

    public void createThirdList(){
        //Populate the array list of Second Playlist "Relaxed" with song photo, song name and artist name
        mThirdList = new ArrayList<Song>();
        mThirdList.add(new Song(R.drawable.four_am_2_chainz_travis_scott, "4 AM", "2 Chainz, Travis Scott", Color.BLACK));
        mThirdList.add(new Song(R.drawable.best_mode_a_boogie_wit_da_hoodie, "Best Mode", "a boogie with da hoodie", Color.BLACK));
        mThirdList.add(new Song(R.drawable.bodak_yellow_cardi_b, "Bodak Yellow", "Cardi b", Color.BLACK));
        mThirdList.add(new Song(R.drawable.boom_gucci_mane, "BOOM", "Tiesto, Sevenn", Color.WHITE));
        mThirdList.add(new Song(R.drawable.destination_calabria_medikal, "Destination", "Calabria Medikal", Color.WHITE));
        mThirdList.add(new Song(R.drawable.drift_away_felippe_mela, "Drift Away", "Felippe Mela", Color.BLACK));
        mThirdList.add(new Song(R.drawable.godzilla_eminem, "Godzilla", "Eminem", Color.WHITE));
        mThirdList.add(new Song(R.drawable.gucci_gang_lil_pump, "Gucci Gang", "Lil Pump", Color.WHITE));
        mThirdList.add(new Song(R.drawable.loved_by_you_lordnox, "Loved by You", "Lordnox", Color.BLACK));
        mThirdList.add(new Song(R.drawable.purple_lamborghini_skrillex_rick_ross, "Purple Lamborghini", "Skrillex, Rick Ross", Color.BLACK));
        mThirdList.add(new Song(R.drawable.roxanne_arizona_zervas, "Roxanne", "Arizona Zervas", Color.BLACK));
        mThirdList.add(new Song(R.drawable.spice_girl_amine, "Spice Girl", "Amine", Color.BLACK ));
    }


    public void buildRecyclerView1(){
        mRecyclerView1 = findViewById(R.id.recycler_view_1);
        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter1 = new RecyclerViewAdapter(mFirstList);
        mRecyclerView1.setLayoutManager(mLayoutManager1);
        mRecyclerView1.setAdapter(mAdapter1);

        mAdapter1.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent playlistIntent = new Intent(PlaylistActivity.this, PlayActivity.class);
                //Codes for when user click on an item in the playlist,
                //the PlayActivity page also display all the songs in the playlist
                // get element from mFirstList at index position
                Song currentSongArray = mFirstList.get(position);
                // get the ImageResource ID from the element and pass info as part of playlistIntent
                int drawableID = currentSongArray.getImageResourceId();
                playlistIntent.putExtra("drawableID", drawableID );
                playlistIntent.putExtra("libraryList", (Serializable) mFirstList);
                playlistIntent.putExtra("position", position);
                startActivity(playlistIntent);
            }
        });
    }

    public void buildRecyclerView2(){
        mRecyclerView2 = findViewById(R.id.recycler_view_2);
        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter2 = new RecyclerViewAdapter(mSecondList);
        mRecyclerView2.setLayoutManager(mLayoutManager2);
        mRecyclerView2.setAdapter(mAdapter2);

        mAdapter2.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent playlistIntent = new Intent(PlaylistActivity.this, PlayActivity.class);
                //Codes for when user click on an item in the playlist,
                //the PlayActivity page also display all the songs in the playlist
                // get element from mFirstList at index position
                Song currentSongArray = mSecondList.get(position);
                // get the ImageResource ID from the element and pass info as part of playlistIntent
                int drawableID = currentSongArray.getImageResourceId();
                playlistIntent.putExtra("drawableID", drawableID );
                playlistIntent.putExtra("libraryList", (Serializable) mSecondList);
                playlistIntent.putExtra("position", position);
                startActivity(playlistIntent);
            }
        });
    }

    public void buildRecyclerView3(){
        mRecyclerView3 = findViewById(R.id.recycler_view_3);
        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mAdapter3 = new RecyclerViewAdapter(mThirdList);
        mRecyclerView3.setLayoutManager(mLayoutManager3);
        mRecyclerView3.setAdapter(mAdapter3);

        mAdapter3.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent playlistIntent = new Intent(PlaylistActivity.this, PlayActivity.class);
                //Codes for when user click on an item in the playlist,
                //the PlayActivity page also display all the songs in the playlist
                // get element from mFirstList at index position
                Song currentSongArray = mThirdList.get(position);
                // get the ImageResource ID from the element and pass info as part of playlistIntent
                int drawableID = currentSongArray.getImageResourceId();
                playlistIntent.putExtra("drawableID", drawableID );
                playlistIntent.putExtra("libraryList", (Serializable) mThirdList);
                playlistIntent.putExtra("position", position);
                startActivity(playlistIntent);
            }
        });
    }
}