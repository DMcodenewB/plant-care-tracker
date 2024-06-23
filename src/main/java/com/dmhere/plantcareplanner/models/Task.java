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
    private boolean isRecurring;
    private Timestamp dueDate;

}
