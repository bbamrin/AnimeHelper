package com.example.nick.animehelper.view;

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
import com.example.nick.animehelper.model.Anime;
import com.example.nick.animehelper.model.Genre;
import com.example.nick.animehelper.model.StaticVars;
import com.example.nick.animehelper.presenter.AnimeRecyclerAdapter;
import com.example.nick.animehelper.presenter.ClickListenerFactory;
import com.example.nick.animehelper.presenter.GenreRecyclerViewAdapter;

import java.util.ArrayList;

public class AnimeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Genre> list;
    String classificationName;
    Button searchButton;


    int classificationPosition;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentView =  inflater.inflate(R.layout.recycler_fragment_layout,container,false);
        recyclerView = (RecyclerView)fragmentView.findViewById(R.id.animeRecycler);
        searchButton = (Button)fragmentView.findViewById(R.id.multiFunctionalButton);
        searchButton.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        ArrayList<Anime> list = new ArrayList<>();
        Anime anime = new Anime();
        anime.setName("JoJO Bizarre Adventures");
        anime.setStatus("Best Anime in The World");
        list.add(anime);
        AnimeRecyclerAdapter adapter = new AnimeRecyclerAdapter(this.getContext(),list);
        recyclerView.setAdapter(adapter);



        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
