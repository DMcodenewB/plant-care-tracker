package com.dmhere.plantcareplanner.repositories;

import com.dmhere.plantcareplanner.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Task> getAllTasks() {
        return jdbcTemplate.query("select id, name, description, is_recurring, due_date from task",
                BeanPropertyRowMapper.newInstance(Task.class));
    }

    public Task getTaskById(int id) {
        return jdbcTemplate.queryForObject("select id, name, description, is_recurring, due_date from task " +
                "where id = ?", BeanPropertyRowMapper.newInstance(Task.class), id);
    }

    public int addTask(Task task) {
        return jdbcTemplate.update("insert into task(name, description, is_recurring, due_date) values (?, ?, ?, ?)",
                task.getName(), task.getDescription(), task.isRecurring(), task.getDueDate());
    }

    public int updateTask(Task task) {
        return jdbcTemplate.update("update task set name=?, description=?, is_recurring=?, due_date=? where id=?",
                task.getName(), task.getDescription(), task.isRecurring(), task.getDueDate(), task.getId());
    }

    public int deleteTask(int id) {
        return jdbcTemplate.update("delete from task where id = ?", id);
    }

}
