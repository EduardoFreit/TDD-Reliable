package main.java.entidades;

public class Servico {
	
	private Integer id;
	private String nome;
	private String categoria;
	private Double valor;
	private String disponibilidade;
	private String restricoes;
	private String diferenciais;
	
	public Servico() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getRestricoes() {
		return restricoes;
	}

	public void setRestricoes(String restricoes) {
		this.restricoes = restricoes;
	}

	public String getDiferenciais() {
		return diferenciais;
	}

	public void setDiferenciais(String diferenciais) {
		this.diferenciais = diferenciais;
	}
	
}
