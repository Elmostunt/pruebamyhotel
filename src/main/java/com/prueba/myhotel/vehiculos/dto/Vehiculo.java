package com.prueba.myhotel.vehiculos.dto;

import java.util.List;



public class Vehiculo {
	
	Long id;
	String marca;
	String modelo;
	String patente;
	String año;
	Long kilometraje;
	Integer cilindrada;
	List<Mantenimiento> mantenimientos;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	public Long getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(Long kilometraje) {
		this.kilometraje = kilometraje;
	}
	public Integer getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(Integer cilindrada) {
		this.cilindrada = cilindrada;
	}
	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}
	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((año == null) ? 0 : año.hashCode());
		result = prime * result + ((cilindrada == null) ? 0 : cilindrada.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kilometraje == null) ? 0 : kilometraje.hashCode());
		result = prime * result + ((mantenimientos == null) ? 0 : mantenimientos.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((patente == null) ? 0 : patente.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (año == null) {
			if (other.año != null)
				return false;
		} else if (!año.equals(other.año))
			return false;
		if (cilindrada == null) {
			if (other.cilindrada != null)
				return false;
		} else if (!cilindrada.equals(other.cilindrada))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kilometraje == null) {
			if (other.kilometraje != null)
				return false;
		} else if (!kilometraje.equals(other.kilometraje))
			return false;
		if (mantenimientos == null) {
			if (other.mantenimientos != null)
				return false;
		} else if (!mantenimientos.equals(other.mantenimientos))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (patente == null) {
			if (other.patente != null)
				return false;
		} else if (!patente.equals(other.patente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", patente=" + patente + ", año="
				+ año + ", kilometraje=" + kilometraje + ", cilindrada=" + cilindrada + ", mantenimientos="
				+ mantenimientos + "]";
	}

}
