package com.example.nick.animehelper.model.internalModel;

public class Classification {
    private String classificationName;
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


    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String text) {
        this.classificationName = text;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }
}
