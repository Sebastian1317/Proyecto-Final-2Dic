package mx.edu.uttt.app.uno.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.edu.uttt.app.uno.web.infraestructure.IaccountLogin;
import mx.edu.uttt.app.uno.web.infraestructure.*;
import mx.edu.uttt.app.uno.web.models.*;

@Controller
public class LoginController {

	private static final String MY_SESSION_NOTES_CONSTANT = "MY_SESSION_NOTES";

	@Autowired
	IaccountLogin accountLogin;
	
	
	@RequestMapping(value = "/salir", method = RequestMethod.GET)
	public String Salir(final HttpServletRequest request) {
		
		request.getSession().invalidate();
		return "redirect:login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String account(Model model, final HttpServletRequest request) {
		
		if(request.getSession().getAttribute(MY_SESSION_NOTES_CONSTANT) !=null) {		
			return "redirect:listar";
			
		}else {
			request.getSession().invalidate();
			LoginAccount usuario = new LoginAccount();
			model.addAttribute("usuario", usuario);
			model.addAttribute("titulo", "Login");
			
			return "login";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("usuario") LoginAccount usuario, BindingResult result,
			Model model,final HttpServletRequest request) 
	{
		if(result.hasErrors()) 
		{
			model.addAttribute("titulo", "Login de Acceso!!");
			return "login";
		}
		if(accountLogin.AccountValidate(usuario))
		{
			List<String> notes = (List<String>) request.getSession().getAttribute(MY_SESSION_NOTES_CONSTANT);
			 if (CollectionUtils.isEmpty(notes)) {
		            notes = new ArrayList<>();
		        }
			notes.add("chuchin");
			request.getSession().setAttribute(MY_SESSION_NOTES_CONSTANT, notes);
			return "redirect:listar";
		}

		return "login";
	}
	
	@RequestMapping(value = "/registro", method=RequestMethod.GET)
	public String registro(Map<String, Object> model) {
		RegisterAccount register = new RegisterAccount();
		model.put("registro", register);
		model.put("titulo", "Registrar datos Personales");
		return "registro";

	}

	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute("registro") RegisterAccount register, BindingResult result, Model model,final HttpServletRequest request) 
	{
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Registrar datos Personales");
			return "registro";
		}
		if(request.getSession().getAttribute(MY_SESSION_NOTES_CONSTANT)!=null) {
			accountLogin.saveRegister(register);
			return "redirect:listar";
		}else {
			accountLogin.saveRegister(register);
			return "redirect:login";	
		}		
	}
	
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public String listar(Model model,final HttpServletRequest request) {
		
		final List<String> notes = (List<String>) request.getAttribute(MY_SESSION_NOTES_CONSTANT);
		
		if(request.getSession().getAttribute(MY_SESSION_NOTES_CONSTANT)!=null) {
			model.addAttribute("titulo", "Listado de usuarios");
			
			model.addAttribute("usuarios",accountLogin.findAll());
			return "listar";
		}else {
			LoginAccount usuario = new LoginAccount();
			model.addAttribute("usuario", usuario);
			model.addAttribute("titulo", "Login");
			
			return "login";
		}
		
		

	}
	
	@RequestMapping(value = "/registrar/{id}")
	public String editar(@PathVariable(value="id") Long id, Model model) 
	{
		RegisterAccount register = null;
		if(id >0) 
		{
		register = accountLogin.findById(id);	
		}
		else
		{
		return "redirect:listar";
		}
		model.addAttribute("registro", register);
		model.addAttribute("titulo", "Editar Cuenta de Usuario");
		return "registro";
	}
}
