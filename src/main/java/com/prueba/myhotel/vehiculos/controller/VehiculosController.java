package com.prueba.myhotel.vehiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.myhotel.vehiculos.dto.Mantenimiento;
import com.prueba.myhotel.vehiculos.dto.Vehiculo;
import com.prueba.myhotel.vehiculos.service.VehiculosService;



@RestController
public class VehiculosController {

	@Autowired 
	VehiculosService vehiculosService;
	
	@GetMapping(path="vehiculo/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Vehiculo getVehiculoPorId(@PathVariable("id") int id) {
		return vehiculosService.getById(id);
	}
	
	@PostMapping(path="add/vehiculo")
	public String insertarVehiculo(@RequestBody Vehiculo vehiculo) {
		return vehiculosService.saveVehiculo(vehiculo);
	}
	
	@DeleteMapping(path="eliminar/{id}")
	public String eliminarVehiculo(@PathVariable int id) {
		return vehiculosService.deleteVehiculo(id);
		
	}
	
	@PostMapping(path = "update/vehiculo/{id}")
	public String actualizarVehiculo(@RequestBody Vehiculo vehiculo, @PathVariable("id") int id) {
		return vehiculosService.updateVehiculo(id,vehiculo);
	}
	
	@GetMapping(path="listar/vehiculos", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Vehiculo> listarVehiculos(){
		return vehiculosService.listarVehiculos();
		
	}
	
	@PostMapping(path="add/mantenimiento/{id}")
	public String añadirMantenimiento(@PathVariable("id") int id,Mantenimiento mantencion) {
		return vehiculosService.añadirMantenimiento(id, mantencion);
		
	}
}
