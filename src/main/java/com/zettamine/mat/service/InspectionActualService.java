package com.zettamine.mat.service;

import java.util.List;

import com.zettamine.mat.entity.InspectionActualKey;
import com.zettamine.mat.entity.InspectionActuals;


public interface InspectionActualService {

	InspectionActuals getInspectionActualById(InspectionActualKey id);
	List<InspectionActuals> getAllInspectionActuals();
	boolean saveInspectionActual(InspectionActuals inspeActual);
	boolean updateInspectionActual(InspectionActuals inspActual, InspectionActualKey id);
	boolean deleteInspectionActualById(InspectionActualKey id);
	boolean chechInspectionActualExists(InspectionActualKey id);
}
