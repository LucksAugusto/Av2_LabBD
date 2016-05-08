package model;

public class Atleta {
	private int id;
	private String nome;
	private int id_prova;
	private char sexo;
	private String pais;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId_prova() {
		return id_prova;
	}
	public void setId_prova(int id_prova) {
		this.id_prova = id_prova;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

}
