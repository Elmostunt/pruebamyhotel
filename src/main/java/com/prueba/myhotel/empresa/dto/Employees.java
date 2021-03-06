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
@Table(name = "employees")
public class Employees {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMPLOYEE_ID")
	Long employeeId;
	@Column(name="FIRST_NAME")
	String firstName;
	@Column(name="LAST_NAME")
	String lastName;
	@Column(name="EMAIL")
	String email;
	@Column(name="PHONE_NUMBER")
	String phoneNumber;
	@Column(name="HIRE_DATE")
	String hireDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "JOB_ID", referencedColumnName = "jobId")
	Jobs jobs;
	
	@Column(name="JOB_ID")
	String jobId;
	@Column(name="SALARY")
	Double salary;
	@Column(name="COMMISION_PCT")
	Double commisionPct;
	@Column(name="MANAGER_ID")
	String managerId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "departmentId")
	Departments department;
}
