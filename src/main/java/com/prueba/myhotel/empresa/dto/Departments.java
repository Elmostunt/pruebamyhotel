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
@Table(name = "departments")
public class Departments {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEPARTMENT_ID")
	Long departmentId;
	@Column(name="DEPARTMENT_NAME")
	String departmentName;
	@Column(name="MANAGER_ID")
	Long managerId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "LOCATION_ID", referencedColumnName = "locationId")
	Locations location;
	
}
