package com.zettamine.mat.service;

import java.util.List;

import com.zettamine.mat.entity.Material;


public interface MaterialService {

	Material getMaterialById(String id);
	List<Material> getAllMaterial();
	boolean saveMaterial(Material mat);
	boolean updateMaterial(Material mat, String id);
	boolean deleteMaterialById(String id);
	boolean chechMaterialExists(String id);
}
