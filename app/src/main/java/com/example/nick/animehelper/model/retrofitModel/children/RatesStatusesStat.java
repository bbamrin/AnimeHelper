
package com.example.nick.animehelper.model.retrofitModel.children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RatesStatusesStat {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }



}
