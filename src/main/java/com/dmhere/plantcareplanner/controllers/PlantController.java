package com.dmhere.plantcareplanner.controllers;

import com.dmhere.plantcareplanner.models.Plant;
import com.dmhere.plantcareplanner.models.Task;
import com.dmhere.plantcareplanner.repositories.PlantRepository;
import com.dmhere.plantcareplanner.services.PlantTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plants")
@CrossOrigin("http://localhost:5173/")
public class PlantController {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    PlantTaskService plantTaskService;

    @GetMapping("/")
    public List<Plant> getPlants() {
        return plantRepository.getAllPlants();
    }

    @GetMapping("/{id}")
    public Plant getPlant(@PathVariable int id) {
        return plantRepository.getPlantById(id);
    }

    @GetMapping("/name")
    public Plant getPlantByName(@RequestParam String name) {
        return plantRepository.getPlantByName(name);
    }

    @GetMapping("/{id}/tasks")
    public List<Task> getTasksForPlant(@PathVariable int id) {
        return plantTaskService.getTasksByPlantId(id);
    }

    @PostMapping("/")
    public int addPlant(@RequestBody List<Plant> plants) {
        return plantRepository.addPlant(plants);
    }

    @PutMapping("/{id}")
    public int updatePlant(@PathVariable int id, @RequestBody Plant plant) {
        Plant plantToUpdate = plantRepository.getPlantById(id);

        if (plantToUpdate != null) {
            plantToUpdate.setName(plant.getName());
            plantToUpdate.setDescription(plant.getDescription());
            plantToUpdate.setPlantDate(plant.getPlantDate());
            return plantRepository.updatePlant(plantToUpdate);
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdatePlant(@PathVariable int id, @RequestBody Plant plant) {
        Plant plantToUpdate = plantRepository.getPlantById(id);

        if (plantToUpdate != null) {
            if (plant.getName() != null){
                plantToUpdate.setName(plant.getName());
            }
            if (plant.getDescription() != null){
                plantToUpdate.setDescription(plant.getDescription());
            }
            if (plant.getPlantDate() != null){
                plantToUpdate.setPlantDate(plant.getPlantDate());
            }
            return plantRepository.updatePlant(plantToUpdate);
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int deletePlant(@PathVariable int id) {
        return plantRepository.deletePlant(id);
    }
}
