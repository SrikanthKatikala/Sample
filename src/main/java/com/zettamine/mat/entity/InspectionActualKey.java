package com.zettamine.mat.entity;

import java.io.Serializable;  
import java.util.Objects;

public class InspectionActualKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InspectionLot inspectionLot;
	
	private MaterialCharacteristics matCharId;

	
	

	public InspectionActualKey() {
	}

	public InspectionActualKey(InspectionLot inspectionLot, MaterialCharacteristics matCharId) {
		this.inspectionLot = inspectionLot;
		this.matCharId = matCharId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(inspectionLot, matCharId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InspectionActualKey other = (InspectionActualKey) obj;
		return Objects.equals(inspectionLot, other.inspectionLot) && Objects.equals(matCharId, other.matCharId);
	}

	
	
	
	
}
