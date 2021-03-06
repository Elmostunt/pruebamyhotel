package com.prueba.myhotel.vehiculos.service;

import java.util.List;

import com.prueba.myhotel.vehiculos.dto.Mantenimiento;
import com.prueba.myhotel.vehiculos.dto.Vehiculo;



public interface VehiculosService {

	Vehiculo getById(int id);

	String saveVehiculo(Vehiculo vehiculo);

	String deleteVehiculo(int id);

	String updateVehiculo(int id, Vehiculo vehiculo);

	List<Vehiculo> listarVehiculos();

	String añadirMantenimiento(int id, Mantenimiento mantencion);
}
