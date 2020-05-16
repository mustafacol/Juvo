package com.mustafa.juvo.Model;

import com.mustafa.juvo.Adapters.DuyurularAdapter;

public class Duyuru {

    private String title;
    private String date;
    private String description;
    private int status;


    public Duyuru(String title, String date, String description, int status) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
