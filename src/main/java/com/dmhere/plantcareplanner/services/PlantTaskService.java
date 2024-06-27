package com.dmhere.plantcareplanner.services;

import com.dmhere.plantcareplanner.dto.PlantTaskDTO;
import com.dmhere.plantcareplanner.models.PlantTask;
import com.dmhere.plantcareplanner.models.Task;
import com.dmhere.plantcareplanner.repositories.PlantTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PlantTaskService {

    Logger log = Logger.getLogger(PlantTaskService.class.getName());

    @Autowired
    PlantTaskRepository plantTaskRepository;

    @Transactional
    public void addTaskToPlant(PlantTaskDTO plantTaskDTO) {
        PlantTask plantTask = new PlantTask();
        plantTask.setPlant_id(plantTaskDTO.getPlantID());
        plantTask.setTask_id(plantTaskDTO.getTaskID());
        log.info("Adding task " + plantTaskDTO.getTaskID() + " to plant: " + plantTaskDTO.getPlantID());
        plantTaskRepository.saveByPlantAndTask(plantTask.getPlant_id(), plantTask.getTask_id());
    }

    public List<Task> getTasksByPlantId(int id) {
        return plantTaskRepository.findByPlantTasks_PlantId(id);
    }
}
