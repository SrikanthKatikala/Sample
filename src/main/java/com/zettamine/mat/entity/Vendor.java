package com.zettamine.mat.entity;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "vend")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "vendorId")	
	@SequenceGenerator(name = "vendorId",sequenceName = "vendorId", initialValue = 2001,allocationSize = 1)
	@Column(name = "vend_id")
	private Integer vendorId;
	@Column(name = "vend_name", length = 100)
	//@NotNull(message="* required")
	private String vendorName;
	
	//@NotNull(message = "*required")
	//@Size(max = 10, message = "must have 10 digits")
	//@Pattern(regexp = "^[6-9]\\d{9}$", message = "invalid mobile number format")
	@Column(name = "contact", length =10)
	private String vendorContact;
	
	@Column(name = "active")
	private String active;
	@OneToMany(mappedBy = "vendor")
	private List<InspectionLot> inspectionLots;
	public Vendor(String vendorName, String vendorContact) {
		super();
		this.vendorName = vendorName;
		this.vendorContact = vendorContact;
	}
	public Vendor(String vendorName, String vendorContact, String active) {
		super();
		this.vendorName = vendorName;
		this.vendorContact = vendorContact;
		this.active = active;
	}
	public Vendor(Integer vendorId, String vendorName, String vendorContact) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorContact = vendorContact;
	}
	
}
