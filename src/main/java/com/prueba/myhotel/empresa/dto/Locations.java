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
@Table(name = "locations")
public class Locations {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOCATION_ID")
	Long locationId;
	@Column(name="STREET_ADDRESS")
	String streetAddress;
	@Column(name="POSTAL_CODE")
	String postalCode;
	@Column(name="CITY")
	String city;
	@Column(name="STATE_PROVINCE")
	String stateProvince;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "countryId")
	Countries country;
	
}
