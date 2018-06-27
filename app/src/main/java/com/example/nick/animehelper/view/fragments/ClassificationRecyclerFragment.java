package com.example.nick.animehelper.view.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nick.animehelper.R;
import com.example.nick.animehelper.model.internalModel.Classification;
import com.example.nick.animehelper.model.internalModel.Genre;
import com.example.nick.animehelper.model.internalModel.StaticVars;
import com.example.nick.animehelper.presenter.adapters.ClassificationRecyclerAdapter;
import com.example.nick.animehelper.presenter.clickListeners.ClickListenerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassificationRecyclerFragment extends Fragment {


    RecyclerView recyclerView;
    ArrayList<Genre> genres;
    View fragmentView;
    Button searchButton;
    String chosenGenres;
    ArrayList<Classification> classificationList;
    static Map<String, ArrayList<Genre>> classificationWithGenresMatchingString = new HashMap<>();
    ArrayList<ArrayList<Genre>> genresToFindAnime;
    String returnedClassification;
    int returnedPosition =  -666;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == StaticVars.CLASSIFICATION_REQUEST_CODE){
                genres = data.getParcelableArrayListExtra(StaticVars.CHOSEN_GENRES);
                returnedPosition = data.getIntExtra(StaticVars.CLASSIFICATION_POSITION,-1);
                returnedClassification = data.getStringExtra(StaticVars.CLASSIFICATION_NAME);
                Log.d(StaticVars.LOG_TAG, returnedPosition + "");
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        genresToFindAnime = new ArrayList<>();

        TextView textView =  (TextView)getActivity().findViewById(R.id.applicationNameTextView);
        textView.setText(getString(R.string.app_name));





        fragmentView = inflater.inflate(R.layout.recycler_fragment_layout,container,false);
        searchButton  = (Button)fragmentView.findViewById(R.id.multiFunctionalButton);
        searchButton.setText(getString(R.string.find));
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().
                        getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.animeFragmentContainer , new AnimeFragment(),StaticVars.ANIME_FRAGMENT_TAG).
                        addToBackStack(StaticVars.BACKSTACK).
                        commit();
            }
        });


        recyclerView = (RecyclerView)fragmentView.findViewById(R.id.animeRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));


        classificationList = new ArrayList<>();
        Classification cl =  new Classification();
        Classification classification = new Classification();
        classification.setTextClassification("сеттинг");
        cl.setTextClassification("жанр");
        classificationList.add(cl);
        classificationList.add(classification);



        if(genres==null){
            ClassificationRecyclerAdapter classificationRecyclerAdapter = new ClassificationRecyclerAdapter(
                    classificationList,
                    getActivity().getBaseContext(),
                    ClickListenerFactory.getClassificationOnItemClickListenerWithoutGenres(),
                    getActivity().getSupportFragmentManager(),
                    this,
                    StaticVars.STATE_WITHOUT_GENRES);
            recyclerView.setAdapter(classificationRecyclerAdapter);
        } else {
            if (returnedClassification != null){
                classificationWithGenresMatchingString.put(returnedClassification,genres);
            }

            for (int i = 0; i < classificationList.size();++i){
                Classification c = classificationList.get(i);
                chosenGenres = "";
                if (classificationWithGenresMatchingString.get(c.getTextClassification())!=null){
                    ArrayList<Genre> lotOfGenres = classificationWithGenresMatchingString.get(c.getTextClassification());
                    ArrayList<Genre> chosenGenresList = new ArrayList<>();
                    for(Genre g : lotOfGenres){
                        if (g.isChosen()){
                            chosenGenresList.add(g);
                        }
                    }

                    for (int k = 0; k < chosenGenresList.size();++k){
                        Genre g = chosenGenresList.get(k);
                        if (g.isChosen()){
                            if (k!=chosenGenresList.size()-1){
                                chosenGenres +=" " + g.getTextGenre()+",";
                                Log.d(StaticVars.LOG_TAG,"k: " + k);
                                Log.d(StaticVars.LOG_TAG,"size: " + lotOfGenres.size());
                            } else{
                                chosenGenres +=" " + g.getTextGenre() + ".";
                            }
                        }
                    }

                }
                Classification oldClassification = c;
                Classification classificationNew = new Classification();
                classificationNew.setTextClassification(oldClassification.getTextClassification());
                classificationNew.setImageAddress(oldClassification.getImageAddress());
                classificationNew.setChosenGenreText(chosenGenres);
                classificationList.remove(i);
                classificationList.add(i,classificationNew);
                classificationList.get(i).setChosenGenreText(chosenGenres);

            }

            ClassificationRecyclerAdapter classificationRecyclerAdapter = new ClassificationRecyclerAdapter(
                    classificationList,
                    getActivity().getBaseContext(),
                    ClickListenerFactory.getClassificationOnItemClickListenerWithGenres(),
                    getActivity().getSupportFragmentManager(),
                    classificationWithGenresMatchingString,
                    this,
                    StaticVars.STATE_WITH_GENRES);
            recyclerView.setAdapter(classificationRecyclerAdapter);
        }

        return fragmentView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
