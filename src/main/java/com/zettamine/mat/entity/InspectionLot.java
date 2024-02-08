package com.zettamine.mat.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
import lombok.ToString;

@Entity
@Table(name = "isp_lot")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"material","vendor","plant","user"})
public class InspectionLot implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "isp_lot_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "characterId")
	@SequenceGenerator(sequenceName = "characterId",name = "characterId",initialValue = 5501,allocationSize = 1)
	private Integer lotId;
	
	@ManyToOne(cascade = CascadeType.ALL,targetEntity = Material.class)
	@JoinColumn(name = "mat_id", nullable = false)
	private Material material;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Vendor.class)
	@JoinColumn(name = "vend_id", nullable = false)
	private Vendor vendor;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Plant.class)
	@JoinColumn(name = "plnt_id", nullable = false)
	private Plant plant;
	
	@Column(name = "created")
	private LocalDate createdOn;
	
	@Column(name = "isp_st_dt")
	private LocalDate ispStartDate;
	
	@Column(name = "isp_end_dt")
	private LocalDate ispEndDate;
	
	@Column(name = "ist_res")
	private String result;
	
	@Column(name = "remarks")
	private String remarks;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "inspectionLot")
	private List<InspectionActuals> inspectionActuals;
	
	
	@Column(name="active")
	private String active;
	
}



