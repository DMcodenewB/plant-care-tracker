package com.dmhere.plantcareplanner.controllers;

import com.dmhere.plantcareplanner.dto.PlantTaskDTO;
import com.dmhere.plantcareplanner.services.PlantTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/planttasks")
@CrossOrigin("http://localhost:5173/")
public class PlantTaskController {

    @Autowired
    PlantTaskService plantTaskService;

    @PostMapping
    public ResponseEntity<Void> addPlantTask(@RequestBody PlantTaskDTO plantTaskDTO) {
        plantTaskService.addTaskToPlant(plantTaskDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
