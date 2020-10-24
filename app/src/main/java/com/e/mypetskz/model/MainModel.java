package com.e.mypetskz.model;

import java.io.Serializable;

public class MainModel implements Serializable {

    public int img;
    public String title;

    public MainModel(int img, String title) {
        this.img = img;
        this.title = title;
    }
}