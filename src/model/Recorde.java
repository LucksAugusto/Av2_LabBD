package model;

public class Recorde {

	private int id;
	private String nomeProva;
	private String recordeTempo;
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
	public String getRecordeTempo() {
		return recordeTempo;
	}
	public void setRecordeTempo(String recordeTempo) {
		this.recordeTempo = recordeTempo;
	}
	public int getRecordeDistancia() {
		return recordeDistancia;
	}
	public void setRecordeDistancia(int recordeDistancia) {
		this.recordeDistancia = recordeDistancia;
	}	
	
}
