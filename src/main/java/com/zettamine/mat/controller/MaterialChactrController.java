package com.zettamine.mat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zettamine.mat.entity.Material;
import com.zettamine.mat.entity.MaterialCharacteristics;
import com.zettamine.mat.service.MaterialChactrServiceImpl;
import com.zettamine.mat.service.MaterialServiceImpl;

@Controller
@RequestMapping(path = "matChars")
public class MaterialChactrController {

	private MaterialChactrServiceImpl charService;
	private MaterialServiceImpl matService;
	
	public MaterialChactrController(@Autowired MaterialChactrServiceImpl charService, @Autowired MaterialServiceImpl matService) {
		this.charService = charService;
		this.matService = matService;
	}

	@GetMapping(path="/list")
    public String listCharacters(Model model) {
    	List<MaterialCharacteristics> list = charService.getAllMaterialCharacteristics();
    	List<Material> all = matService.getAllMaterial();
    	model.addAttribute("materials",all);
        model.addAttribute("chactrs", list);
        return "mat_char_list";
    }

    @GetMapping(path="/add")
    public String showAddCharactersForm(Model model) {
        model.addAttribute("chactr", new MaterialCharacteristics());
        List<Material> all = matService.getAllMaterial();
    	model.addAttribute("materials",all);
        return "mat_char_save";
    }

    @PostMapping(path="/add")
    public String addCharacters(MaterialCharacteristics chactr,Model model) {
    	//List<MaterialCharacteristics> chactrs = new ArrayList<>();
    	boolean save = charService.saveMaterialCharacteristics(chactr);
    	if (save) {
			model.addAttribute("msg", "Characters Saved Successfully");
		} else {
			model.addAttribute("msg", "Failed to save material");
		}
    	//chactrs.add(chactr);
        return "redirect:/matChars/add";
    }
    
    @GetMapping(path="/update")
    public String updateCharacters(@RequestParam("characterId") Integer id, Model model) {
    	MaterialCharacteristics update = charService.getMaterialCharacteristicsById(id);
    	 model.addAttribute("chactr", update);
    	 List<Material> all = matService.getAllMaterial();
     	model.addAttribute("materials",all);
    	return "mat_char_save";
    }
    
    @GetMapping(path="/delete")
    public String deleteCharacter(@RequestParam("characterId") Integer id) {
    	boolean delete = charService.deleteMaterialCharacteristicsById(id);
    	return "redirect:/matChars/list";
    }

	
}
