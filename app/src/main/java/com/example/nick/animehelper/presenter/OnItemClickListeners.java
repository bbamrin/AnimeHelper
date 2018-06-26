package com.example.nick.animehelper.presenter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.example.nick.animehelper.model.Genre;
import com.example.nick.animehelper.view.ClassificationRecyclerFragment;
import com.example.nick.animehelper.view.MainActivity;

import java.util.ArrayList;

public abstract class OnItemClickListeners {
    public void onClassificationItemClick(int position,
                                          View itemView,
                                          Context ctx,
                                          FragmentManager fragmentManager,
                                          ClassificationRecyclerFragment fragment,
                                          String ClassificationName){

    }
    public void onClassificationItemClick(int position,
                                          View itemView,
                                          Context ctx,
                                          FragmentManager fragmentManager,
                                          ArrayList<Genre> genres,
                                          ClassificationRecyclerFragment fragment,
                                          String ClassificationName){


    }
    public void onGenreItemClick(int position, View itemView, Context ctx, ArrayList<Genre> genres){

    }

    public void onClearButtonClickListener(GenreRecyclerViewAdapter adapter, ArrayList<Genre> list){

    }

    public void onSearchButtonClickListener(){

    }

}
