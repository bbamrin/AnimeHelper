package com.example.nick.animehelper.model.DataBase;

import android.provider.BaseColumns;

public class ContractClass {

    private ContractClass(){

    }

    public static class AnimeDataBase implements BaseColumns{
        public static final String TABLE_NAME = "AnimeTable";
        public static final String ANIME_NAME = "AnimeName";
        public static final String JSON_ANIME_GENRES = "AnimeGenres";
        public static final String ANIME_PICTURE_LOCATION = "PictureLocation";
        public static final String ANIME_DESCRIPTION = "AnimeDescriprion";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        JSON_ANIME_GENRES + " TEXT," +
                        ANIME_NAME + " TEXT," +
                        ANIME_DESCRIPTION  + " TEXT," +
                        ANIME_PICTURE_LOCATION + " TEXT)";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;


    }

}
