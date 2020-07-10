package com.example.android.musicalstructureapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    ArrayList<Song> songs;
    public RecyclerViewAdapter(ArrayList<Song> songs){
        songs = songs;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView artistNameView;
        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            artistNameView = (TextView)itemView.findViewById(R.id.small_artistTextView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.list_item_horizontal,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        holder.artistNameView(songs[position]);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }
}

