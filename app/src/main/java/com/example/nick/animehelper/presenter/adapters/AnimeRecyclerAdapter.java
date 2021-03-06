package com.example.nick.animehelper.presenter.adapters;

import android.content.Context;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nick.animehelper.R;
import com.example.nick.animehelper.model.internalModel.Anime;
import com.example.nick.animehelper.model.internalModel.StaticVars;
import com.example.nick.animehelper.presenter.asyncTask.ImageDownloadingRunnable;


import java.util.ArrayList;

public class AnimeRecyclerAdapter extends RecyclerView.Adapter<AnimeRecyclerAdapter.ViewHolder> {


    ArrayList<Anime> animeArrayList;
    Context mCtx;
    Handler handler;



    public AnimeRecyclerAdapter(Context context,ArrayList<Anime> list){
        this.animeArrayList = list;
        this.mCtx = context;
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == StaticVars.ANIME_SET_IMAGE){
                    ImageDownloadingRunnable.MyBundle myBundle = (ImageDownloadingRunnable.MyBundle)msg.obj;
                    myBundle.getView().setImageBitmap(myBundle.getBmp());
                    Log.d(StaticVars.LOG_TAG,"bitmap received" + myBundle.getBmp().toString());
                }
            }
        };

    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewAnimeName;
        TextView textViewAnimeStatus;


        public ViewHolder(View itemView) {
            super(itemView);


            imageView = (ImageView)itemView.findViewById(R.id.imageAnimeId);
            textViewAnimeName = (TextView)itemView.findViewById(R.id.textAnimeClassificationId);
            textViewAnimeStatus = (TextView)itemView.findViewById(R.id.textAnimeChosenId);


        }
    }


    @NonNull
    @Override
    public AnimeRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context ctx = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(ctx);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.anime_or_genre_card,parent,false));



        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeRecyclerAdapter.ViewHolder holder, int position) {
        Anime anime = animeArrayList.get(position);
        ImageDownloadingRunnable setImageRunnable = new ImageDownloadingRunnable(holder.imageView, StaticVars.BASE_SHIKIMORI_URL +anime.getImageAddress(), handler);
        Thread imageDowloadingThread = new Thread(setImageRunnable);
        imageDowloadingThread.start();
        holder.textViewAnimeName.setText(anime.getName());
        holder.textViewAnimeStatus.setText(anime.getStatus());

    }

    @Override
    public int getItemCount() {
        return animeArrayList.size();
    }
}
