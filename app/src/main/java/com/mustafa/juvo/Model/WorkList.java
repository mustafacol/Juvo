package com.mustafa.juvo.Model;

public class WorkList {
    private String description;
    private String count;

    public WorkList(String description, String count) {
        this.description = description;
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public String getCount() {
        return count;
    }
}
