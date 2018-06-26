package com.example.nick.animehelper.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Genre implements Parcelable {
    private String textGenre;
    private  boolean isChosen = false;

    public static final Creator<Genre> CREATOR = new Creator<Genre>() {
        @Override
        public Genre createFromParcel(Parcel in) {
            return new Genre(in);
        }

        @Override
        public Genre[] newArray(int size) {
            return new Genre[size];
        }
    };

    public Genre(){

    }

    public String getTextGenre() {
        return textGenre;
    }

    public void setTextGenre(String textGenre) {
        this.textGenre = textGenre;
    }

    public boolean isChosen() {
        return isChosen;
    }

    public void setChosen(boolean chosen) {
        isChosen = chosen;
    }

    public void toggleChoose(){isChosen = !isChosen;}

    public Genre(Parcel in){
        boolean[] data = new boolean[1];
        this.textGenre = in.readString();
        in.readBooleanArray(data);
        this.isChosen = data[0];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(textGenre);
        dest.writeBooleanArray(new boolean[]{this.isChosen});
    }
}
