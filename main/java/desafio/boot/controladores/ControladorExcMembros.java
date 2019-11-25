package desafio.boot.controladores;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import desafio.boot.respostas.RespostaRest;

@RestControllerAdvice
public class ControladorExcMembros {

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(SQLException.class)
	public RespostaRest mandarRespostaErro(SQLException e) {
		RespostaRest resposta=new RespostaRest();
		resposta.setCodigoResposta(500);
		resposta.setMenssagem(e.getLocalizedMessage());
		
		return resposta;
	}
}
