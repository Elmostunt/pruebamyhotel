package com.prueba.myhotel.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.myhotel.empresa.dto.Departments;

public interface DepartmentsRepository extends JpaRepository<Departments, Long> {

}
