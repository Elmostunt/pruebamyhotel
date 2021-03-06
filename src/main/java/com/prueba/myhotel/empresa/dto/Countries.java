package com.prueba.myhotel.empresa.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "countries")
public class Countries {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COUNTRY_ID")
	Long countryId;
	@Column(name="COUNTRY_NAME")
	String countryName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "REGION_ID", referencedColumnName = "regionId")		
	Regions region;
	
}
