package com.example.nick.animehelper.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.nick.animehelper.R;
import com.example.nick.animehelper.model.Genre;

import java.util.ArrayList;

public class GenreRecyclerViewAdapter extends RecyclerView.Adapter<GenreRecyclerViewAdapter.ViewHolder> {

    ArrayList<Genre> genreList;
    private Context mCtx;
    private OnItemClickListeners listener;

    public GenreRecyclerViewAdapter(ArrayList<Genre> list, Context context, OnItemClickListeners listener){
        this.genreList = list;
        this.listener = listener;
        this.mCtx = context;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView genreTextView;
        CheckBox genreCheckBox;
        public ViewHolder(final View itemView) {
            super(itemView);
            genreTextView = (TextView)itemView.findViewById(R.id.simpleGenreTextId);
            genreCheckBox = (CheckBox)itemView.findViewById(R.id.simpleGenreCheckBoxId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onGenreItemClick(getAdapterPosition(),itemView,mCtx,genreList);
                }
            });
            itemView.findViewById(R.id.simpleGenreCheckBoxId).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onGenreItemClick(getAdapterPosition(),itemView,mCtx,genreList);
                }
            });
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolder vh = new ViewHolder(inflater.inflate(R.layout.simple_genre_layout,parent,false));



        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.genreTextView.setText(genreList.get(position).getTextGenre());
        holder.genreCheckBox.setChecked(genreList.get(position).isChosen());



    }

    @Override
    public int getItemCount() {
        return genreList.size();
    }
}
