package com.example.nick.animehelper.presenter.retrofit;

import com.example.nick.animehelper.model.retrofitModel.AnimeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface shikimoriService {

    @GET("api/animes")
    public Call<List<AnimeModel>> getAnimeListWithGenres(@Query("genre") String genres);



}
