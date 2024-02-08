package com.zettamine.mat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zettamine.mat.entity.Material;
import com.zettamine.mat.service.MaterialServiceImpl;


@Controller
@RequestMapping(path="materials")
public class MaterialController {

	private MaterialServiceImpl matService;
	
	public MaterialController(MaterialServiceImpl matService) {
		this.matService = matService;
	}

	@GetMapping(path="/list")
    public String listMaterials(Model model) {
    	List<Material> materials = matService.getAllMaterial();
        model.addAttribute("materials", materials);
        return "material_list";
    }

    @GetMapping(path="/add")
    public String showAddMaterialForm(Model model) {
        model.addAttribute("material", new Material());
        return "material_save";
    }

    @PostMapping(path="/add")
    public String addMaterial(Material material,Model model) {
    	List<Material> materials = new ArrayList<>();
    	boolean saveMaterial = matService.saveMaterial(material);
    	if (saveMaterial) {
			model.addAttribute("msg", "Material Saved Successfully");
		} else {
			model.addAttribute("msg", "Failed to save material");
		}
        materials.add(material);
        return "redirect:/materials/add";
    }
    
    @GetMapping(path="/update")
    public String updateMaterial(@RequestParam("materialId") String id, Model model) {
    	Material materialById = matService.getMaterialById(id);
    	 model.addAttribute("material", materialById);
    	return "material_save";
    }
    
    @GetMapping(path="/delete")
    public String deleteMaterial(@RequestParam("materialId") String id) {
    	boolean delete = matService.deleteMaterialById(id);
    	return "redirect:/materials/list";
    }
}
