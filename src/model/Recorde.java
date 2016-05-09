package model;

import java.util.Date;

public class Recorde {

	private int id;
	private String nomeProva;
	private Date recordeTempo;
	private int recordeDistancia;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeProva() {
		return nomeProva;
	}
	public void setNomeProva(String nomeProva) {
		this.nomeProva = nomeProva;
	}
	public Date getRecordeTempo() {
		return recordeTempo;
	}
	public void setRecordeTempo(Date recordeTempo) {
		this.recordeTempo = recordeTempo;
	}
	public int getRecordeDistancia() {
		return recordeDistancia;
	}
	public void setRecordeDistancia(int recordeDistancia) {
		this.recordeDistancia = recordeDistancia;
	}	
	
}
