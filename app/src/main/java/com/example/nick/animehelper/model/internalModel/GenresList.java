package com.example.nick.animehelper.model.internalModel;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

//this is really bad solution, but i don`t want to add a database just to save a few static variables
public class GenresList {
    //adding genres to shared preferences
    public static void setUpGenres(Context context){
        SharedPreferences mSetting = context.getSharedPreferences(StaticVars.GENRE_SHARED_PREFERENCES,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSetting.edit();
        //putting genre name and its id on shikimori


        editor.putInt("Drama",8);
        editor.putInt("Драма",8);
        editor.putInt("Game",11);
        editor.putInt("Игры",11);
        editor.putInt("Psychological",40);
        editor.putInt("Психологическое",40);
        editor.putInt("Adventure",2);
        editor.putInt("Приключения",2);
        editor.putInt("Music",19);
        editor.putInt("Музыка",19);
        editor.putInt("Action",1);
        editor.putInt("Экшен",1);
        editor.putInt("Comedy",4);
        editor.putInt("Комедия",4);
        editor.putInt("Demons",6);
        editor.putInt("Демоны",6);
        editor.putInt("Police",39);
        editor.putInt("Полиция",39);
        editor.putInt("Space",29);
        editor.putInt("Космос",29);
        editor.putInt("Ecchi",9);
        editor.putInt("Этти",9);
        editor.putInt("Fantasy",10);
        editor.putInt("Фэнтези",10);
        editor.putInt("Historical",13);
        editor.putInt("Исторический",13);
        editor.putInt("Horror",14);
        editor.putInt("Ужасы",14);
        editor.putInt("Magic",16);
        editor.putInt("Магия",16);
        editor.putInt("Mecha",18);
        editor.putInt("Меха",18);
        editor.putInt("Parody",20);
        editor.putInt("Пародия",20);
        editor.putInt("Samurai",21);
        editor.putInt("Самураи",21);
        editor.putInt("Romance",22);
        editor.putInt("Романтика",22);
        editor.putInt("School",23);
        editor.putInt("Школа",23);
        editor.putInt("Shoujo",25);
        editor.putInt("Сёдзе",25);
        editor.putInt("Shounen",27);
        editor.putInt("Сёнен",27);
        editor.putInt("Shounen Ai",28);
        editor.putInt("Сёнен Ай",28);
        editor.putInt("Sports",30);
        editor.putInt("Спорт",30);
        editor.putInt("Vampire",32);
        editor.putInt("Вампиры",32);
        editor.putInt("Harem",35);
        editor.putInt("Гарем",35);
        editor.putInt("Slice of Life",36);
        editor.putInt("Повседневность",36);
        editor.putInt("Seinen",42);
        editor.putInt("Сейнен",42);
        editor.putInt("Josei",43);
        editor.putInt("Дзёсей",43);
        editor.putInt("Supernatural",37);
        editor.putInt("Сверхъестественное",37);
        editor.putInt("Thriller",41);
        editor.putInt("Триллер",41);
        editor.putInt("Shoujo Ai",26);
        editor.putInt("Сёдзе Ай",26);
        editor.putInt("Sci-Fi",24);
        editor.putInt("Фантастика",24);
        editor.putInt("Super Power",31);
        editor.putInt("Супер сила",31);
        editor.putInt("Military",38);
        editor.putInt("Военное",38);
        editor.putInt("Mystery",7);
        editor.putInt("Детектив",7);
        editor.putInt("Kids",15);
        editor.putInt("Детское",15);
        editor.putInt("Cars",3);
        editor.putInt("Машины",3);
        editor.putInt("Martial Arts",17);
        editor.putInt("Боевые искусства",17);
        editor.putInt("Dementia",5);
        editor.putInt("Безумие",5);

        editor.apply();



    }


}
