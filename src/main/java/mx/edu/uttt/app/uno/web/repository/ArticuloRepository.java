package mx.edu.uttt.app.uno.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttt.app.uno.web.infraestructure.Iarticulo;
import mx.edu.uttt.app.uno.web.models.Articulo;
import mx.edu.uttt.app.uno.web.models.RegisterAccount;

@Repository

public class ArticuloRepository implements Iarticulo{

	@PersistenceContext
	private EntityManager entity;
	
	@Transactional
	@Override 
	public void saveArticulo(Articulo articulo) {
		
			if(articulo.getId() == 0) {
				
				entity.persist(articulo);
				
			}else {
				
				entity.merge(articulo);
			}
			
		
		
	}
	
	@Transactional
	@Override
	public void deleteArticulo(int id) {
			
		Articulo articulo =(Articulo)entity.find(Articulo.class, id);
		
		if(articulo.getId() > 0) {	
			entity.remove(articulo);
		}
	}
	
	@Override
	public List<Articulo> findAll() {
		
		return (List<Articulo>) entity.createQuery("from Articulo").getResultList();
	}

	@Transactional(readOnly = true)
	@Override
	public Articulo findById(int id) {
		return entity.find(Articulo.class, id);
	}

}
