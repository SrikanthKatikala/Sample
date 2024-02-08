package com.zettamine.mat.entity;

import jakarta.persistence.CascadeType; 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "isp_act")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@IdClass(InspectionActualKey.class)
@ToString(exclude = {"inspectionLot","matCharId"})
public class InspectionActuals {

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lot_id")
	private InspectionLot inspectionLot;
	@Id
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = MaterialCharacteristics.class)
	@JoinColumn(name="ch_id", referencedColumnName = "ch_id")
	private MaterialCharacteristics matCharId;
	@Column(name = "max_mes", nullable = false)
	private Float maximumMeasurement;
	@Column(name = "min_mes", nullable = false)
	private Float minimumMeasurement;
	
	@Column(name = "active")
	private String active;

	public InspectionActuals(InspectionLot inspectionLot, MaterialCharacteristics matCharId, Float maximumMeasurement,
			Float minimumMeasurement) {
		super();
		this.inspectionLot = inspectionLot;
		this.matCharId = matCharId;
		this.maximumMeasurement = maximumMeasurement;
		this.minimumMeasurement = minimumMeasurement;
	}
	
}


