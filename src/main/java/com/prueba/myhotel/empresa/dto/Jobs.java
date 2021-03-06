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
@Table(name = "jobs")
public class Jobs {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="JOB_ID")
	Long jobId;
	@Column(name="JOB_TITTLE")
	String jobTitle;
	@Column(name="MIN_SALARY")
	Double minSalary;
	@Column(name="MAX_SALARY")
	Double maxSalary;
}
