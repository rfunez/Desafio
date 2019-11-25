package desafio.boot.services;

import org.springframework.stereotype.Service;

import desafio.boot.entidades.Membro;
import desafio.boot.repository.MembroRepository;

@Service
public class MembroService {
	private MembroRepository membroRep;
	
	public void adicionarMembroServ(Membro membro) {
		membroRep.adicionarMembro(membro);
	}

}
