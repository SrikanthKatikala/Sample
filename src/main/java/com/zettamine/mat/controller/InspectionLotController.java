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

import com.zettamine.mat.entity.InspectionLot;
import com.zettamine.mat.entity.Material;
import com.zettamine.mat.entity.Plant;
import com.zettamine.mat.entity.User;
import com.zettamine.mat.entity.Vendor;
import com.zettamine.mat.service.InspectionLotServiceImpl;
import com.zettamine.mat.service.MaterialServiceImpl;
import com.zettamine.mat.service.PlantServiceImpl;
import com.zettamine.mat.service.UserServiceImpl;
import com.zettamine.mat.service.VendorServiceimpl;

@Controller
@RequestMapping(path="lots")
public class InspectionLotController {

	private InspectionLotServiceImpl lotService; 	
	private MaterialServiceImpl matService;
	private VendorServiceimpl vendorService;
	private PlantServiceImpl plantService;
	private UserServiceImpl userService;
	
	public InspectionLotController(@Autowired InspectionLotServiceImpl lotService,@Autowired MaterialServiceImpl matService,
			@Autowired VendorServiceimpl vendorService,@Autowired PlantServiceImpl plantService, @Autowired UserServiceImpl userService) {
		this.lotService = lotService;
		this.matService = matService;
		this.vendorService = vendorService;
		this.plantService = plantService;
		this.userService = userService;
	}
	
	@GetMapping(path="/list")
    public String listOfInspectionLots(Model model) {
    	List<InspectionLot> lots = lotService.getAllInspectionlot();
        model.addAttribute("lots", lots);
        return "isp_lot_list";
    }

    @GetMapping(path="/add")
    public String showAddInspectionLotForm(Model model) {
    	model.addAttribute("lot",new InspectionLot());
        List<Material> materials = matService.getAllMaterial();
        List<Vendor> vendors = vendorService.getAllVendors();
        List<Plant> plants = plantService.getAllPlants();
        List<User> users = new ArrayList<>();
        users.add(userService.getUser());
    	model.addAttribute("materials",materials);
    	model.addAttribute("vendors", vendors);
    	model.addAttribute("plants", plants);
    	model.addAttribute("users", users);
        return "isp_lot_save";
    }

    @PostMapping(path="/add")
    public String addInspectionLot(InspectionLot ispLot,Model model,String vendor) {
    	boolean save = lotService.saveInspectionLot(ispLot);
    	if (save) {
			model.addAttribute("msg", "Inspection lot Saved Successfully");
		} else {
			model.addAttribute("msg", "Failed to save inspection lot");
		}
        return "redirect:/lots/add";
    }
    
    @GetMapping(path="/update")
    public String updateInspectionLot(@RequestParam("lotId") Integer id, Model model) {
    	InspectionLot lots = lotService.getInspectionLotById(id);
    	model.addAttribute("lot",lots);
    	Material material = matService.getMaterialById(lots.getMaterial().getMaterialId());
        List<Material> materials = new ArrayList<>();
        materials.add(material);
    	Vendor vendor = vendorService.getVendorById(lots.getVendor().getVendorId());
        List<Vendor> vendors = new ArrayList<>();
        vendors.add(vendor);
        Plant plant = plantService.getPlantById(lots.getPlant().getPlantId());
        List<Plant> plants = new ArrayList<>();
        plants.add(plant);
        User user = userService.getUserById(lots.getUser().getUserId());
        List<User> users = new ArrayList<>();
        users.add(user);
    	model.addAttribute("materials",materials);
    	model.addAttribute("vendors", vendors);
    	model.addAttribute("plants", plants);
    	model.addAttribute("users", users);
    	model.addAttribute("createdOn", lots.getCreatedOn());
    	model.addAttribute("ispStartDate", lots.getIspStartDate());
    	model.addAttribute("ispEndDate", lots.getIspEndDate());
    	return "isp_lot_save";
    }
    
    @GetMapping(path="/delete")
    public String deleteCharacter(@RequestParam("lotId") Integer id) {
    	boolean delete = lotService.deleteInspectionLotById(id);
    	return "redirect:/lots/list";
    }
    
    @GetMapping(path="/search")
    public String searchData() {
    	return "isp_lot_search";
    }
}
