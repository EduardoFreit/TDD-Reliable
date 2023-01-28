package main.java.entidades;

public class Usuario {
	
	private String nome; // max 50 carac
	private Integer idade; // idade máximo 18
	private String cpf; // cpf válido
	
	
	public Usuario(String nome, Integer idade, String cpf) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
