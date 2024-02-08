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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "userId")
	@SequenceGenerator(name = "userId",sequenceName = "userId",
	initialValue = 9001,allocationSize = 1)
	private Integer userId;
	@Column(name="user_name")
	private String userName;
	@Column(name = "user_pwd")
	private String userPassword;
	@Column(name = "active")
	private String active;
	@OneToMany(mappedBy = "user")
	@ToString.Exclude
	private List<InspectionLot> inspectionLots;
	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public User(String userName, String userPassword, List<InspectionLot> inspectionLots) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.inspectionLots = inspectionLots;
	}
	
}
