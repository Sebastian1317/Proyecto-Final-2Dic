package mx.edu.uttt.app.uno.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttt.app.uno.web.infraestructure.Iproveedor;
import mx.edu.uttt.app.uno.web.models.Articulo;
import mx.edu.uttt.app.uno.web.models.Proveedor;

@Repository
public class ProveedorRepository implements Iproveedor {

	@PersistenceContext
	private EntityManager entity;
	
	@Transactional
	@Override
	public void saveProveedor(Proveedor proveedor) {

			if (proveedor.getId() == 0) {

				entity.persist(proveedor);

			} else {
				entity.merge(proveedor);

			}
	}

	@Transactional
	@Override
	public void deleteProveedor(int id) {
		
			
			Proveedor proveedor =(Proveedor)entity.find(Proveedor.class, id);
			
			if(proveedor.getId() > 0 && proveedor !=null)
				
				entity.remove(proveedor);	
	}

	@Transactional(readOnly = true)
	@Override
	public List<Proveedor> findAll() {
		// TODO Auto-generated method stub
		return (List<Proveedor>) entity.createQuery("from Proveedor").getResultList();
	}

	@Transactional(readOnly = true)
	@Override
	public Proveedor findById(int id) {
	
		return entity.find(Proveedor.class, id);
	}

}
