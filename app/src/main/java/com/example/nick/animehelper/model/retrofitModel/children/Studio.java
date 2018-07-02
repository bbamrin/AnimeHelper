
package com.example.nick.animehelper.model.retrofitModel.children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Studio {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("filtered_name")
    @Expose
    private String filteredName;
    @SerializedName("real")
    @Expose
    private String real;
    @SerializedName("image")
    @Expose
    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilteredName() {
        return filteredName;
    }

    public void setFilteredName(String filteredName) {
        this.filteredName = filteredName;
    }

    public String getReal() {
        return real;
    }

    public void setReal(String real) {
        this.real = real;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



}
