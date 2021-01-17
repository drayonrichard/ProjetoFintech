package br.com.ayty.fintech.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ayty.fintech.models.Cadastro;
import br.com.ayty.fintech.repository.CadastroRepository;

@Controller
public class UserController {

	@Autowired
	private CadastroRepository cr;
	
	@RequestMapping(value= "/cadastro", method=RequestMethod.GET)
	public String form() {
		return "usuario/formCadastro";
	}
	
	@RequestMapping(value= "/cadastro", method=RequestMethod.POST)
	public String form(Cadastro cadastro) {
		
		cr.save(cadastro);
		return "redirect:/cadastro";
		
	}
	
	@RequestMapping(value="/cadastros", method=RequestMethod.GET)
	public ModelAndView listaCadastros() {
		ModelAndView mv	= new ModelAndView("index");
		Iterable<Cadastro> cadastros = cr.findAll();
		mv.addObject("cadastros", cadastros);
		return mv;
	}
	
	@RequestMapping(value="/detalhesUsuario/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesUsuario(@PathVariable(value="codigo") long codigo) {
		Cadastro cadastro = cr.findByCodigo(codigo);
		ModelAndView mv	= new ModelAndView("usuario/detalhesUsuario");
		mv.addObject("cadastro", cadastro);
		return mv;
	}
	
}
