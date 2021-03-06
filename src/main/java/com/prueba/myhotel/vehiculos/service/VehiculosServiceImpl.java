package com.prueba.myhotel.vehiculos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.myhotel.vehiculos.dto.Mantenimiento;
import com.prueba.myhotel.vehiculos.dto.Vehiculo;


@Service
public class VehiculosServiceImpl implements VehiculosService{

	
	List<Vehiculo> listadoVehiculos = new ArrayList<Vehiculo>();
	@Override
	public Vehiculo getById(int id) {
		for(Vehiculo cursor : listadoVehiculos){ 
			if(id==cursor.getId().intValue()){
				return cursor;
			}
		}
		return null;
	}

	@Override
	public String saveVehiculo(Vehiculo vehiculo) {
		listadoVehiculos.add(vehiculo);
		return "OK";
	}

	@Override
	public String deleteVehiculo(int id) {
		Vehiculo vehiculoABorrar = getById(id);
		listadoVehiculos.remove(vehiculoABorrar);
		return "Eliminado OK";
	}

	@Override
	public String updateVehiculo(int id,Vehiculo vehiculo) {
		for(Vehiculo cursor : listadoVehiculos){ 
			if(id==cursor.getId().intValue()){
				cursor=vehiculo;
			}
		}
		
		return "Actualizacion ok";
	}

	@Override
	public List<Vehiculo> listarVehiculos() {
		
		
		return listadoVehiculos;
	}

	
	@Override
	public String añadirMantenimiento(int id, Mantenimiento mantencion) {
		for(Vehiculo cursor : listadoVehiculos){ 
			if(id==cursor.getId().intValue()){
				cursor.getMantenimientos().add(mantencion);
				return "Mantenimineto añadido";

			}
		}	
		return "No se puede añadir";
	}

}
