package com.zettamine.mat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zettamine.mat.entity.Material;
import com.zettamine.mat.repository.MaterialRepository;
@Service
public class MaterialServiceImpl implements MaterialService {

	private MaterialRepository materialRepo;
	
	public MaterialServiceImpl(MaterialRepository materialRepo) {
		this.materialRepo = materialRepo;
	}

	@Override
	public Material getMaterialById(String id) {
		Optional<Material> materialById = materialRepo.findById(id);
		if (materialById.isPresent()) {
			Material material = materialById.get();
			return material;
		}
		return null;
	}

	@Override
	public List<Material> getAllMaterial() {
		List<Material> allMaterial = materialRepo.findAllMaterial();
		return allMaterial;
	}

	@Override
	public boolean saveMaterial(Material mat) {
		Material save = materialRepo.save(mat);
		if (save!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateMaterial(Material mat, String id) {
		
		return false;
	}

	@Override
	public boolean deleteMaterialById(String id) {
		try {
			Optional<Material> opMaterial = materialRepo.findById(id);
			if(opMaterial.isPresent()) {
				Material material = opMaterial.get();
				material.setActive("inactive");
				materialRepo.save(material);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return false;
	}

	@Override
	public boolean chechMaterialExists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
