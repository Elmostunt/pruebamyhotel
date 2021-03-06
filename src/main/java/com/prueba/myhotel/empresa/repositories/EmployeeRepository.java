package com.prueba.myhotel.empresa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.myhotel.empresa.dto.Employees;


@Repository
public interface EmployeeRepository extends CrudRepository<Employees, Long>  {

}
