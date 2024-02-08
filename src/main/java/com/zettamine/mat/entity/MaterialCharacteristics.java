package com.zettamine.mat.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "mat_isp_ch")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class MaterialCharacteristics implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ch_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "characterId")
	@SequenceGenerator(sequenceName = "characterId",name = "character_seq",initialValue = 3001,allocationSize = 1)
	private Integer characterId;
	@Column(name = "ch_desc")
	private String characterDesc;
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Material.class)
	@JoinColumn(name = "mat_id")
	private Material material;
	@Column(name="tol_ll")
	private Float toleranceLowerLimit;
	@Column(name = "tol_ul")
	private Float toleranceUpperLimit;
	@Column(name = "uom")
	private String unitOfMeasurement;
	
	@Column(name = "active")
	private String active;
	@OneToMany(mappedBy = "matCharId")
	private List<InspectionActuals> inspectionActuals;
	@Override
	public String toString() {
		return "MaterialCharacteristics [characterId=" + characterId + ", characterDesc=" + characterDesc
				+ ", material=" + material + ", toleranceLowerLimit=" + toleranceLowerLimit + ", toleranceUpperLimit="
				+ toleranceUpperLimit + ", unitOfMeasurement=" + unitOfMeasurement + ", active=" + active + "]";
	}
	
}
