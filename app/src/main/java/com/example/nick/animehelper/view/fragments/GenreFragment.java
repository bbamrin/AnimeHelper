package com.example.nick.animehelper.view.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nick.animehelper.R;
import com.example.nick.animehelper.model.internalModel.Genre;
import com.example.nick.animehelper.model.internalModel.StaticVars;
import com.example.nick.animehelper.presenter.clickListeners.ClickListenerFactory;
import com.example.nick.animehelper.presenter.adapters.GenreRecyclerViewAdapter;

import java.util.ArrayList;

public class GenreFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Genre> genreList;
    String classificationName;
    Button clearButton;
    Button hiddenClearAllButton;
    GenreRecyclerViewAdapter adapter;

    int classificationPosition;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {






        View fragmentView = inflater.inflate(R.layout.recycler_fragment_layout,container,false);

        clearButton = (Button)fragmentView.findViewById(R.id.clearOrSearchButton);
        clearButton.setText(getString(R.string.clear));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 7;
        clearButton.setLayoutParams(params);
        hiddenClearAllButton = (Button)fragmentView.findViewById(R.id.clearAllButton);
        hiddenClearAllButton.setVisibility(View.GONE);

        recyclerView = (RecyclerView)fragmentView.findViewById(R.id.animeRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        if(getArguments()!=null){
            genreList =  getArguments().getParcelableArrayList(StaticVars.GENRE_PARCELABLE_KEY);
            classificationPosition = getArguments().getInt(StaticVars.CLASSIFICATION_POSITION);
            classificationName = getArguments().getString(StaticVars.CLASSIFICATION_NAME);
        }

        if (genreList== null){
            genreList = new ArrayList<>();
            fillRecycler(classificationName,genreList);
        }




        TextView textView = (TextView)getActivity().findViewById(R.id.applicationNameTextView);
        textView.setText(classificationName);


        adapter = new GenreRecyclerViewAdapter(
                 genreList,
                getContext(),
                ClickListenerFactory.getOnGenreItemClickListener()
        );
        recyclerView.setAdapter(adapter);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Genre g: genreList){
                    g.setChosen(false);
                }
                adapter.notifyDataSetChanged();

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
            intent.putExtra(StaticVars.CHOSEN_GENRES, genreList);
            intent.putExtra(
                    StaticVars.CLASSIFICATION_NAME,
                    getArguments() == null ?"nullClassification":getArguments().getString(StaticVars.CLASSIFICATION_NAME)
            );
            intent.putExtra(StaticVars.CLASSIFICATION_POSITION,classificationPosition);
            Fragment fragment = getTargetFragment();
            fragment.onActivityResult(StaticVars.CLASSIFICATION_REQUEST_CODE, Activity.RESULT_OK,intent);
        }

        super.onStop();


    }


    public void fillRecycler(String classification, ArrayList<Genre> list){
        if (classification == StaticVars.TARGET_AUDIENCE){
            Genre ShoujoAi= new Genre();
            ShoujoAi.setTextGenre("Сёдзе Ай");
            list.add(ShoujoAi);
            Genre Josei= new Genre();
            Josei.setTextGenre("Дзёсей");
            list.add(Josei);
            Genre Seinen= new Genre();
            Seinen.setTextGenre("Сейнен");
            list.add(Seinen);
            Genre ShounenAi= new Genre();
            ShounenAi.setTextGenre("Сёнен Ай");
            list.add(ShounenAi);
            Genre Shounen= new Genre();
            Shounen.setTextGenre("Сёнен");
            list.add(Shounen);
            Genre Shoujo= new Genre();
            Shoujo.setTextGenre("Сёдзе");
            list.add(Shoujo);
            Genre Kids= new Genre();
            Kids.setTextGenre("Детское");
            list.add(Kids);

        } else if(classification == StaticVars.SETTING){
            Genre Space= new Genre();
            Space.setTextGenre("Космос");
            list.add(Space);
            Genre Historical= new Genre();
            Historical.setTextGenre("Исторический");
            list.add(Historical);
            Genre Fantasy= new Genre();
            Fantasy.setTextGenre("Фэнтези");
            list.add(Fantasy);
            Genre School= new Genre();
            School.setTextGenre("Школа");
            list.add(School);
            Genre SliceOfLife= new Genre();
            SliceOfLife.setTextGenre("Повседневность");
            list.add(SliceOfLife);

        } else if(classification == StaticVars.ANTOURAGE){
            Genre Magic= new Genre();
            Magic.setTextGenre("Магия");
            list.add(Magic);
            Genre Adventure= new Genre();
            Adventure.setTextGenre("Приключения");
            list.add(Adventure);
            Genre Police= new Genre();
            Police.setTextGenre("Полиция");
            list.add(Police);
            Genre Samurai= new Genre();
            Samurai.setTextGenre("Самураи");
            list.add(Samurai);
            Genre Music= new Genre();
            Music.setTextGenre("Музыка");
            list.add(Music);
            Genre Vampire= new Genre();
            Vampire.setTextGenre("Вампиры");
            list.add(Vampire);
            Genre Sports= new Genre();
            Sports.setTextGenre("Спорт");
            list.add(Sports);
            Genre Supernatural= new Genre();
            Supernatural.setTextGenre("Сверхъестественное");
            list.add(Supernatural);
            Genre Thriller= new Genre();
            Thriller.setTextGenre("Триллер");
            list.add(Thriller);
            Genre SciFi= new Genre();
            SciFi.setTextGenre("Фантастика");
            list.add(SciFi);
            Genre SuperPower= new Genre();
            SuperPower.setTextGenre("Супер сила");
            list.add(SuperPower);
            Genre Military= new Genre();
            Military.setTextGenre("Военное");
            list.add(Military);
            Genre Mystery= new Genre();
            Mystery.setTextGenre("Детектив");
            list.add(Mystery);
            Genre Cars= new Genre();
            Cars.setTextGenre("Машины");
            list.add(Cars);
            Genre MartialArts= new Genre();
            MartialArts.setTextGenre("Боевые искусства");
            list.add(MartialArts);
            Genre Game= new Genre();
            Game.setTextGenre("Игры");
            list.add(Game);
            Genre Dementia= new Genre();
            Dementia.setTextGenre("Безумие");
            list.add(Dementia);

        }else if (classification ==StaticVars.STYLE_OF_NARRATIVE){
            Genre Drama= new Genre();
            Drama.setTextGenre("Драма");
            list.add(Drama);
            Genre Psychological= new Genre();
            Psychological.setTextGenre("Психологическое");
            list.add(Psychological);
            Genre Action= new Genre();
            Action.setTextGenre("Экшен");
            list.add(Action);
            Genre Comedy= new Genre();
            Comedy.setTextGenre("Комедия");
            list.add(Comedy);
            Genre Ecchi= new Genre();
            Ecchi.setTextGenre("Этти");
            list.add(Ecchi);
            Genre Horror= new Genre();
            Horror.setTextGenre("Ужасы");
            list.add(Horror);
            Genre Parody= new Genre();
            Parody.setTextGenre("Пародия");
            list.add(Parody);
            Genre Romance= new Genre();
            Romance.setTextGenre("Романтика");
            list.add(Romance);
            Genre Harem= new Genre();
            Harem.setTextGenre("Гарем");
            list.add(Harem);

        } else{
            Genre genre = new Genre();
            genre.setTextGenre("nothing");
            list.add(genre);
        }






    }

}
