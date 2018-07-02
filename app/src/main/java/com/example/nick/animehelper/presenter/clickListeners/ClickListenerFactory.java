package com.example.nick.animehelper.presenter.clickListeners;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.nick.animehelper.R;
import com.example.nick.animehelper.model.internalModel.Classification;
import com.example.nick.animehelper.model.internalModel.Genre;
import com.example.nick.animehelper.model.internalModel.StaticVars;
import com.example.nick.animehelper.presenter.adapters.ClassificationRecyclerAdapter;
import com.example.nick.animehelper.view.fragments.AnimeFragment;
import com.example.nick.animehelper.view.fragments.ClassificationRecyclerFragment;
import com.example.nick.animehelper.view.fragments.GenreFragment;

import java.util.ArrayList;
import java.util.Map;

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


    /*static public OnItemClickListeners getOnClearButtonClickListener(GenreRecyclerViewAdapter adapterF, ArrayList<Genre> listF){
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
    }*/


    static public OnItemClickListeners getOnClearAllButtonClickListener(){
        return new OnItemClickListeners() {
            @Override
            public void onClearAllButtonClickListener(ClassificationRecyclerAdapter adapter, Map<String, ArrayList<Genre>> genresWithClassificationMatching,ArrayList<Classification> classificationList) {
                for(Classification c:classificationList){
                    ArrayList<Genre> genres = genresWithClassificationMatching.get(c.getClassificationName());
                    if (genres!=null){
                        for(Genre g: genres){
                            g.setChosen(false);
                        }
                    }
                }
                adapter.notifyDataSetChanged();
            }
        };
    }

    static public OnItemClickListeners getOnSearchButtonClickListener(){
        return new OnItemClickListeners() {
            @Override
            public void onSearchButtonClickListener(ArrayList<Classification> classificationList, Map<String, ArrayList<Genre>> genresWithClassificationMatching, FragmentManager manager) {
                AnimeFragment animes =  new AnimeFragment();
                ArrayList<String> listOfGenresToFind= new ArrayList<>();
                for (int i = 0; i < classificationList.size();++i) {
                    Classification c = classificationList.get(i);
                    if (genresWithClassificationMatching.get(c.getClassificationName()) != null) {
                        ArrayList<Genre> lotOfGenres = genresWithClassificationMatching.get(c.getClassificationName());
                        for (Genre g : lotOfGenres) {
                            if (g.isChosen()) {
                                listOfGenresToFind.add(g.getTextGenre());
                            }
                        }
                    }
                }

                Bundle bundle = new Bundle();
                bundle.putStringArrayList(StaticVars.CHOSEN_GENRES,listOfGenresToFind);
                animes.setArguments(bundle);

                manager.
                        beginTransaction().
                        replace(R.id.animeFragmentContainer ,animes,StaticVars.ANIME_FRAGMENT_TAG).
                        addToBackStack(StaticVars.BACKSTACK).
                        commit();

            }
        };
    }



}
