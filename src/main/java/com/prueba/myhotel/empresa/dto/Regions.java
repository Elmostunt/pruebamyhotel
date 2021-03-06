package com.prueba.myhotel.empresa.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "regions")
public class Regions {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REGION_ID")
	Long regionId;
	@Column(name="REGION_NAME")
	String regionName;
}
