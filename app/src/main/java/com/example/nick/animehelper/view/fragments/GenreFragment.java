package com.example.nick.animehelper.view.fragments;

import android.app.Activity;
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
import com.example.nick.animehelper.model.internalModel.Genre;
import com.example.nick.animehelper.model.internalModel.StaticVars;
import com.example.nick.animehelper.presenter.clickListeners.ClickListenerFactory;
import com.example.nick.animehelper.presenter.adapters.GenreRecyclerViewAdapter;

import java.util.ArrayList;

public class GenreFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Genre> list;
    String classificationName;
    Button clearButton;
    static GenreRecyclerViewAdapter adapter;

    int classificationPosition;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {






        View fragmentView = inflater.inflate(R.layout.recycler_fragment_layout,container,false);

        clearButton = (Button)fragmentView.findViewById(R.id.multiFunctionalButton);
        clearButton.setText(getString(R.string.clear));


        recyclerView = (RecyclerView)fragmentView.findViewById(R.id.animeRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        Genre genre = new Genre();
        genre.setTextGenre("pacanskiy_flex");
        if(getArguments()!=null){
            list =  getArguments().getParcelableArrayList(StaticVars.GENRE_PARCELABLE_KEY);
            classificationPosition = getArguments().getInt(StaticVars.CLASSIFICATION_POSITION);
            classificationName = getArguments().getString(StaticVars.CLASSIFICATION_NAME);
        }

        TextView textView = (TextView)getActivity().findViewById(R.id.applicationNameTextView);
        textView.setText(classificationName);

        if (list== null){
            list = new ArrayList<>();
            list.add(genre);
            list.add(genre);
            list.add(genre);
            list.add(genre);
            list.add(genre);
            list.add(genre);

        }


         adapter = new GenreRecyclerViewAdapter(
                list,
                getContext(),
                ClickListenerFactory.getOnGenreItemClickListener()
        );
        recyclerView.setAdapter(adapter);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Genre g: list){
                    g.setChosen(false);
                }
                adapter.notifyDataSetChanged();
                Log.d(StaticVars.LOG_TAG,"shit");
            }
        });


        return fragmentView;




    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStop() {
        if(getTargetFragment() != null){
            super.onStop();
            Intent intent = new Intent();
            intent.putExtra(StaticVars.CHOSEN_GENRES,list);
            intent.putExtra(
                    StaticVars.CLASSIFICATION_NAME,
                    getArguments() == null ?"nullClassification":getArguments().getString(StaticVars.CLASSIFICATION_NAME)
            );
            intent.putExtra(StaticVars.CLASSIFICATION_POSITION,classificationPosition);
            Fragment fragment = getTargetFragment();
            fragment.onActivityResult(StaticVars.CLASSIFICATION_REQUEST_CODE, Activity.RESULT_OK,intent);
        }

        Log.d(StaticVars.LOG_TAG,getTargetFragment()==null?"null":"notNull");
        super.onStop();


    }
}
