package com.zettamine.mat.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="mat")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Material {

	@Id
	@Column(name = "mat_id")
	private String materialId;
	@Column(name = "mat_desc")
	private String materialDesc;
	@Column(name ="mat_type")
	private String materialType;
	@Column(name = "active")
	private String active;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "material")
	private List<MaterialCharacteristics> materialCharacteristics;
	@OneToMany(mappedBy = "material")
	private List<InspectionLot> inspectionLots;
	public Material(String materialDesc, String materialType, List<MaterialCharacteristics> materialCharacteristics,
			List<InspectionLot> inspectionLots) {

		this.materialDesc = materialDesc;
		this.materialType = materialType;
		this.materialCharacteristics = materialCharacteristics;
		this.inspectionLots = inspectionLots;
	}
	public Material(String materialId, String materialDesc, String materialType, String active) {
		super();
		this.materialId = materialId;
		this.materialDesc = materialDesc;
		this.materialType = materialType;
		this.active = active;
	}
	public Material(String materialId, String materialDesc, String materialType) {
		super();
		this.materialId = materialId;
		this.materialDesc = materialDesc;
		this.materialType = materialType;
	}
	@Override
	public String toString() {
		return "Material [materialId=" + materialId + ", materialDesc=" + materialDesc + ", materialType="
				+ materialType + ", active=" + active + "]";
	}
	
	
}
