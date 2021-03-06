package com.prueba.myhotel.vehiculos.dto;

public class Automovil extends Vehiculo{
	String tipo;
	Integer numeroPuertas;
	Integer cantidadPasajeros;
	Integer capacidadMaletero;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getNumeroPuertas() {
		return numeroPuertas;
	}
	public void setNumeroPuertas(Integer numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}
	public Integer getCantidadPasajeros() {
		return cantidadPasajeros;
	}
	public void setCantidadPasajeros(Integer cantidadPasajeros) {
		this.cantidadPasajeros = cantidadPasajeros;
	}
	public Integer getCapacidadMaletero() {
		return capacidadMaletero;
	}
	public void setCapacidadMaletero(Integer capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidadPasajeros == null) ? 0 : cantidadPasajeros.hashCode());
		result = prime * result + ((capacidadMaletero == null) ? 0 : capacidadMaletero.hashCode());
		result = prime * result + ((numeroPuertas == null) ? 0 : numeroPuertas.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Automovil other = (Automovil) obj;
		if (cantidadPasajeros == null) {
			if (other.cantidadPasajeros != null)
				return false;
		} else if (!cantidadPasajeros.equals(other.cantidadPasajeros))
			return false;
		if (capacidadMaletero == null) {
			if (other.capacidadMaletero != null)
				return false;
		} else if (!capacidadMaletero.equals(other.capacidadMaletero))
			return false;
		if (numeroPuertas == null) {
			if (other.numeroPuertas != null)
				return false;
		} else if (!numeroPuertas.equals(other.numeroPuertas))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Automovil [tipo=" + tipo + ", numeroPuertas=" + numeroPuertas + ", cantidadPasajeros="
				+ cantidadPasajeros + ", capacidadMaletero=" + capacidadMaletero + "]";
	}

}
