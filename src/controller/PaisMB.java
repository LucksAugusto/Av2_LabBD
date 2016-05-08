package controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import model.Pais;
import persistance.DataDAO;

@ManagedBean
public class PaisMB {
	
	private ArrayList<Pais> paisList = new ArrayList<Pais>();
	
	public PaisMB() {
		DataDAO daoPais = new DataDAO();
		try {
			setPaisList(daoPais.carregaPaises());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Pais> getPaisList() {
		return paisList;
	}

	public void setPaisList(ArrayList<Pais> paisList) {
		this.paisList = paisList;
	}
	
}
