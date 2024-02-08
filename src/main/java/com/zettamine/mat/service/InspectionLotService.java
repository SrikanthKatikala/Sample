package com.zettamine.mat.service;

import java.util.List;

import com.zettamine.mat.entity.InspectionLot;


public interface InspectionLotService {

	InspectionLot getInspectionLotById(Integer id);
	List<InspectionLot> getAllInspectionlot();
	boolean saveInspectionLot(InspectionLot inspeLot);
	boolean updateInspectionLot(InspectionLot inspLot, Integer id);
	boolean deleteInspectionLotById(Integer id);
	boolean chechInspectionLotExists(Integer id);
}
