package com.zettamine.mat.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zettamine.mat.entity.Plant;

public interface PlantRepository extends JpaRepository<Plant, Serializable> {

	@Query("from com.zettamine.mat.entity.Plant where active = 'active'")
	List<Plant> findAllPlants();
	
	Optional<Plant> findByPlantIdAndActive(String plantId, String active);
}
