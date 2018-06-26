package com.example.nick.animehelper.model;

public class Classification {
    private String textClassification;
    private String imageAddress;
    private String chosenGenreText;

    public String getChosenGenreText() {
        return chosenGenreText;
    }

    public void setChosenGenreText(String chosenGenreText) {
        this.chosenGenreText = chosenGenreText;
    }

    private boolean isChosen;

    public boolean isChosen() {
        return isChosen;
    }

    public void setChosen(boolean chosen) {
        isChosen = chosen;
    }


    public String getTextClassification() {
        return textClassification;
    }

    public void setTextClassification(String text) {
        this.textClassification = text;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }
}
