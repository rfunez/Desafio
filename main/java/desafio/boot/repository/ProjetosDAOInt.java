package desafio.boot.repository;


import java.util.List;

import desafio.boot.entidades.Membro;
import desafio.boot.entidades.Projeto;

public interface ProjetosDAOInt {
	
	void adicionarProjeto(Projeto projeto);
	
	void atualizarProjeto(Projeto projeto);
	
	void removerProjeto(String nomeProjeto);
	
	List<Membro> consultarProjetos(String nomeProjeto);
	
	List<Projeto> listarProjetos();
	
	Projeto obterProjeto(String nomeProjeto);
	
	void asociarProjeto(String nomeProjeto,String nomeFuncionario);

}
