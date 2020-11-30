package mx.edu.uttt.app.uno.web.infraestructure;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttt.app.uno.web.models.Articulo;
import mx.edu.uttt.app.uno.web.models.Proveedor;

public interface Iarticulo {
	
	public void saveArticulo(Articulo articulo);
	public void deleteArticulo(int id);
	public List<Articulo> findAll();
	public Articulo findById(int id);

}
