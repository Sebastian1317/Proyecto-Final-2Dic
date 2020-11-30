package mx.edu.uttt.app.uno.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.edu.uttt.app.uno.web.infraestructure.Iproveedor;
import mx.edu.uttt.app.uno.web.models.LoginAccount;
import mx.edu.uttt.app.uno.web.models.Proveedor;
import mx.edu.uttt.app.uno.web.models.RegisterAccount;

@Controller
public class ProveedorController {

	private static final String MY_SESSION_NOTES_CONSTANT = "MY_SESSION_NOTES";
	
	@Autowired
	private Iproveedor iproveedor;
	
	@RequestMapping(value = "/salirP", method = RequestMethod.GET)
	public String Salir(final HttpServletRequest request,Model model) {
		
		request.getSession().invalidate();
		LoginAccount usuario = new LoginAccount();
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Login");
		return "login";

	}
	
	@RequestMapping(value = "/Rproveedor", method = RequestMethod.GET)
	public String account(Model model,final HttpServletRequest request) {
		if(request.getSession().getAttribute(MY_SESSION_NOTES_CONSTANT)!=null) {
			
			Proveedor proveedor = new Proveedor();
			model.addAttribute("proveedor", proveedor);
			model.addAttribute("titulo", "Lista de Proveedores");
			
			return "registrarP";	
			
		}else {
			
			LoginAccount usuario = new LoginAccount();
			model.addAttribute("usuario", usuario);
			model.addAttribute("titulo", "Login");
			return "login";
		}
		
	}
	
	@RequestMapping(value = "/Rproveedor", method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute("proveedor") Proveedor proveedor, BindingResult result, Model model) 
	{
		if(result.hasErrors()) 
		{
			model.addAttribute("titulo", "Datos incorrectos");
			return "registrarP";
		}else {
		iproveedor.saveProveedor(proveedor);
		model.addAttribute("proveedores",iproveedor.findAll());
		return "proveedores";	
		}
	}
	


	@RequestMapping(value = "/listarP", method=RequestMethod.GET)
	public String listar(Model model,final HttpServletRequest request) {

		if(request.getSession().getAttribute(MY_SESSION_NOTES_CONSTANT)!=null) {
			
			model.addAttribute("titulo", "Listado de proveedores");
			model.addAttribute("proveedores",iproveedor.findAll());
			return "proveedores";
			
		}else {
			LoginAccount usuario = new LoginAccount();
			model.addAttribute("usuario", usuario);
			model.addAttribute("titulo", "Login");
			return "login";
		}
	}
	
	@RequestMapping(value = "/Eproveedor/{id}")
	public String editar(@PathVariable(value="id") int id, Model model) 
	{
		Proveedor proveedor = null;
		if(id >0) 
		{
		proveedor = iproveedor.findById(id);	
		}
		else
		{
		return "redirect:proveedores";
		}
		model.addAttribute("proveedor", proveedor);
		model.addAttribute("titulo", "Editar Proovedor");
		return "registrarP";
	}
	
	@RequestMapping(value = "/Dproveedor/{id}")
	public String eliminar(@PathVariable(value="id") int id, Model model) 
	{
		Proveedor proveedor = null;
		if(id >0) 
		{
		 iproveedor.deleteProveedor(id);
		 model.addAttribute("proveedores",iproveedor.findAll());
		 return "proveedores";
		}
		else
		{
		return "redirect:proveedores";
		}
	}
}
