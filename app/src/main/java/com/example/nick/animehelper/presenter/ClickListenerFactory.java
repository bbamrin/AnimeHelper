package com.example.nick.animehelper.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.nick.animehelper.R;
import com.example.nick.animehelper.model.Genre;
import com.example.nick.animehelper.model.StaticVars;
import com.example.nick.animehelper.view.ClassificationRecyclerFragment;
import com.example.nick.animehelper.view.GenreFragment;
import com.example.nick.animehelper.view.MainActivity;

import java.util.ArrayList;

public class ClickListenerFactory {
    static public OnItemClickListeners getClassificationOnItemClickListenerWithoutGenres(){
        return new OnItemClickListeners() {
            @Override
            public void onClassificationItemClick(int position,
                                                  View itemView,
                                                  Context ctx,
                                                  FragmentManager manager,
                                                  ClassificationRecyclerFragment fragment,
                                                  String classificationName) {
                //добавить тэг фрагмента в staticVars
                ClassificationRecyclerFragment fragmentClassification = fragment;
                if (fragmentClassification==null){
                    Log.d(StaticVars.LOG_TAG,"class fr null");
                } else{
                    Log.d(StaticVars.LOG_TAG,"class fr not null");
                }
                GenreFragment genreFragment = new GenreFragment();
                Bundle args = new Bundle();
                args.putString(StaticVars.CLASSIFICATION_NAME,classificationName);
                genreFragment.setArguments(args);
                genreFragment.setTargetFragment(fragmentClassification,StaticVars.CLASSIFICATION_REQUEST_CODE);
                manager.
                        beginTransaction().
                        replace(R.id.animeFragmentContainer,genreFragment, StaticVars.GENRE_FRAGMENT_TAG).
                        addToBackStack(StaticVars.BACKSTACK).
                        commit();


            }
        };
    }




    static public OnItemClickListeners getClassificationOnItemClickListenerWithGenres(){
        return new OnItemClickListeners() {
            @Override
            public void onClassificationItemClick(int position,
                                                  View itemView,
                                                  Context ctx,
                                                  FragmentManager manager,
                                                  ArrayList<Genre> genres,
                                                  ClassificationRecyclerFragment fragment,
                                                  String classificationName) {
                //добавить тэг фрагмента в staticVars
                Log.d(StaticVars.LOG_TAG,"sosi");

                ClassificationRecyclerFragment fragmentClassification = fragment;
                GenreFragment genreFragment = new GenreFragment();
                genreFragment.setTargetFragment(fragmentClassification,StaticVars.CLASSIFICATION_REQUEST_CODE);
                Bundle args = new Bundle();
                args.putString(StaticVars.CLASSIFICATION_NAME,classificationName);
                args.putInt(StaticVars.CLASSIFICATION_POSITION,position);
                args.putParcelableArrayList(StaticVars.GENRE_PARCELABLE_KEY,genres);
                genreFragment.setArguments(args);
                manager.
                        beginTransaction().
                        replace(R.id.animeFragmentContainer,genreFragment, StaticVars.GENRE_FRAGMENT_TAG).
                        addToBackStack(StaticVars.BACKSTACK).
                        commit();


            }
        };
    }


    static public OnItemClickListeners getOnGenreItemClickListener(){
        return new OnItemClickListeners() {
            @Override
            public void onGenreItemClick(int position,
                                         View itemView,
                                         Context ctx,
                                         ArrayList<Genre> genreArrayList) {
                CheckBox checkBox =  (CheckBox)itemView.findViewById(R.id.simpleGenreCheckBoxId);
                Genre genre =  genreArrayList.get(position);
                Genre newGenre = new Genre();
                newGenre.setTextGenre(genre.getTextGenre());
                newGenre.setChosen(genre.isChosen());
                newGenre.toggleChoose();
                genreArrayList.remove(position);
                genreArrayList.add(position,newGenre);
                checkBox.setChecked(newGenre.isChosen());
                Toast.makeText(ctx,genre.isChosen()+"",Toast.LENGTH_SHORT).show();

            }
        };

    }


    static public OnItemClickListeners getOnClearBUttonClickListener(GenreRecyclerViewAdapter adapterF,ArrayList<Genre> listF){
        return new OnItemClickListeners() {
            @Override
            public void onClearButtonClickListener(GenreRecyclerViewAdapter adapter, ArrayList<Genre> list) {
                int position;
                for(Genre i: list){
                    i.setChosen(false);
                }
                adapter.notifyItemRangeChanged(0,list.size());

            }
        };
    }



}
