package mx.edu.uttt.app.uno.web.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="articulo")
public class Articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String nombre;
	@NotNull
	private double cantidadPorUnidad;
	@NotNull
	private double precioPorUnidad;
	@NotNull
	private double unidadesEnStock;
	@NotNull
	private double unidadesOrdenadas;
	@NotNull
	private String nivelOrdenamiento;
	private boolean descontinuado;
	@NotNull
	private double margenUtilidad;
	private double precioPorMayoreo;
	private double numSku;
	private String unidadMedida;
	public Articulo(int id, String nombre, double cantidadPorUnidad, double precioPorUnidad, double unidadesEnStock,
			double unidadesOrdenadas, String nivelOrdenamiento, boolean descontinuado, double margenUtilidad,
			double precioPorMayoreo, double numSku, String unidadMedida) {
		
		this.id = id;
		this.nombre = nombre;
		this.cantidadPorUnidad = cantidadPorUnidad;
		this.precioPorUnidad = precioPorUnidad;
		this.unidadesEnStock = unidadesEnStock;
		this.unidadesOrdenadas = unidadesOrdenadas;
		this.nivelOrdenamiento = nivelOrdenamiento;
		this.descontinuado = descontinuado;
		this.margenUtilidad = margenUtilidad;
		this.precioPorMayoreo = precioPorMayoreo;
		this.numSku = numSku;
		this.unidadMedida = unidadMedida;
	}
	
	public Articulo() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidadPorUnidad() {
		return cantidadPorUnidad;
	}

	public void setCantidadPorUnidad(double cantidadPorUnidad) {
		this.cantidadPorUnidad = cantidadPorUnidad;
	}

	public double getPrecioPorUnidad() {
		return precioPorUnidad;
	}

	public void setPrecioPorUnidad(double precioPorUnidad) {
		this.precioPorUnidad = precioPorUnidad;
	}

	public double getUnidadesEnStock() {
		return unidadesEnStock;
	}

	public void setUnidadesEnStock(double unidadesEnStock) {
		this.unidadesEnStock = unidadesEnStock;
	}

	public double getUnidadesOrdenadas() {
		return unidadesOrdenadas;
	}

	public void setUnidadesOrdenadas(double unidadesOrdenadas) {
		this.unidadesOrdenadas = unidadesOrdenadas;
	}

	public String getNivelOrdenamiento() {
		return nivelOrdenamiento;
	}

	public void setNivelOrdenamiento(String nivelOrdenamiento) {
		this.nivelOrdenamiento = nivelOrdenamiento;
	}

	public boolean isDescontinuado() {
		return descontinuado;
	}

	public void setDescontinuado(boolean descontinuado) {
		this.descontinuado = descontinuado;
	}

	public double getMargenUtilidad() {
		return margenUtilidad;
	}

	public void setMargenUtilidad(double margenUtilidad) {
		this.margenUtilidad = margenUtilidad;
	}

	public double getPrecioPorMayoreo() {
		return precioPorMayoreo;
	}

	public void setPrecioPorMayoreo(double precioPorMayoreo) {
		this.precioPorMayoreo = precioPorMayoreo;
	}

	public double getNumSku() {
		return numSku;
	}

	public void setNumSku(double numSku) {
		this.numSku = numSku;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	
	
	
}
