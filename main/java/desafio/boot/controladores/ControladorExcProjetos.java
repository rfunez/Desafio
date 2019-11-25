package desafio.boot.controladores;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import desafio.boot.exceptions.AtualizacaoException;

@ControllerAdvice
public class ControladorExcProjetos {
	
	@ExceptionHandler(AtualizacaoException.class)
	public ModelAndView mostrarErroActProjeto(AtualizacaoException exc) {
		ModelAndView mv=new ModelAndView("erro");
		mv.addObject("causa", "Operaçao de atualizaçao de projeto nao permitida");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView mostrarErroGeral(Exception exc) {
		ModelAndView mv=new ModelAndView("erro");
		mv.addObject("causa", exc.getMessage());
		
		return mv;
	}

}
