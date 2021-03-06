package com.prueba.myhotel.vehiculos.dto;

public class Camion extends Vehiculo{
	
	String tipo;
	Integer capacidadToneladas;
	Integer cantidadEjes;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getCapacidadToneladas() {
		return capacidadToneladas;
	}
	public void setCapacidadToneladas(Integer capacidadToneladas) {
		this.capacidadToneladas = capacidadToneladas;
	}
	public Integer getCantidadEjes() {
		return cantidadEjes;
	}
	public void setCantidadEjes(Integer cantidadEjes) {
		this.cantidadEjes = cantidadEjes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cantidadEjes == null) ? 0 : cantidadEjes.hashCode());
		result = prime * result + ((capacidadToneladas == null) ? 0 : capacidadToneladas.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camion other = (Camion) obj;
		if (cantidadEjes == null) {
			if (other.cantidadEjes != null)
				return false;
		} else if (!cantidadEjes.equals(other.cantidadEjes))
			return false;
		if (capacidadToneladas == null) {
			if (other.capacidadToneladas != null)
				return false;
		} else if (!capacidadToneladas.equals(other.capacidadToneladas))
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
		return "Camion [tipo=" + tipo + ", capacidadToneladas=" + capacidadToneladas + ", cantidadEjes=" + cantidadEjes
				+ "]";
	}
	
}
