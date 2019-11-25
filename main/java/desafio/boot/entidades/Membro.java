package desafio.boot.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBROS")
public class Membro {
	@Id
	@Column(name = "NOME_MEMBRO")
	private String nome;
	
	private String cargo;
	
	@ManyToOne
	@JoinColumn(name = "NOME_PROJETO",referencedColumnName = "NOME_PROJETO")
	private Projeto projeto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}
