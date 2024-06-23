package com.dmhere.plantcareplanner.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plant {

    private int id;
    private String name;
    private String description;
    private Timestamp plantDate;

    public String toString(){
        return "ID: " + id + "\tName: " + name + "\tDescription: " + description + "\tDate: " + plantDate;
    }
}
