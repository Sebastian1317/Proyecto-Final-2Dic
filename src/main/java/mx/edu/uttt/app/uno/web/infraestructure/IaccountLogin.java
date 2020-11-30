package mx.edu.uttt.app.uno.web.infraestructure;

import java.util.List;

import mx.edu.uttt.app.uno.web.models.LoginAccount;
import mx.edu.uttt.app.uno.web.models.RegisterAccount;

public interface IaccountLogin {

	public void save(LoginAccount loginaccount);
	public boolean AccountValidate(LoginAccount loginaccount);
	public void saveRegister(RegisterAccount register);
	public List<RegisterAccount> findAll();
	public RegisterAccount findById(Long id);		
}
