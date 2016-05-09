package persistance;

import java.util.ArrayList;

import model.Atleta;
import model.Pais;
import model.Recorde;

public interface IDataDAO {

	public ArrayList<Pais> carregaPaises() throws Exception;
	public ArrayList<Atleta> carregaAtletas() throws Exception;
	public ArrayList<Recorde> carregaRecCamp() throws Exception;
	public ArrayList<Recorde> carregaRecMundial() throws Exception;
}
