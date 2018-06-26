package com.example.nick.animehelper.model;

import android.provider.BaseColumns;

public class ContractClass {

    public static class AnimeDataBase implements BaseColumns{
        public static final String TABLE_NAME = "AnimeTable";
        public static final String ANIME_NAME = "AnimeName";
        public static final String JSON_ANIME_GENRES = "AnimeGenres";
        public static final String ANIME_PICTURE_LOCATION = "PictureLocation";
        public static final String ANIME_DESCRIPTION = "AnimeDescriprion";

    }

}
