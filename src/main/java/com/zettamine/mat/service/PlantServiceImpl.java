package com.zettamine.mat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zettamine.mat.entity.Plant;
import com.zettamine.mat.repository.PlantRepository;
@Service
public class PlantServiceImpl implements PlantService {

	private PlantRepository plantRepository;
	
	public PlantServiceImpl(PlantRepository plantRepository) {
		this.plantRepository = plantRepository;
	}

	@Override
	public Plant getPlantById(String id) {
		 Optional<Plant> plantById = plantRepository.findByPlantIdAndActive(id, "active");
		 if (plantById.isPresent()) {
			return plantById.get();
		}
		return null;
	}

	@Override
	public Plant getPlantByPlantName(String username) {

		return null;
	}

	@Override
	public List<Plant> getAllPlants() {
		List<Plant> allPlants = plantRepository.findAllPlants();
		return allPlants;
	}

	@Override
	public boolean savePlant(Plant plant) {
		Plant save = plantRepository.save(plant);
		if (save!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePlant(Plant plant, String id) {
		
		return false;
	}

	@Override
	public boolean deletePlantById(String id) {
		try {
			Optional<Plant> opPlant = plantRepository.findByPlantIdAndActive(id, "active");
			if(opPlant.isPresent()) {
				Plant plant = opPlant.get();
				plant.setActive("inactive");
				plantRepository.save(plant);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return false;
	}

	@Override
	public boolean chechPlantExists(String id) {

		return false;
	}

}
