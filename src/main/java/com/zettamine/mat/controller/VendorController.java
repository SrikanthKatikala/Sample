package com.zettamine.mat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zettamine.mat.entity.Vendor;
import com.zettamine.mat.service.VendorServiceimpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping(path = "/vendors")
public class VendorController {

	private VendorServiceimpl vendorService;
	public VendorController(VendorServiceimpl vendorService) {
		this.vendorService = vendorService;
	}

    @GetMapping("/list")
    public String listVendors(Model model) {
    	List<Vendor> vendors = vendorService.getAllVendors();
        model.addAttribute("vendors", vendors);
        return "vendor_list";
    }

    @GetMapping("/add")
    public String showAddVendorForm(Model model) {
        model.addAttribute("vendor", new Vendor());
        return "vendor_save";
    }

    @PostMapping("/add")
    public String addVendor(@Valid Vendor vendor,BindingResult bindingErrors,Model model) {
    	List<Vendor> vendors = new ArrayList<>();
    	
    	if(bindingErrors.hasErrors())
    	{
    		return "vendor_save";
    	}
    	
    	boolean saveVendor = vendorService.saveVendor(vendor);
    	if (saveVendor) {
			model.addAttribute("msg", "Vendor Saved Successfully");
		} else {
			model.addAttribute("msg", "Failed to save contact");
		}
        vendors.add(vendor);
        return "redirect:/vendors/add";
    }
    
    @GetMapping("/update")
    public String updateVendor(@RequestParam("vendorId") Integer id, Model model) {
    	Vendor vendorById = vendorService.getVendorById(id);
    	 model.addAttribute("vendor", vendorById);
    	return "vendor_save";
    }
    
    @GetMapping("/delete")
    public String deleteVendor(@RequestParam("vendorId") Integer id) {
    	boolean delete = vendorService.deleteVendorById(id);
    	return "redirect:/vendors/list";
    }
    
}
