package com.example.travellerapp;

import java.nio.charset.Charset;

public class ViewModel {

    int image_id;
    String title_id;
    String desc_id;

    public ViewModel(int image_id, String title_id, String desc_id) {
        this.image_id = image_id;
        this.title_id = title_id;
        this.desc_id = desc_id;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getTitle_id() {
        return title_id;
    }

    public void setTitle_id(String title_id) {
        this.title_id = title_id;
    }

    public String getDesc_id() {
        return desc_id;
    }

    public void setDesc_id(String desc_id) {
        this.desc_id = desc_id;
    }

}
