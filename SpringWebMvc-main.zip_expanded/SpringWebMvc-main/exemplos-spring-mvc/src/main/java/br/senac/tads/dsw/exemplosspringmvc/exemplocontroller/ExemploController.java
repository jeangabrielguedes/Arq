package br.senac.tads.dsw.exemplosspringmvc.exemplocontroller;


import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import modelos.Dados;

@Controller
@RequestMapping("/exemplo")
public class ExemploController {
	
//	
//	@GetMapping("/mensagem1")
//	public String saudar1(Model modelo) {
//		return "mensagem-view";
//	}
//	
	
	@GetMapping("/mensagem2")
	public ModelAndView saudar2() {
	return new ModelAndView("mensagem-view");
	}

	
	@GetMapping("/exemplo-request-param")
	public ModelAndView exemploRequestParam (
	@RequestParam(value = "param1str", required = true, defaultValue = 
	"valor") String param1,
	@RequestParam(value = "param2int", required = false, defaultValue = "99")
	int param2) {
	 ModelAndView resposta = new ModelAndView("view-exemplo");
	 return resposta;
	}
	
	@GetMapping("/exemplo-path-var/{param1str}/{param2int}")
	public ModelAndView exemploPathVariable (
	@PathVariable(value = "param1str", required = true) String param1,
	@PathVariable(value = "param2int", required = true) int param2) {
	 ModelAndView resposta = new ModelAndView("view-exemplo");
	 return resposta;
	}
	
	@GetMapping("/exemplo-view-obj")
	public ModelAndView exemploViewObj() {
	 ModelAndView mv = new ModelAndView("view-exemplo");
	 mv.addObject("texto", "Texto gerado no Controller v2");
	 mv.addObject("numero", 100);
	 mv.addObject("dataHora"
	, LocalDateTime.now());
	 return mv;
	}
	
	
	@GetMapping("/dados-pessoais")
	public ModelAndView dadosPessoais() {
	 ModelAndView mv = new ModelAndView("dados-pessoais");
	 mv.addObject("nome", "Jean Gabriel Constantino Gudes");
	 mv.addObject("numeroTelefone", "(11)960578386");
	 mv.addObject("email", "jean.gcguedes@senacsp.edu,br");
	 mv.addObject("dataNascimento", "09/08/2001");
	 mv.addObject("linkedin", "https://www.linkedin.com/in/jean-guedes-28066b16a/");
	 mv.addObject("gitHub", "https://github.com/jeangabrielguedes");
	 return mv;
	}
	
	@GetMapping("/dados-pessoais-recriado")
	public ModelAndView dadosPessoaisRecriado() {
	 ModelAndView mv = new ModelAndView("dados-pessoais-recriado");
	 mv.addObject("nome", "Jean Gabriel Constantino Guedes");
	 mv.addObject("numeroTelefone", "(11)96057-8386");
	 mv.addObject("email", "jean.gcguedes@senacsp.edu.br");
	 mv.addObject("dataNascimento", "09/08/2001");
	 mv.addObject("linkedin", "https://www.linkedin.com/in/jean-guedes-28066b16a/");
	 mv.addObject("gitHub", "https://github.com/jeangabrielguedes");
	 return mv;
	}
	
	
	
	@GetMapping("/formulario")
	public ModelAndView dadosFormulario() {
	    Dados dados = new Dados(); 
	    ModelAndView mv = new ModelAndView("formulario");
	    mv.addObject("dados", dados); 
	    return mv;
	}

	
	@PostMapping("/salvar")
	public ModelAndView salvar(@ModelAttribute Dados dadosRecebidos, RedirectAttributes redirAttr) {
		 ModelAndView mv = new ModelAndView("redirect:/exemplo/formulario");
		 
		   Dados dados = new Dados();
		   
		   dados.setEmail(dadosRecebidos.getEmail());
		   dados.setNome(dadosRecebidos.getNome());
		   dados.setEmail(dadosRecebidos.getEmail());
		
	       mv.addObject("dados", dadosRecebidos);
	 
	 redirAttr.addFlashAttribute("dados", dadosRecebidos);
	 
	 return mv;
	 
	}

}
