package com.mustafa.juvo.Model;

public class Activity {
    private String date;
    private String time;
    private String title;
    private String person;
    private String picture;
    private String responsible;
    private String description;
    private int viewType;

    public Activity() {

    }

    public Activity(String date, String time, String title, String person, String picture, String responsible, String description, int viewType) {
        this.date = date;
        this.time = time;
        this.title = title;
        this.person = person;
        this.picture = picture;
        this.responsible = responsible;
        this.description = description;
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Activity{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", title='" + title + '\'' +
                ", person='" + person + '\'' +
                ", picture='" + picture + '\'' +
                ", responsible='" + responsible + '\'' +
                ", description='" + description + '\'' +
                ", viewType=" + viewType +
                '}';
    }
}
