package com.dmhere.plantcareplanner.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantTask {

    private int id;
    private int plant_id;
    private int task_id;

}
