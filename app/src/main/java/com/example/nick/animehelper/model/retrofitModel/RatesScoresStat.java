
package com.example.nick.animehelper.model.retrofitModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RatesScoresStat {

    @SerializedName("name")
    @Expose
    private Integer name;
    @SerializedName("value")
    @Expose
    private Integer value;

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }



}
