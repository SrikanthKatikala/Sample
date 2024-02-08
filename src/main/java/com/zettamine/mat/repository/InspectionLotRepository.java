package com.zettamine.mat.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zettamine.mat.entity.InspectionLot;


public interface InspectionLotRepository extends JpaRepository<InspectionLot, Serializable> {

	List<InspectionLot> findAllByActive(String active);
	
	//@Query("from com.zettamine.mat.entity.InspectionLot where active = 'active' and lotId=:lId")
	//Optional<InspectionLot> findByLotIdAndActive(Integer lId);
	
	Optional<InspectionLot> findByLotIdAndActive(Integer lotId, String active);
	
	List<InspectionLot> findAllByCreatedOnBetweenAndActive(LocalDate createdOn,LocalDate todate, String active);
//	@Query("from com.zettamine.mat.entity.InspectionLot where between ispStartDate")
//	findAllByIspStartDateBetweenIspEndDate();
	
	
}
