package com.zettamine.mat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zettamine.mat.entity.Plant;
import com.zettamine.mat.entity.Vendor;
import com.zettamine.mat.service.PlantServiceImpl;

@Controller
@RequestMapping(path="/plants")
public class PlantController {

	private PlantServiceImpl plantService;
	
	public PlantController(PlantServiceImpl plantService) {
		this.plantService = plantService;
	}

	@GetMapping(path="/list")
    public String listPlants(Model model) {
    	List<Plant> plants = plantService.getAllPlants();
        model.addAttribute("plants", plants);
        return "plant_list";
    }

    @GetMapping(path="/add")
    public String showAddPlantForm(Model model) {
        model.addAttribute("plant", new Plant());
        return "plant_save";
    }

    @PostMapping(path="/add")
    public String addPlant(Plant plant,Model model) {
    	List<Plant> plants = new ArrayList<>();
    	boolean savePlant = plantService.savePlant(plant);
    	if (savePlant) {
			model.addAttribute("msg", "Contact Saved Successfully");
		} else {
			model.addAttribute("msg", "Failed to save contact");
		}
        plants.add(plant);
        return "redirect:/plants/add";
    }
    
    @GetMapping(path="/update")
    public String updatePlant(@RequestParam("plantId") String id, Model model) {
    	Plant plantById = plantService.getPlantById(id);
    	 model.addAttribute("plant", plantById);
    	return "plant_save";
    }
    
    @GetMapping(path="/delete")
    public String deletePlant(@RequestParam("plantId") String id) {
    	boolean delete = plantService.deletePlantById(id);
    	return "redirect:/plants/list";
    }
	
}
