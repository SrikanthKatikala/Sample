package com.zettamine.mat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zettamine.mat.entity.Material;
import com.zettamine.mat.entity.MaterialCharacteristics;
import com.zettamine.mat.repository.MaterialChactrRepository;
@Service
public class MaterialChactrServiceImpl implements MaterialChactrService {

	private MaterialChactrRepository chactrRepo;
	
	public MaterialChactrServiceImpl(MaterialChactrRepository chactrRepo) {
		this.chactrRepo = chactrRepo;
	}

	@Override
	public MaterialCharacteristics getMaterialCharacteristicsById(Integer id) {
		Optional<MaterialCharacteristics> byId = chactrRepo.findById(id);
		if (byId.isPresent()) {
			MaterialCharacteristics characteristics = byId.get();
			return characteristics;
		}
		return null;
	}

	@Override
	public List<MaterialCharacteristics> getAllMaterialCharacteristics() {
		List<MaterialCharacteristics> chars = chactrRepo.findAllMaterialChars();
		return chars;
	}

	@Override
	public boolean saveMaterialCharacteristics(MaterialCharacteristics chrct) {
		MaterialCharacteristics save = chactrRepo.save(chrct);
		if (save!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateMaterialCharacteristics(MaterialCharacteristics chrct, Integer id) {
		
		return false;
	}

	@Override
	public boolean deleteMaterialCharacteristicsById(Integer id) {
		try {
			Optional<MaterialCharacteristics> char1 = chactrRepo.findById(id);
			if(char1.isPresent()) {
				MaterialCharacteristics character = char1.get();
				character.setActive("inactive");
				chactrRepo.save(character);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return false;
	}

	@Override
	public boolean checkMaterialCharacteristicsExists(Integer id) {

		return false;
	}

}
