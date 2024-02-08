package com.zettamine.mat.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zettamine.mat.entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Serializable> {

	@Query("from com.zettamine.mat.entity.Material where active = 'active'")
	List<Material> findAllMaterial();
	
	@Query("from com.zettamine.mat.entity.Material where active = 'active'")
	Optional<Material> findMaterialById(String plantId);
}
