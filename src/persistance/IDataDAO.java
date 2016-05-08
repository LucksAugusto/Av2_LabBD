package persistance;

import java.util.ArrayList;

import model.Pais;

public interface IDataDAO {

	public ArrayList<Pais> carregaPaises() throws Exception;
}
