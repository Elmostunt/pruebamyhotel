package com.prueba.myhotel.empresa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.myhotel.empresa.dto.Employees;
import com.prueba.myhotel.empresa.repositories.EmployeeRepository;

@RestController
@RequestMapping(path="/prueba")
public class EmpresaController {
	@Autowired
	EmployeeRepository repoEmpleado;
	
	 @GetMapping(path= "/getall")
	 public List<Employees> getAllEmployees() {
		 List<Employees> listaEmpleados = new ArrayList<Employees>();
		 Iterable<Employees> iterableEmp = repoEmpleado.findAll();
		 iterableEmp.forEach(listaEmpleados::add);
		return listaEmpleados;

	 }
	 
	 @PostMapping(path="/addEmployee")
	 public HttpStatus addEmployee() {
		 Employees empleado = new Employees();
		 repoEmpleado.save(empleado);
		 return HttpStatus.CREATED;
	 }
	 
	 @DeleteMapping(path="/deleteEmployee/{id}")
	 public HttpStatus deleteEmployee(Employees emp) {

		 repoEmpleado.delete(emp);
		 return HttpStatus.OK;
	 }
	 
	 @GetMapping(path="getEmployeeById/{id}")
	 public Employees getById(@PathVariable("id") Long id) {
		Optional<Employees>  empleado = repoEmpleado.findById(id);
		if(empleado.isPresent()) {
			return empleado.get();
		}
		return null;
	
	 }
	
}
