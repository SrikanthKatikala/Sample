package com.zettamine.mat.service;

import java.util.List;

import com.zettamine.mat.entity.Vendor;

public interface VendorService {

	Vendor getVendorById(Integer id);

	Vendor getVendorByVendorName(String username);

	List<Vendor> getAllVendors();

	boolean saveVendor(Vendor vendor);

	boolean updateVendor(Vendor vendor, Integer id);

	boolean deleteVendorById(Integer id);

	boolean checkVendorExists(Integer id);
}
