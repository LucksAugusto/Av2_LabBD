package controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import model.Atleta;
import persistance.DataDAO;

@ManagedBean
public class AtletaMB {

	private ArrayList<Atleta> atletaList = new ArrayList<Atleta>();

	public AtletaMB() {
		DataDAO daoAtleta = new DataDAO();
		try {
			setAtletaList(daoAtleta.carregaAtletas());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Atleta> getAtletaList() {
		return atletaList;
	}

	public void setAtletaList(ArrayList<Atleta> atletaList) {
		this.atletaList = atletaList;
	}
	
}
