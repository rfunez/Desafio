package desafio.boot.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import desafio.boot.entidades.Membro;
import desafio.boot.entidades.Projeto;

@Repository
@Transactional
public class MembroRepository {
	@PersistenceContext
	private EntityManager em;

	public void adicionarMembro(Membro membro) {
		em.persist(membro);
	}

}
