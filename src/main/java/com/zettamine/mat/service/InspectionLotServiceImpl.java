package com.zettamine.mat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zettamine.mat.entity.InspectionLot;
import com.zettamine.mat.repository.InspectionLotRepository;

@Service
public class InspectionLotServiceImpl implements InspectionLotService {

	private InspectionLotRepository lotRepo;
	public InspectionLotServiceImpl(InspectionLotRepository lotRepo) {
		this.lotRepo = lotRepo;
	}

	@Override
	public InspectionLot getInspectionLotById(Integer id) {
		Optional<InspectionLot> optInspectionLot = lotRepo.findByLotIdAndActive(id,"active");
		if (optInspectionLot.isPresent()) {
			InspectionLot inspectionLot = optInspectionLot.get();
			
			System.out.println("inside inspect lot service getInspectionLotById");
			return inspectionLot;
			
		}
		System.out.println("inside inspect lot service getInspectionLotById##@@");
		return null;
	}

	@Override
	public List<InspectionLot> getAllInspectionlot() {
		List<InspectionLot> activeLots = lotRepo.findAllByActive("active");
		
		return activeLots;
	}

	@Override
	public boolean saveInspectionLot(InspectionLot inspeLot) {
		InspectionLot save = lotRepo.save(inspeLot);
		if (save!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateInspectionLot(InspectionLot inspLot, Integer id) {
		return false;
	}

	@Override
	public boolean deleteInspectionLotById(Integer id) {
		try {
			Optional<InspectionLot> optional = lotRepo.findById(id);
			if(optional.isPresent()) {
				InspectionLot inspectionLot = optional.get();
				inspectionLot.setActive("inactive");
				lotRepo.save(inspectionLot);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return false;
	}

	@Override
	public boolean chechInspectionLotExists(Integer id) {
		return false;
	}

}
