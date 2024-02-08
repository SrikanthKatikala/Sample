package com.zettamine.mat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zettamine.mat.entity.InspectionActualKey;
import com.zettamine.mat.entity.InspectionActuals;
import com.zettamine.mat.entity.InspectionLot;
import com.zettamine.mat.entity.MaterialCharacteristics;
import com.zettamine.mat.entity.Vendor;
import com.zettamine.mat.repository.InspectionActualsRepository;
@Service
public class InspectionActualServiceImpl implements InspectionActualService {

	private InspectionActualsRepository actualsRepo;
	private InspectionActualKey actualKey;

	public InspectionActualServiceImpl(InspectionActualsRepository actualsRepo) {
		this.actualsRepo = actualsRepo;
	}

	@Override
	public InspectionActuals getInspectionActualById(InspectionActualKey id) {
		
		Optional<InspectionActuals> optInsp = actualsRepo.findById(actualKey);
		if (optInsp.isPresent()) {
			InspectionActuals actual = optInsp.get();
			return actual;
		}
		return null;
	}

	@Override
	public List<InspectionActuals> getAllInspectionActuals() {
		List<InspectionActuals> actuals = actualsRepo.findAllInspectionActuals();
		return actuals;
	}

	@Override
	public boolean saveInspectionActual(InspectionActuals inspeActual) {
		InspectionActuals saveActual = actualsRepo.save(inspeActual);
		if (saveActual!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateInspectionActual(InspectionActuals inspActual, InspectionActualKey id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteInspectionActualById(InspectionActualKey id) {
		try {
			Optional<InspectionActuals> optional = actualsRepo.findById(id);
			if(optional.isPresent()) {
				InspectionActuals inspectionActual = optional.get();
				inspectionActual.setActive("inactive");
				actualsRepo.save(inspectionActual);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return false;
	}

	@Override
	public boolean chechInspectionActualExists(InspectionActualKey id) {
		// TODO Auto-generated method stub
		return false;
	}

	public InspectionActuals getInspectionActualsByLotAndChar(InspectionLot lot, MaterialCharacteristics characters) {
		
		Optional<InspectionActuals> opt	= actualsRepo.findByInspectionLotAndMatCharId(lot, characters);
	
	  return opt.isPresent()?opt.get():null;
	}

}
