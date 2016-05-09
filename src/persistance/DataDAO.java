package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Atleta;
import model.Nota;
import model.Pais;
import model.Recorde;

public class DataDAO implements IDataDAO {

	public static int numBateria = 1;
	public static int numProva = 1;
	public static int flag = 0;
	
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

	@Override
	public ArrayList<Atleta> carregaAtletas() throws Exception {
		ArrayList<Atleta> atletaList = new ArrayList<Atleta>();
		String SQL = "SELECT * FROM atleta";
		Connection con = DBConnection.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Atleta atleta = new Atleta();
			atleta.setId(rs.getInt(1));
			atleta.setNome(rs.getString(2));
			atleta.setId_prova(rs.getInt(3));
			atleta.setSexo(rs.getString(4).charAt(0));
			atleta.setPais(rs.getString(5));
			atletaList.add(atleta);
		}
		stmt.close();
		rs.close();
		return atletaList;
	}

	@Override
	public ArrayList<Recorde> carregaRecCamp() throws Exception {
		ArrayList<Recorde> recordesCamp = new ArrayList<Recorde>();
		String SQL = "SELECT r.id_recorde_prova, p.nome_prova, r.recorde_prova FROM recorde_prova r "
				+ "INNER JOIN prova p " + "on p.id_prova = r.prova";
		Connection con = DBConnection.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Recorde rec = new Recorde();
			rec.setId(rs.getInt(1));
			rec.setNomeProva(rs.getString(2));
			String aux = rs.getString(3);
			if (aux.contains(":")) {
				SimpleDateFormat d =  new SimpleDateFormat("HH:mm:ss:SSS");
				Date date = d.parse(aux);
				rec.setRecordeTempo(date);
			} else {
				int convert = Integer.parseInt(aux);
				rec.setRecordeDistancia(convert);
			}
			recordesCamp.add(rec);
		}
		stmt.close();
		rs.close();
		return recordesCamp;
	}

	@Override
	public ArrayList<Recorde> carregaRecMundial() throws Exception {
		ArrayList<Recorde> recordesMund = new ArrayList<Recorde>();
		String SQL = "SELECT r.id_recorde_mundi, p.nome_prova, r.recorde_mundial FROM recorde_mundial r "
				+ "INNER JOIN prova p " + "on p.id_prova = r.prova";
		Connection con = DBConnection.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Recorde rec = new Recorde();
			rec.setId(rs.getInt(1));
			rec.setNomeProva(rs.getString(2));
			String aux = rs.getString(3);
			if (aux.contains(":")) {
				SimpleDateFormat d =  new SimpleDateFormat("HH:mm:ss:SSS");
				Date date = d.parse(aux);
				rec.setRecordeTempo(date);
			} else {
				int convert = Integer.parseInt(aux);
				rec.setRecordeDistancia(convert);
			}
			recordesMund.add(rec);
		}
		stmt.close();
		rs.close();
		return recordesMund;
	}

	public ArrayList<Nota> baterias() throws Exception{
		ArrayList<Nota> notas = new ArrayList<Nota>();
		String SQL = "SELECT a.id_atleta, a.nome_completo, a.id_prova, a.sexo, a.nacionalidade, p.nome_prova FROM atleta a "
				+ "INNER JOIN prova p ON p.id_prova = a.id_prova WHERE a.id_prova = ?";
		Connection con = DBConnection.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		stmt.setInt(1, numProva);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Nota n = new Nota();
			n.setId_bat(numBateria);
			n.setProva(numProva);
			n.setNome(rs.getString(2));
			n.setSexo(rs.getString(4));
			n.setPais(rs.getString(5));
			n.setNomeProva(rs.getString(6));
			if(numProva == 1 || numProva == 6 || numProva == 9) {
				n.setN1(String.valueOf(((int)(Math.random()*150)+50)));
				n.setN2(String.valueOf(((int)(Math.random()*150)+50)));
				n.setN3(String.valueOf(((int)(Math.random()*150)+50)));
				n.setN4(String.valueOf(((int)(Math.random()*150)+50)));
				n.setN5(String.valueOf(((int)(Math.random()*150)+50)));
				n.setN6(String.valueOf(((int)(Math.random()*150)+50)));
				int aux = 0;
				if(Integer.parseInt(n.getN1()) >= aux) {
					aux = Integer.parseInt(n.getN1());
				}
				if(Integer.parseInt(n.getN2()) >= aux) {
					aux = Integer.parseInt(n.getN2());
				}
				if(Integer.parseInt(n.getN3()) >= aux) {
					aux = Integer.parseInt(n.getN3());
				}
				if(Integer.parseInt(n.getN4()) >= aux) {
					aux = Integer.parseInt(n.getN4());
				}
				if(Integer.parseInt(n.getN5()) >= aux) {
					aux = Integer.parseInt(n.getN5());
				}
				if(Integer.parseInt(n.getN6()) >= aux) {
					aux = Integer.parseInt(n.getN6());
				}
				n.setM(String.valueOf(aux));
				numBateria = numBateria+1;
			} else if(numProva == 2 || numProva == 3 || numProva == 11) {
				n.setN1(String.valueOf(((int)(Math.random()*30))));
				n.setN2(String.valueOf(((int)(Math.random()*30))));
				n.setN3(String.valueOf(((int)(Math.random()*30))));
				n.setN4(String.valueOf(((int)(Math.random()*30))));
				n.setN5(String.valueOf(((int)(Math.random()*30))));
				n.setN6(String.valueOf(((int)(Math.random()*30))));
				int aux = 0;
				if(Integer.parseInt(n.getN1()) >= aux) {
					aux = Integer.parseInt(n.getN1());
				}
				if(Integer.parseInt(n.getN2()) >= aux) {
					aux = Integer.parseInt(n.getN2());
				}
				if(Integer.parseInt(n.getN3()) >= aux) {
					aux = Integer.parseInt(n.getN3());
				}
				if(Integer.parseInt(n.getN4()) >= aux) {
					aux = Integer.parseInt(n.getN4());
				}
				if(Integer.parseInt(n.getN5()) >= aux) {
					aux = Integer.parseInt(n.getN5());
				}
				if(Integer.parseInt(n.getN6()) >= aux) {
					aux = Integer.parseInt(n.getN6());
				}
				n.setM(String.valueOf(aux));
				numBateria = numBateria+1;
			} else if(numProva == 4 || numProva == 12) {
				String hora = "00";
				String minuto = String.valueOf(((int)(Math.random()*2)));
				String segundo = String.valueOf(((int)(Math.random()*59)));
				String milisegundo = String.valueOf(((int)(Math.random()*250)));
				n.setM(hora + ":"  + minuto + ":" + segundo + ":" + milisegundo);
				flag = flag + 1;
				if(flag == 4) {
					numBateria = numBateria+1;
					flag = 0;
				}
			}  else if(numProva == 5 || numProva == 7 || numProva == 15 || numProva == 16) {
				String hora = "00";
				String minuto = "00";
				String segundo = String.valueOf(((int)(Math.random()*59)));
				String milisegundo = String.valueOf(((int)(Math.random()*250)));
				n.setM(hora + ":"  + minuto + ":" + segundo + ":" + milisegundo);
				flag = flag + 1;
				if(flag == 4) {
					numBateria = numBateria+1;
					flag = 0;
				}
			}  else if(numProva == 8 || numProva == 10) {
				String hora = String.valueOf(((int)(Math.random()*1)));
				String minuto = String.valueOf(((int)(Math.random()*45)));
				String segundo = String.valueOf(((int)(Math.random()*59)));
				String milisegundo = String.valueOf(((int)(Math.random()*250)));
				n.setM(hora + ":"  + minuto + ":" + segundo + ":" + milisegundo);
				flag = flag + 1;
				if(flag == 4) {
					numBateria = numBateria+1;
					flag = 0;
				}
			}  else if(numProva == 13 || numProva == 14) {
				String hora = "00";
				String minuto = String.valueOf(((int)(Math.random()*8)));
				String segundo = String.valueOf(((int)(Math.random()*59)));
				String milisegundo = String.valueOf(((int)(Math.random()*250)));
				n.setM(hora + ":"  + minuto + ":" + segundo + ":" + milisegundo);
				flag = flag + 1;
				if(flag == 4) {
					numBateria = numBateria+1;
					flag = 0;
				}
			}
			notas.add(n);
			SQL = "INSERT INTO classificacao VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, numProva);
			ps.setString(2, n.getNome());
			ps.setString(3, n.getN1());
			ps.setString(4, n.getN2());
			ps.setString(5, n.getN3());
			ps.setString(6, n.getN4());
			ps.setString(7, n.getN5());
			ps.setString(8, n.getN6());
			ps.execute();
			ps.close();
		}
		stmt.close();
		rs.close();
		numProva = numProva + 1;
		return notas;
	}
	
	public ArrayList<Nota> top8() throws Exception{
		ArrayList<Nota> notas = new ArrayList<Nota>();
		String SQL = "SELECT * FROM atleta "
				+ "WHERE id_prova = ?";
		Connection con = DBConnection.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		stmt.setInt(1, numProva);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Nota n = new Nota();
			n.setId_bat(numBateria);
			n.setProva(numProva);
			n.setNome(rs.getString(2));
			if(numProva == 1 || numProva == 6 || numProva == 9) {
				n.setN1(String.valueOf(((int)(Math.random()*150)+50)));
				n.setN2(String.valueOf(((int)(Math.random()*150)+50)));
				n.setN2(String.valueOf(((int)(Math.random()*150)+50)));
				n.setN2(String.valueOf(((int)(Math.random()*150)+50)));
				n.setN2(String.valueOf(((int)(Math.random()*150)+50)));
				n.setN2(String.valueOf(((int)(Math.random()*150)+50)));
				numBateria = numBateria+1;
			} else if(numProva == 2 || numProva == 3 || numProva == 11) {
				n.setN1(String.valueOf(((int)(Math.random()*30))));
				n.setN2(String.valueOf(((int)(Math.random()*30))));
				n.setN3(String.valueOf(((int)(Math.random()*30))));
				n.setN4(String.valueOf(((int)(Math.random()*30))));
				n.setN5(String.valueOf(((int)(Math.random()*30))));
				n.setN6(String.valueOf(((int)(Math.random()*30))));
				numBateria = numBateria+1;
			} else if(numProva == 4 || numProva == 12) {
				String hora = "00";
				String minuto = String.valueOf(((int)(Math.random()*2)));
				String segundo = String.valueOf(((int)(Math.random()*59)));
				String milisegundo = String.valueOf(((int)(Math.random()*250)));
				n.setN1(hora + ":"  + minuto + ":" + segundo + ":" + milisegundo);
				flag = flag + 1;
				if(flag == 4) {
					numBateria = numBateria+1;
					flag = 0;
				}
			}  else if(numProva == 5 || numProva == 7 || numProva == 15 || numProva == 16) {
				String hora = "00";
				String minuto = "00";
				String segundo = String.valueOf(((int)(Math.random()*59)));
				String milisegundo = String.valueOf(((int)(Math.random()*250)));
				n.setN1(hora + ":"  + minuto + ":" + segundo + ":" + milisegundo);
				flag = flag + 1;
				if(flag == 4) {
					numBateria = numBateria+1;
					flag = 0;
				}
			}  else if(numProva == 8 || numProva == 10) {
				String hora = String.valueOf(((int)(Math.random()*1)));
				String minuto = String.valueOf(((int)(Math.random()*45)));
				String segundo = String.valueOf(((int)(Math.random()*59)));
				String milisegundo = String.valueOf(((int)(Math.random()*250)));
				n.setN1(hora + ":"  + minuto + ":" + segundo + ":" + milisegundo);
				flag = flag + 1;
				if(flag == 4) {
					numBateria = numBateria+1;
					flag = 0;
				}
			}  else if(numProva == 13 || numProva == 14) {
				String hora = "00";
				String minuto = String.valueOf(((int)(Math.random()*8)));
				String segundo = String.valueOf(((int)(Math.random()*59)));
				String milisegundo = String.valueOf(((int)(Math.random()*250)));
				n.setN1(hora + ":"  + minuto + ":" + segundo + ":" + milisegundo);
				flag = flag + 1;
				if(flag == 4) {
					numBateria = numBateria+1;
					flag = 0;
				}
			}
			notas.add(n);
			SQL = "INSERT INTO classificacao VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, numProva);
			ps.setString(2, n.getNome());
			ps.setString(3, n.getN1());
			ps.setString(4, n.getN2());
			ps.setString(5, n.getN3());
			ps.setString(6, n.getN4());
			ps.setString(7, n.getN5());
			ps.setString(8, n.getN6());
			ps.execute();
			ps.close();
		}
		stmt.close();
		rs.close();
		numProva = numProva + 1;
		return notas;
	}
	
	public static void main(String[] args) {
		//DataDAO dao = new DataDAO();
		/*try {
			ArrayList<Recorde> listLocal = dao.carregaRecCamp();
			ArrayList<Recorde> listMundial = dao.carregaRecMundial();
			for (Recorde r : listLocal) {
				System.out.println("Recorde: "+ r.getRecordeTempo() + r.getRecordeDistancia());
			}
			for (Recorde r : listMundial) {
				System.out.println("Recorde: "+ r.getRecordeTempo() + r.getRecordeDistancia());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
}
