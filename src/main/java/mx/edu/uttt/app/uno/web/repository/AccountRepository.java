package mx.edu.uttt.app.uno.web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import mx.edu.uttt.app.uno.web.infraestructure.IaccountLogin;
import mx.edu.uttt.app.uno.web.models.LoginAccount;
import mx.edu.uttt.app.uno.web.models.RegisterAccount;


@Repository
public class AccountRepository  implements IaccountLogin{

	
	@PersistenceContext
	private EntityManager entity;
	
	@javax.transaction.Transactional
	@Override
	public void save(LoginAccount loginaccount) {
		// TODO Auto-generated method stub
		entity.persist(loginaccount);
	}
	
	@Transactional(readOnly = true)
	@Override
	public boolean AccountValidate(LoginAccount loginaccount) {
		boolean respuesta = false;
		try {
			LoginAccount result = (LoginAccount) entity.createQuery("SELECT e FROM LoginAccount e WHERE e.email=?1 and e.password=?2")
					.setParameter(1, loginaccount.getEmail())
					.setParameter(2, loginaccount.getPassword()).getSingleResult();
			if(result != null)
			{
				respuesta = true;
			}
		}
		catch(Exception ex)
		{
			String error= ex.getMessage();
		}
		return respuesta;
	}

	@Transactional
	@Override
	public void saveRegister(RegisterAccount register) {
		if(register.getId()!=null && register.getId()>0) 
		{
			entity.merge(register);
		}else 
		{
			entity.persist(register);	
		}
	}

	@Transactional(readOnly = true)
	@Override
	public List<RegisterAccount> findAll() {
		
		return entity.createQuery("from RegisterAccount").getResultList();
	}

	@Transactional(readOnly = true)
	@Override
	public RegisterAccount findById(Long id) {
		
		return entity.find(RegisterAccount.class, id);
	}
	
}
