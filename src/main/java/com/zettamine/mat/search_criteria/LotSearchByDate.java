package com.zettamine.mat.search_criteria;

import java.time.LocalDate;
import com.zettamine.mat.entity.Material;
import com.zettamine.mat.entity.Plant;
import com.zettamine.mat.entity.User;
import com.zettamine.mat.entity.Vendor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LotSearchByDate {

	private Integer lotId;
	private Material material;
	private Vendor vendor;
	private Plant plant;
	private LocalDate createdOn;
	private LocalDate ispStartDate;
	private LocalDate ispEndDate;
	private String result;
	private String remarks;
	private User user;

}
