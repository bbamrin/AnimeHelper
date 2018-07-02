package com.example.nick.animehelper.presenter.clickListeners;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.example.nick.animehelper.model.internalModel.Classification;
import com.example.nick.animehelper.model.internalModel.Genre;
import com.example.nick.animehelper.presenter.adapters.ClassificationRecyclerAdapter;
import com.example.nick.animehelper.presenter.adapters.GenreRecyclerViewAdapter;
import com.example.nick.animehelper.view.fragments.ClassificationRecyclerFragment;

import java.util.ArrayList;
import java.util.Map;

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

    public void onClearClassificationButtonClickListener(GenreRecyclerViewAdapter adapter, ArrayList<Genre> list){

    }

    public void onSearchButtonClickListener(ArrayList<Classification> classificationList, Map<String, ArrayList<Genre>> genresWithClassificationMatching, FragmentManager manager) {

    }

    public void onClearAllButtonClickListener(ClassificationRecyclerAdapter adapter,Map<String, ArrayList<Genre>> genresWithClassificationMatching,ArrayList<Classification> classificationList){

    }


}
