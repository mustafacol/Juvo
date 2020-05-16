package com.mustafa.juvo.Model;

public class SingleWork {
    String header,location,explanation,
            responsible,date,target_time,
            remain_time,situation;
    boolean status;

    public SingleWork(String header, String location, String explanation, String responsible, String date, String target_time, String remain_time, String situation,boolean status) {
        this.header = header;
        this.location = location;
        this.explanation = explanation;
        this.responsible = responsible;
        this.date = date;
        this.target_time = target_time;
        this.remain_time = remain_time;
        this.situation = situation;
        this.status=status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTarget_time() {
        return target_time;
    }

    public void setTarget_time(String target_time) {
        this.target_time = target_time;
    }

    public String getRemain_time() {
        return remain_time;
    }

    public void setRemain_time(String remain_time) {
        this.remain_time = remain_time;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
