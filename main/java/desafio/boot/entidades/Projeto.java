package desafio.boot.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROJETOS")
public class Projeto {
	@Id
	@Column(name = "NOME_PROJETO")
	private String nome;
	
	@Column(name = "DATA_INI")
	private Date dataInicio;
	
	private String gerente;
	
	@Column(name = "DURACAO")
	private int prevTermino;
	
	@Column(name = "DATA_FIM")
	private Date dataTermino;
	
	private BigDecimal orcamento;
	
	private String descricao;
	
	private String status;
	
	@OneToMany(mappedBy = "projeto")
	private List<Membro> membros;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	public int getPrevTermino() {
		return prevTermino;
	}

	public void setPrevTermino(int prevTermino) {
		this.prevTermino = prevTermino;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public BigDecimal getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(BigDecimal orcamento) {
		this.orcamento = orcamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Membro> getMembros() {
		return membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}
}
