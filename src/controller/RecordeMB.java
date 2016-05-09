package controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import model.Recorde;
import persistance.DataDAO;

@ManagedBean
public class RecordeMB {
	
	private ArrayList<Recorde> recordeList = new ArrayList<Recorde>();

	public RecordeMB() {
		DataDAO daoRecorde = new DataDAO();
		try {
			setRecordeList(daoRecorde.carregaRecMundial());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Recorde> getRecordeList() {
		return recordeList;
	}

	public void setRecordeList(ArrayList<Recorde> recordeList) {
		this.recordeList = recordeList;
	}
}
