package com.zettamine.mat.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "plnt")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Plant {
	@Id
	@Column(name = "plnt_id")
	private String plantId;
	@Column(name = "plnt_name")
	private String plantName;
	@Column(name = "plnt_loc")
	private String plantLoc;
	@Column(name = "active")
	private String active;
	@OneToMany(mappedBy = "plant")
	private List<InspectionLot> inspectionLots;
	public Plant(String plantId, String plantName, String plantLoc, String active) {
		this(plantId,plantName,plantLoc);
		this.active = active;
	}
	public Plant(String plantId, String plantName, String plantLoc) {
		this.plantId = plantId;
		this.plantName = plantName;
		this.plantLoc = plantLoc;
	}
	
	
}
