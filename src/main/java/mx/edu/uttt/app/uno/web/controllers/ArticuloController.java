package mx.edu.uttt.app.uno.web.controllers;

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

import mx.edu.uttt.app.uno.web.infraestructure.Iarticulo;
import mx.edu.uttt.app.uno.web.infraestructure.Iproveedor;
import mx.edu.uttt.app.uno.web.models.Articulo;
import mx.edu.uttt.app.uno.web.models.LoginAccount;
import mx.edu.uttt.app.uno.web.models.Proveedor;

@Controller
public class ArticuloController {

	
	private static final String MY_SESSION_NOTES_CONSTANT = "MY_SESSION_NOTES";

	@Autowired
	private Iarticulo iarticulo;

	
	@RequestMapping(value = "/salirA", method = RequestMethod.GET)
	public String Salir(final HttpServletRequest request,Model model) {
		
		request.getSession().invalidate();
		LoginAccount usuario = new LoginAccount();
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Login");
		return "login";

	}
	
	@RequestMapping(value = "/Rarticulo", method = RequestMethod.GET)
	public String account(Model model,final HttpServletRequest request) {

		if(request.getSession().getAttribute(MY_SESSION_NOTES_CONSTANT)!=null) {
		
			Articulo articulo = new Articulo();
			model.addAttribute("articulo", articulo);
			model.addAttribute("titulo", "Articulo");

			return "registrarA";
			
		}else {
			LoginAccount usuario = new LoginAccount();
			model.addAttribute("usuario", usuario);
			model.addAttribute("titulo", "Login");
			return "login";	
		}
		
	}

	@RequestMapping(value = "/Rarticulo", method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute("articulo") Articulo articulo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Datos incorrectos");
			return "registrarP";
		} else {

			articulo.isDescontinuado();
			
			iarticulo.saveArticulo(articulo);
			model.addAttribute("titulo", "Listado de articulos");
			model.addAttribute("articulos", iarticulo.findAll());
			return "articulos";
		}
	}

	@RequestMapping(value = "/listarA", method = RequestMethod.GET)
	public String listar(Model model,final HttpServletRequest request) {

		if(request.getSession().getAttribute(MY_SESSION_NOTES_CONSTANT)!=null) {
			
			model.addAttribute("titulo", "Listado de articulos");
			model.addAttribute("articulos", iarticulo.findAll());
			return "articulos";	
		}else {
			
			LoginAccount usuario = new LoginAccount();
			model.addAttribute("usuario", usuario);
			model.addAttribute("titulo", "Login");
			return "login";
		}

	}

	@RequestMapping(value = "/Earticulo/{id}")
	public String editar(@PathVariable(value = "id") int id, Model model) {
		Articulo articulo = null;
		if (id > 0) {
			articulo = iarticulo.findById(id);
		} else {
			return "redirect:articulo";
		}
		model.addAttribute("articulo", articulo);
		model.addAttribute("titulo", "Editar articulo");
		return "registrarA";
	}

	@RequestMapping(value = "/Darticulo/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable(value = "id") int id, Model model) {
		
		if (id > 0) {
			iarticulo.deleteArticulo(id);
			model.addAttribute("articulos", iarticulo.findAll());
			return "articulos";
		} else {
			return "redirect:articulos";
		}
	}

}
