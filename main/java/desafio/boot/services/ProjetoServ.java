package desafio.boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.boot.entidades.Membro;
import desafio.boot.entidades.Projeto;
import desafio.boot.repository.DesafioRepo;

@Service
public class ProjetoServ {
	@Autowired
	private DesafioRepo repositoy;

	public void adicionarProjeto(Projeto projeto) {
		repositoy.adicionarProjeto(projeto);
	}
	
	public void removerProjeto(String nome) {
		repositoy.removerProjeto(nome);
	}
	
	public List<Membro> consultarProjeto(String nome) {
		return repositoy.consultarProjetos(nome);
	}
	
	public void atualizarProjeto(Projeto projeto) {
		repositoy.atualizarProjeto(projeto);
	}
	
	public List<Projeto> listarProjetos(){
		return repositoy.listarProjetos();
	}
	
	public Projeto obterProjeto(String nomeProjeto) {
		return repositoy.obterProjeto(nomeProjeto);
	}
}
