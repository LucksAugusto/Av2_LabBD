package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Pais;

public class DataDAO implements IDataDAO{
	
	@Override
	public ArrayList<Pais> carregaPaises() throws Exception {
		ArrayList<Pais> paisList = new ArrayList<Pais>();
		String SQL = "SELECT * FROM pais";
		Connection con = DBConnection.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Pais pais = new Pais();
			pais.setSigla(rs.getString(1));
			pais.setNome(rs.getString(2));
			paisList.add(pais);
		}
		stmt.close();
		rs.close();
		return paisList;
	}

	/*public static void main(String[] args) {
		DataDAO dao = new DataDAO();
		try {
			dao.carregaPaises();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(paisList.size());
		for (int i = 0; i < paisList.size(); i++) {
			System.out.println("oi");
			System.out.println(paisList.get(i).getSigla());
		}
	}*/
}
