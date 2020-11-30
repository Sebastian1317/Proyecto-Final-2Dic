package mx.edu.uttt.app.uno.web.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String nombreCompania;
	@NotNull
	private String nombreContacto;
	private String tituloContacto;
	private String direccion;
	private String ciudad;
	private long telefono;
	private String fax;
	private String sitioWeb;
	private String facebook;
	private String twitter;
	@NotNull
	private String correoElectronico;
	
	public Proveedor() {}

	public Proveedor(int id, @NotNull String nombreCompania, @NotNull String nombreContacto, String tituloContacto,
			String direccion, String ciudad, long telefono, String fax, String sitioWeb, String facebook,
			String twitter, @NotNull String correoElectronico) {
		super();
		this.id = id;
		this.nombreCompania = nombreCompania;
		this.nombreContacto = nombreContacto;
		this.tituloContacto = tituloContacto;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.fax = fax;
		this.sitioWeb = sitioWeb;
		this.facebook = facebook;
		this.twitter = twitter;
		this.correoElectronico = correoElectronico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getTituloContacto() {
		return tituloContacto;
	}

	public void setTituloContacto(String tituloContacto) {
		this.tituloContacto = tituloContacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
}
