package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TesteMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Atleta atleta = new Atleta();
	private List<Atleta> lista_atl = new ArrayList<>();
	
	public void teste() {
		System.out.println("Hello");
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public List<Atleta> getLista_atl() {
		return lista_atl;
	}

	public void setLista_atl(List<Atleta> lista_atl) {
		this.lista_atl = lista_atl;
	}
	
	public void adicionar(Atleta a){
		lista_atl.add(a);
		System.out.println(a.getNome());
	}
}
