package com.zettamine.mat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zettamine.mat.entity.Vendor;
import com.zettamine.mat.repository.VendorRepository;

@Service
public class VendorServiceimpl implements VendorService {

	private VendorRepository repository;
	
	public VendorServiceimpl(VendorRepository repository) {
		this.repository = repository;
	}

	@Override
	public Vendor getVendorById(Integer id) {
		Optional<Vendor> byId = repository.findById(id);
		if (byId.isPresent()) {
			Vendor vendor = byId.get();
			return vendor;
		}
		return null;
	}

	@Override
	public Vendor getVendorByVendorName(String username) {
		return null;
	}

	@Override
	public List<Vendor> getAllVendors() {
		List<Vendor> all = repository.findAllVendors();
		return all;
	}

	@Override
	public boolean saveVendor(Vendor vendor) {
		Vendor save = repository.save(vendor);
		if (save!=null) {
			return true;
		} 
		return false;
	}

	@Override
	public boolean updateVendor(Vendor vendor, Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteVendorById(Integer id) {
		try {
			Optional<Vendor> contact = repository.findById(id);
			if(contact.isPresent()) {
				Vendor vendor = contact.get();
				vendor.setActive("inactive");
				repository.save(vendor);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return false;
	}

	@Override
	public boolean checkVendorExists(Integer id) {
		boolean status = repository.existsById(id);		
		return status;
	}

}
