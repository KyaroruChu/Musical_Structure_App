package com.example.android.musicalstructureapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;

import java.io.Serializable;

public class Song implements Serializable {

    /** Drawable resource ID */
    private int mImageResourceId;

    /** Song name for the song */
    private String mSongName;

    /** Artist name for the song */
    private String mArtistName;

    private int mTextColor;

    /** Song constructor */
    public Song (int imageResourceId, String SongName, String artistName, int color){
        mImageResourceId = imageResourceId;
        mSongName = SongName;
        mArtistName = artistName;
        mTextColor = color;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /** method to get the song name for the song */
    public String getSongName(){
        return mSongName;
    }

    /** method to get the artist name for the song */
    public String getArtistName(){ return mArtistName; }

    public int getTextColor() { return mTextColor; }


}
