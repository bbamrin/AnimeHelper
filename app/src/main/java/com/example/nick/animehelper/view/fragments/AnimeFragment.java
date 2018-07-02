package com.example.nick.animehelper.view.fragments;

import android.content.Context;
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
import android.widget.Toast;

import com.example.nick.animehelper.R;
import com.example.nick.animehelper.model.internalModel.Anime;
import com.example.nick.animehelper.model.internalModel.Genre;
import com.example.nick.animehelper.model.internalModel.StaticVars;
import com.example.nick.animehelper.model.retrofitModel.AnimeModel;
import com.example.nick.animehelper.presenter.adapters.AnimeRecyclerAdapter;
import com.example.nick.animehelper.presenter.retrofit.ShikimoriService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Genre> listOfGenres;
    ArrayList<Anime> animeList;
    String classificationName;
    Button searchButton;
    Button clearAllButton;
    String genresShikimoriIdString;


    int classificationPosition;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        animeList = new ArrayList<>();
        genresShikimoriIdString = "";
        View fragmentView =  inflater.inflate(R.layout.recycler_fragment_layout,container,false);
        recyclerView = (RecyclerView)fragmentView.findViewById(R.id.animeRecycler);
        searchButton = (Button)fragmentView.findViewById(R.id.clearOrSearchButton);
        searchButton.setVisibility(View.GONE);
        clearAllButton = (Button)fragmentView.findViewById(R.id.clearAllButton);
        clearAllButton.setVisibility(View.GONE);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        final AnimeRecyclerAdapter adapter = new AnimeRecyclerAdapter(this.getContext(),animeList);
        recyclerView.setAdapter(adapter);

        ArrayList<String> chosenGenresNameList = getArguments().getStringArrayList(StaticVars.CHOSEN_GENRES);
        for(int i = 0; i < chosenGenresNameList.size();++i){
            Integer integer = getActivity().getSharedPreferences(StaticVars.GENRE_SHARED_PREFERENCES, Context.MODE_PRIVATE).getInt(chosenGenresNameList.get(i),-1);
            if(integer != -1){
                if(i != chosenGenresNameList.size()-1){
                    genresShikimoriIdString+=integer.toString() + ",";
                } else genresShikimoriIdString+=integer.toString();
            }

        }

        Log.d(StaticVars.LOG_TAG,genresShikimoriIdString);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StaticVars.BASE_SHIKIMORI_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ShikimoriService shikimoriService = retrofit.create(ShikimoriService.class);
        Call<ArrayList<AnimeModel>> call = shikimoriService
                .getAnimeListWithGenres(genresShikimoriIdString,"50","1");
        call.enqueue(new Callback<ArrayList<AnimeModel>>() {
            @Override
            public void onResponse(Call<ArrayList<AnimeModel>> call, Response<ArrayList<AnimeModel>> response) {
                Log.d(StaticVars.LOG_TAG,response.body().size() + "");

                if (response.body().size()!=0){
                    for(AnimeModel animeModel: response.body()){
                        Anime anime = new Anime();
                        anime.setName(animeModel.getRussian());
                        Log.d(StaticVars.LOG_TAG,animeModel.getImage().getPreview());
                        anime.setImageAddress(animeModel.getImage().getPreview());
                        animeList.add(anime);
                    }
                    adapter.notifyDataSetChanged();

                } else{
                    Toast.makeText(getActivity().getBaseContext(),"",Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<ArrayList<AnimeModel>> call, Throwable t) {
                Log.d(StaticVars.LOG_TAG,"server response: " + t.getMessage());
            }
        });



        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
