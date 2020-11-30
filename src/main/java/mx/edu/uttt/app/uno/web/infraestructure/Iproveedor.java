package mx.edu.uttt.app.uno.web.infraestructure;

import java.util.List;

import mx.edu.uttt.app.uno.web.models.LoginAccount;
import mx.edu.uttt.app.uno.web.models.Proveedor;
import mx.edu.uttt.app.uno.web.models.RegisterAccount;

public interface Iproveedor {

	
	public void saveProveedor(Proveedor proveedor);
	public void deleteProveedor(int id);
	public List<Proveedor> findAll();
	public Proveedor findById(int id);	
	
}
