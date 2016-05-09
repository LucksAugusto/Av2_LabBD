package controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import model.Nota;
import persistance.DataDAO;

@ManagedBean
public class NotaMB {
	
	private ArrayList<Nota> notaList = new ArrayList<Nota>();
	public static ArrayList<Nota> notaLista = new ArrayList<Nota>();
	
	public void simula() {
		DataDAO dao = new DataDAO();
		try {
			setNotaList(dao.baterias());
			for (Nota nota : notaList) {
				notaLista.add(nota);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Nota> getNotaList() {
		return notaList;
	}

	public void setNotaList(ArrayList<Nota> notaList) {
		this.notaList = notaList;
	}
	public ArrayList<Nota> getNotaLista() {
		return notaLista;
	}

	public void setNotaLista(ArrayList<Nota> notaList) {
		this.notaList = notaLista;
	}
}
