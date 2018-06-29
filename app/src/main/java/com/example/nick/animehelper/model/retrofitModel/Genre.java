
package com.example.nick.animehelper.model.retrofitModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Genre {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("russian")
    @Expose
    private String russian;
    @SerializedName("kind")
    @Expose
    private String kind;

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

    public String getRussian() {
        return russian;
    }

    public void setRussian(String russian) {
        this.russian = russian;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }



}
