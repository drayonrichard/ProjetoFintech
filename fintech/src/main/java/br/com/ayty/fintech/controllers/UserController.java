package br.com.ayty.fintech.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.ayty.fintech.models.Cadastro;
import br.com.ayty.fintech.repository.CadastroRepository;

/*
 * Classe de controle da entidade do usuário
 */
@Controller
public class UserController {

	/*
	 * CadastroRepository cria um objeto chamado cr para tratamento do usuário
	 */
	@Autowired
	private CadastroRepository cr;
	
	/*
	 * Utiliza o método GET do diretório de página /cadastro que retorna a página usuario/formCadastro.html do resource
	 */
	@RequestMapping(value= "/cadastro", method=RequestMethod.GET)
	public String form() {
		return "usuario/formCadastro";
	}
	
	/*
	 * Utiliza o método POST para salvar o cadastro no banco de dados e retorna a página cadastro redirecionada após a ação
	 */
	@RequestMapping(value= "/cadastro", method=RequestMethod.POST)
	public String form(Cadastro cadastro) {
		
		cr.save(cadastro);
		return "redirect:/cadastro";
		
	}
	
	/*
	 * Utiliza o método GET para pegar as informações no bando e cria uma lista de dados da tabela Cadastro e retorna como visualizador, 
	 * o visualizador está no index que por sua vez está reclacionado a página /cadastro e por vim retorna o visualizador.
	 */
	@RequestMapping(value="/cadastros", method=RequestMethod.GET)
	public ModelAndView listaCadastros() {
		ModelAndView mv	= new ModelAndView("index");
		Iterable<Cadastro> cadastros = cr.findAll();
		mv.addObject("cadastros", cadastros);
		return mv;
	}
	
	/*
	 * Utiliza o método GET para pegar os dados do banco e cria uma lista de acordo com o código passado e detalha os dados salvos neste código.
	 */
	@RequestMapping(value="/detalhesUsuario/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesUsuario(@PathVariable(value="codigo") long codigo) {
		Cadastro cadastro = cr.findByCodigo(codigo);
		ModelAndView mv	= new ModelAndView("usuario/detalhesUsuario");
		mv.addObject("cadastro", cadastro);
		return mv;
	}
	
	/*
	 * Faz uma busca pelo código repassado, salva este código e passa o objeto cr com método delete para excluir o dado relacionado ao código
	 * e por fim retorna a página /cadastros para a tela.
	 */
	@RequestMapping("/{codigo}")
	public String deletarUsuario(@PathVariable(value="codigo") long codigo) {
		Cadastro cadastro = cr.findByCodigo(codigo);
		cr.delete(cadastro);
		return "redirect:/cadastros";
		
	}
	
}
