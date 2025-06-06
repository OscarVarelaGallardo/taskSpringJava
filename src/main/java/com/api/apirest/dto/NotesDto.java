package com.api.apirest.dto;

import java.util.Date;

public class NotesDto {
    private String task;
    private Date date;
    private String color;
    private String id;

    public String getColor() {
        return color;
    }
    public String getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }
    public String getTask() {
        return task;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public void setTask(String task) {
        this.task = task;
    }


}
