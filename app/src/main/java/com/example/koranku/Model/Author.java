package com.example.koranku.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Author {

    @SerializedName("id")
    @Expose
    private String status;

    @SerializedName("name")
    @Expose
    private String name;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
