package com.zettamine.mat.service;

import java.util.List;

import com.zettamine.mat.entity.MaterialCharacteristics;

public interface MaterialChactrService {

	MaterialCharacteristics getMaterialCharacteristicsById(Integer id);

	List<MaterialCharacteristics> getAllMaterialCharacteristics();

	boolean saveMaterialCharacteristics(MaterialCharacteristics chrct);

	boolean updateMaterialCharacteristics(MaterialCharacteristics chrct, Integer id);

	boolean deleteMaterialCharacteristicsById(Integer id);

	boolean checkMaterialCharacteristicsExists(Integer id);
}
