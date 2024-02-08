package com.zettamine.mat.service;

import java.util.List;

import com.zettamine.mat.entity.Plant;

public interface PlantService {

	Plant getPlantById(String id);
	Plant getPlantByPlantName(String username);
	List<Plant> getAllPlants();
	boolean savePlant(Plant plant);
	boolean updatePlant(Plant plant, String id);
	boolean deletePlantById(String id);
	boolean chechPlantExists(String id);
}
