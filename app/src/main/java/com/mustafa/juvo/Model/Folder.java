package com.mustafa.juvo.Model;

public class Folder {
    private String title;
    private String date;
    private String time;
    private String responsible;
    private String description;
    private int viewType;

    public Folder() {
    }


    public Folder(String title, String date, String time, String responsible, String description, int viewType) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.responsible = responsible;
        this.description = description;
        this.viewType = viewType;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getResponsible() {
        return responsible;
    }

    public String getDescription() {
        return description;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
