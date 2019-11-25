package desafio.boot.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import desafio.boot.entidades.Membro;
import desafio.boot.entidades.Projeto;
import desafio.boot.exceptions.AtualizacaoException;

@Repository
@Transactional
public class DesafioRepo implements ProjetosDAOInt {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void adicionarProjeto(Projeto projeto) {
		em.persist(projeto);

	}

	@Override
	public void atualizarProjeto(Projeto projeto){
		   Projeto projetoSalvo=em.find(Projeto.class, projeto.getNome());
		   projetoSalvo.setDataInicio(projeto.getDataInicio());
		   projetoSalvo.setDataTermino(projeto.getDataTermino());
		   projetoSalvo.setDescricao(projeto.getDescricao());
		   projetoSalvo.setGerente(projeto.getGerente());
		   projetoSalvo.setOrcamento(projeto.getOrcamento());
		   projetoSalvo.setPrevTermino(projeto.getPrevTermino());
		   projetoSalvo.setStatus(projeto.getStatus());
	}

	@Override
	public void removerProjeto(String nomeProjeto) {
		Projeto projeto=em.find(Projeto.class, nomeProjeto);
		String status=projeto.getStatus();
		
		if(!(status.equals("Andamento") || status.equals("Encerrado") || status.equals("Iniciado"))) {
			em.remove(projeto);			
		}
		else
			throw new AtualizacaoException();
	}

	@Override
	public List<Membro> consultarProjetos(String nomeProjeto) {
		String queryProyecto="select m from Membro m JOIN m.projeto p where p.nome=:nomeProyecto";
		
		  return em.createQuery(queryProyecto, Membro.class)
		  		 .setParameter("nomeProjeto", nomeProjeto).getResultList();
	}

	@Override
	public List<Projeto> listarProjetos() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Projeto p", Projeto.class).getResultList();
	}

	@Override
	public Projeto obterProjeto(String nomeProjeto) {
		// TODO Auto-generated method stub
		return em.find(Projeto.class, nomeProjeto);
	}

	@Override
	public void asociarProjeto(String nomeProjeto, String nomeFuncionario) {
		// TODO Auto-generated method stub
		Projeto projeto=em.find(Projeto.class, nomeProjeto);
		Membro membro=em.find(Membro.class, nomeFuncionario);
		
		List<Membro> membros=projeto.getMembros();
		membros.add(membro);
		membro.setProjeto(projeto);
	}	
	
	
}
