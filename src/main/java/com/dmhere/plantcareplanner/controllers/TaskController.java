package com.dmhere.plantcareplanner.controllers;


import com.dmhere.plantcareplanner.models.Task;
import com.dmhere.plantcareplanner.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    Logger log = Logger.getLogger(TaskController.class.getName());

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskRepository.getTaskById(id);
    }

    @PostMapping("/")
    public int addTask(@RequestBody Task task) {
        return taskRepository.addTask(task);
    }

    @PutMapping("/{id}")
    public int updateTask(@PathVariable int id, @RequestBody Task task) {
        Task taskToUpdate = taskRepository.getTaskById(id);

        if (taskToUpdate != null) {
            taskToUpdate.setName(task.getName());
            taskToUpdate.setDescription(task.getDescription());
            taskToUpdate.setIsRecurring(task.getIsRecurring());
            taskToUpdate.setDueDate(task.getDueDate());
            return taskRepository.updateTask(taskToUpdate);
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdateTask(@PathVariable int id, @RequestBody Task task) {
        Task taskToUpdate = taskRepository.getTaskById(id);
        log.info(task.toString());

        if (taskToUpdate != null) {
            if(task.getName() != null){
                taskToUpdate.setName(task.getName());
            }
            if(task.getDescription() != null){
                taskToUpdate.setDescription(task.getDescription());
            }
            if(task.getIsRecurring()){
                taskToUpdate.setIsRecurring(true);
            }
            if(task.getDueDate() != null){
                taskToUpdate.setDueDate(task.getDueDate());
            }
            return taskRepository.updateTask(taskToUpdate);
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int deleteTask(@PathVariable int id) {
        return taskRepository.deleteTask(id);
    }

}
