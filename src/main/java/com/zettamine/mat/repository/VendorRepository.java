package com.zettamine.mat.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zettamine.mat.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Serializable> {

	@Query("from com.zettamine.mat.entity.Vendor where active='active'")
	List<Vendor> findAllVendors();
}
