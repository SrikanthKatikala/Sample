package com.zettamine.mat.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zettamine.mat.entity.InspectionActualKey;
import com.zettamine.mat.entity.InspectionActuals;
import com.zettamine.mat.entity.InspectionLot;
import com.zettamine.mat.entity.MaterialCharacteristics;
import com.zettamine.mat.service.InspectionActualServiceImpl;
import com.zettamine.mat.service.InspectionLotServiceImpl;
import com.zettamine.mat.service.MaterialChactrServiceImpl;


@Controller
@RequestMapping(path="/actuals")
public class InspectionActualController {

	private InspectionLotServiceImpl lotService;
	private InspectionActualServiceImpl actualService;
	private MaterialChactrServiceImpl charService;
	private InspectionActualKey actualKey;

	public InspectionActualController(InspectionLotServiceImpl lotService, InspectionActualServiceImpl actualService,
			MaterialChactrServiceImpl charService) {
		this.lotService = lotService;
		this.actualService = actualService;
		this.charService = charService;
	}

	@GetMapping(path="/list")
    public String listInspectionActuals(Model model) {
    	List<InspectionActuals> actuals = actualService.getAllInspectionActuals();
    	List<MaterialCharacteristics> matChars = charService.getAllMaterialCharacteristics();
    	List<InspectionLot> lots = lotService.getAllInspectionlot();
    	model.addAttribute("matChars",matChars);
        model.addAttribute("actuals", actuals);
        model.addAttribute("inspectionlot", lots);
        return "isp_act_list";
    }

    @GetMapping(path="/add")
    public String showAddActualsForm(Model model) {
        model.addAttribute("inspectionActuals", new InspectionActuals());
        List<InspectionLot> inspectionlots = lotService.getAllInspectionlot();
        model.addAttribute("lots", inspectionlots);
        List<MaterialCharacteristics> materialCharacters = charService.getAllMaterialCharacteristics();
    	model.addAttribute("matChars",materialCharacters);
        return "isp_act_save";
    }

    @PostMapping(path="/add")
    public String addActual(InspectionActuals inspectionActuals,Model model) {
    	boolean saveInspectionActual = actualService.saveInspectionActual(inspectionActuals);
    	if (saveInspectionActual) {
			model.addAttribute("msg", "Inspection Actuals Saved Successfully");
		} else {
			model.addAttribute("msg", "Failed to save Inspection Actual");
		}
        return "redirect:/actuals/add";
    }
    
    @GetMapping(path="/update")
//    public String updateEntity(@RequestParam("inspectionLot") InspectionLot lot,@RequestParam ("matCharId") MaterialCharacteristics characters,Model model) {
    public String updateEntity(@RequestParam("inspectionLot") Integer lot,@RequestParam ("matCharId") Integer characters,Model model) {
//    	
    	
    	//actualKey =new InspectionActualKey(lot, characters);
    	
    	System.out.println(lot+"  ### "+characters);
    	InspectionLot lotById = lotService.getInspectionLotById(lot);
    	MaterialCharacteristics charById = charService.getMaterialCharacteristicsById(characters);
    	//actualKey = new InspectionActualKey(lotById, charById);
    	
    	InspectionActuals actualById = actualService.getInspectionActualsByLotAndChar(lotById,charById);
    	if (actualById!=null) {
			model.addAttribute("inspectionActuals", actualById);
			return "isp_act_save";
		}
    	return "redirect:/actuals/list";
    }
    
    @GetMapping(path="/delete")
    public String deleteCharacter(@RequestParam("inspectionLot") Integer lot,@RequestParam ("matCharId") Integer characters) {
//    	actualKey =new InspectionActualKey(lot, characters);
    	InspectionActuals actualById = actualService.getInspectionActualById(actualKey);
    	if (actualById!=null) {
			actualService.deleteInspectionActualById(actualKey);
			return "redirect:/actuals/list";
		}
    	return "redirect:/actuals/list";
    }

	
}
