package com.prueba.myhotel.empresa.dto;

import java.sql.Date;

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
@Table(name = "job_history")
public class JobHistory {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMPLOYEE_ID")
	Long employeeId;
	@Column(name="START_DATE")
	Date startDate;
	@Column(name="END_DATE")
	Date endDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "JOB_ID", referencedColumnName = "jobId")
	Jobs job;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "departmentId")
	Departments department;
}
