package com.dmhere.plantcareplanner.repositories;

import com.dmhere.plantcareplanner.models.PlantTask;
import com.dmhere.plantcareplanner.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlantTaskRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<PlantTask> findAll() {
        String sql = "SELECT * FROM plant_task";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PlantTask.class));
    }
    public int save(PlantTask plantTask) {
        String sql = "INSERT INTO plant_task (plant_id, task_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, plantTask.getPlant_id(), plantTask.getTask_id());
    }
    public int saveByPlantAndTask(int plantId, int taskId) {
        String sql = "INSERT INTO plant_task (plant_id, task_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, plantId, taskId);
    }
    public int update(PlantTask plantTask) {
        String sql = "UPDATE plant_task SET plant_id = ?, task_id = ? WHERE id = ?";
        return jdbcTemplate.update(sql, plantTask.getPlant_id(), plantTask.getTask_id(), plantTask.getId());
    }
    public int deleteById(int id) {
        String sql = "DELETE FROM plant_task WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public List<Task> findByPlantTasks_PlantId(int id) {
        String sql = "SELECT t.id, t.name, t.description, t.is_recurring, t.due_date " +
                "FROM task AS t " +
                "INNER JOIN plant_task AS pt ON pt.task_id = t.id " +
                "WHERE plant_id = ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Task.class), id);
    }
}
