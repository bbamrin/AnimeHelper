package com.example.nick.animehelper.presenter.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nick.animehelper.R;
import com.example.nick.animehelper.model.internalModel.Classification;
import com.example.nick.animehelper.model.internalModel.Genre;
import com.example.nick.animehelper.model.internalModel.StaticVars;
import com.example.nick.animehelper.presenter.clickListeners.OnItemClickListeners;
import com.example.nick.animehelper.view.fragments.ClassificationRecyclerFragment;

import java.util.ArrayList;
import java.util.Map;

public class ClassificationRecyclerAdapter extends RecyclerView.Adapter<ClassificationRecyclerAdapter.ViewHolder> {

    private ArrayList<Classification> mListOfClassifications;
    private Context mCtx;
    private OnItemClickListeners listener;
    private FragmentManager fragmentManager;
    private ClassificationRecyclerFragment fragment;
    private String WHAT_IS_HAPPENING;
    private Map<String,ArrayList<Genre>> classificationWithGenresMatchingString;



    public ClassificationRecyclerAdapter(ArrayList<Classification> list,
                                         Context context,
                                         OnItemClickListeners listener,
                                         FragmentManager manager,
                                         ClassificationRecyclerFragment fragment,
                                         String whatIsHappening){
        this.mCtx = context;
        this.mListOfClassifications = list;
        this.listener = listener;
        this.fragmentManager = manager;
        this.fragment = fragment;
        this.WHAT_IS_HAPPENING = whatIsHappening;
    }
    public ClassificationRecyclerAdapter(ArrayList<Classification> list,
                                         Context context,
                                         OnItemClickListeners listener,
                                         FragmentManager manager,
                                         Map<String,ArrayList<Genre>> classificationWithGenresMatching,
                                         ClassificationRecyclerFragment fragment,
                                         String whatIsHappening){
        this.WHAT_IS_HAPPENING = whatIsHappening;
        this.fragment = fragment;
        this.mCtx = context;
        this.mListOfClassifications = list;
        this.listener = listener;
        this.fragmentManager = manager;
        this.classificationWithGenresMatchingString = classificationWithGenresMatching;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewClassification;
        TextView textViewChosen;
        ArrayList<Genre> genreList;

        public ViewHolder(final View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageAnimeId);
            textViewClassification = (TextView)itemView.findViewById(R.id.textAnimeClassificationId);
            textViewChosen = (TextView)itemView.findViewById(R.id.textAnimeChosenId);
            if (WHAT_IS_HAPPENING.equals(StaticVars.STATE_WITH_GENRES)){
                itemView.findViewById(R.id.classificationCardId).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener!= null && getAdapterPosition()!=RecyclerView.NO_POSITION){
                            listener.onClassificationItemClick(getAdapterPosition(),
                                    itemView,
                                    mCtx,
                                    fragmentManager,
                                    classificationWithGenresMatchingString.get(mListOfClassifications.get(getAdapterPosition()).getClassificationName()),
                                    fragment,
                                    mListOfClassifications.get(getAdapterPosition()).getClassificationName()
                                    );
                        }
                    }
                });

            } else {
                itemView.findViewById(R.id.classificationCardId).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener!= null && getAdapterPosition()!=RecyclerView.NO_POSITION){
                            listener.onClassificationItemClick(getAdapterPosition(),
                                    itemView,
                                    mCtx,
                                    fragmentManager,
                                    fragment,
                                    mListOfClassifications.get(getAdapterPosition()).getClassificationName());
                        }
                    }
                });

            }


        }
    }



    @NonNull
    @Override
    public ClassificationRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mCtx = parent.getContext();
        LayoutInflater inflater  = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.anime_or_genre_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassificationRecyclerAdapter.ViewHolder holder, int position) {
        Classification classification = mListOfClassifications.get(position);


        holder.textViewClassification.setText(classification.getClassificationName());
        if(WHAT_IS_HAPPENING.equals(StaticVars.STATE_WITH_GENRES)){

            ArrayList<Genre> genresList = new ArrayList<>();
            if (classificationWithGenresMatchingString!=null){
                genresList  = classificationWithGenresMatchingString.get(classification.getClassificationName());
            }
            String classificationGenresText = "";
            if (genresList != null){
                for(int i = 0; i < genresList.size();++i){
                    if (genresList.get(i).isChosen()){
                        classificationGenresText+=genresList.get(i).getTextGenre() + ", ";
                    }
                }
            }
            StringBuilder builder = new StringBuilder(classificationGenresText);
            if (classificationGenresText!=""){
                builder.setCharAt(classificationGenresText.length()-2,'.');
            }

            classificationGenresText = builder.toString();
            classification.setChosenGenreText(classificationGenresText);
            holder.textViewChosen.setText(classification.getChosenGenreText());
        }


        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable((R.drawable.pacanskiy_flex)));

    }

    @Override
    public int getItemCount() {
        return mListOfClassifications.size();
    }
}
