package com.zettamine.mat.repository;

import java.util.List; 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zettamine.mat.entity.InspectionActualKey;
import com.zettamine.mat.entity.InspectionActuals;
import com.zettamine.mat.entity.InspectionLot;
import com.zettamine.mat.entity.MaterialCharacteristics;


public interface InspectionActualsRepository extends JpaRepository<InspectionActuals, InspectionActualKey> {

	@Query("from com.zettamine.mat.entity.InspectionActuals where active='active'")
	List<InspectionActuals> findAllInspectionActuals();
	
//	@Query("from com.zettamine.mat.entity.InspectionActuals  where inspectionId=:iLId and active='active'")
//	Optional<InspectionActuals> findByInspectionId(Integer iLId);
	Optional<InspectionActuals> findByInspectionLotAndMatCharId(InspectionLot inspectionLot, MaterialCharacteristics matCharId);
}
