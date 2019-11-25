package desafio.boot.controladores;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import desafio.boot.entidades.Membro;
import desafio.boot.entidades.Projeto;
import desafio.boot.repository.DesafioRepo;

@Controller
@RequestMapping(path = "/projetos")
public class ControladorProjetos {
	
	@Autowired
	private DesafioRepo repository;
	
	@RequestMapping(path = "/listaProj")
	public ModelAndView listarProjetos() {
		ModelAndView mv=new ModelAndView("listaProjetos");
		List<Projeto> listaProjetos=repository.listarProjetos();
		mv.addObject("listaProjetos", listaProjetos);
		return mv;
	}
	
	@RequestMapping(path = "/addForm")
	public String mostrarFormAdd(Model model) {
		model.addAttribute("projeto", new Projeto());
		return "addForm";
	}
	
	@RequestMapping(path = "/atualizaForm/{nomeProjeto}")
	public ModelAndView mostrarActForm(@PathVariable String nomeProjeto ) {
		ModelAndView mv=new ModelAndView("actForm");
		Projeto projeto=repository.obterProjeto(nomeProjeto);
		mv.addObject("projeto", projeto);
		
		return mv;
	}
		
	@RequestMapping("/adiciona")
	public String adicionarProjeto( @ModelAttribute(name = "projeto") Projeto projeto) {
		//service.adicionarProjeto(projeto);
		repository.adicionarProjeto(projeto);
		
		return "addForm";
	}
	
	@RequestMapping(path = "/remove/{nomeProjeto}")
	public void removerProjeto(@PathVariable String nomeProjeto) {
		//service.removerProjeto(nomeProjeto);
		repository.removerProjeto(nomeProjeto);
	}
	
	/*@RequestMapping(path = "/asociar/{nomeProjeto}")
	public ModelAndView consultarProjeto(@PathVariable String nomeProjeto) {
		ModelAndView mv=new ModelAndView("consulta");
		
		return mv;
	}*/
	
	@RequestMapping(path = "/atualiza")
	public String cargarModel(Model model) {
		model.addAttribute("projeto", new Projeto());
		
		return "redirect:atualizaProj";
	}
	
	@RequestMapping(path = "atualizaProj")
	public String atualizarProjeto(@ModelAttribute(name = "projeto") Projeto projeto) {
		//service.atualizarProjeto(projeto);
		repository.atualizarProjeto(projeto);
		return "listaProjetos";
	}
	
	@RequestMapping(path = "/mostrarAsocia/{projeto}")
	public String mostrarFormAsocia(Model model) {
		model.addAttribute("membro", new Membro());
		return "addForm";
	}
	
	@RequestMapping(path = "/mostrarAsocia/{projeto}")
	public String asociarProjeto(@ModelAttribute(name = "membro") Membro membro) {
		repository.asociarProjeto(membro.getProjeto().getNome(), membro.getNome());
		return "asocia";
	}
	
	

}
