package com.dmhere.plantcareplanner.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private int id;
    private String name;
    private String description;
    private Boolean isRecurring;
    private Timestamp dueDate;

    @Override
    public String toString(){
        return "Task [id=" + id
                + ", name=" + name
                + ", description=" + description
                + ", isRecurring=" + isRecurring
                + ", dueDate=" + dueDate
                + "]";
    }

}
