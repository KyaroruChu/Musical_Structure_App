package com.example.android.musicalstructureapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Song> mSongs;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iconImageView;
        public TextView songNameView;
        public TextView artistNameView;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            iconImageView = (ImageView) itemView.findViewById(R.id.playlist_item_imageView);
            songNameView = (TextView) itemView.findViewById(R.id.small_songNameTextView);
            artistNameView = (TextView) itemView.findViewById(R.id.small_artistTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAbsoluteAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public RecyclerViewAdapter (ArrayList<Song> songs){
        mSongs = songs;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_horizontal,parent, false);
        ViewHolder vh = new ViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song currentItem = mSongs.get(position);
        holder.iconImageView.setImageResource(currentItem.getImageResourceId());
        holder.songNameView.setText(currentItem.getSongName());
        holder.artistNameView.setText(currentItem.getArtistName());
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }
}

