package desafio.boot.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.boot.entidades.Membro;
import desafio.boot.repository.MembroRepository;
import desafio.boot.respostas.RespostaRest;

@RestController
@RequestMapping(path = "/rest")
public class ControladorMembros {
    @Autowired
    private MembroRepository repository;
    
	@PostMapping(path = "/adicionaMembro",consumes = {"application/json","text/xml"})
	public RespostaRest adicionarMembro(@RequestBody Membro membro) {
		repository.adicionarMembro(membro);
		RespostaRest resposta=new RespostaRest();
		resposta.setCodigoResposta(200);
		resposta.setMenssagem("Membro foi adicionado com successo");
		
		return resposta;
	}
}
