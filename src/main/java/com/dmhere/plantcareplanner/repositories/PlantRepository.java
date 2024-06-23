package com.dmhere.plantcareplanner.repositories;

import com.dmhere.plantcareplanner.models.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class PlantRepository {

    Logger logger = Logger.getLogger(PlantRepository.class.getName());

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Plant> getAllPlants() {
        return jdbcTemplate.query("select id, name, plant_date, description from plant",
                BeanPropertyRowMapper.newInstance(Plant.class));
    }

    public Plant getPlantById(int id) {
        Plant result = jdbcTemplate.queryForObject("select id, name, plant_date, description from plant where id=?",
                BeanPropertyRowMapper.newInstance(Plant.class), id);
        if (result != null) {
            logger.log(Level.INFO, result.toString());
        } else {
            logger.log(Level.WARNING, "null result?");
        }
        return result;
    }

    public int addPlant(List<Plant> newPlants) {
        newPlants.forEach(newPlant -> jdbcTemplate.update("insert into plant (name, plant_date, description) values (?, ?, ?)",
                newPlant.getName(), newPlant.getPlantDate(), newPlant.getDescription()));
        return 1;
    }

    public int updatePlant(Plant updatedPlant) {
        return jdbcTemplate.update("update plant set name=?, plant_date=?, description=? where id=?",
                updatedPlant.getName(), updatedPlant.getPlantDate(), updatedPlant.getDescription(), updatedPlant.getId());
    }

    public int deletePlant(int id) {
        return jdbcTemplate.update("delete from plant where id=?", id);
    }

}
