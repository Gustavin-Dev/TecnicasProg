package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controll.*;

public class PlanetaDAO {

	public void inserir(ArrayList<Planetas> planetas, int[] bugsQ, int []devsQ,int arq) {

		String path;
		
				  if (arq==10) {
				path = "AE_10.csv";
			}else if (arq==50) {
				path = "AE_50.csv";
			}else if (arq==100) {
				path = "AE_100.csv";
			}else if (arq==500) {
				path = "AE_500.csv";
			}else if (arq==1000) {
				path = "AE_1000.csv";
			}else if (arq==1500) {
				path = "AE_1500.csv";
			}else if (arq==2000){
				path = "AE_2000.csv";
			}else {
				path = "";
			}
		
		try {

			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = conexao.prepareStatement("insert into javalar "
					+ "(nome, matricula, nome_arquivo, bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, "
					+ "bug_cmais, bug_c, dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp,"
					+ "dev_cmais, dev_c, v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, "
					+ "d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, "
					+ "a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, "
					+ "bug_q1, bug_q2, bug_q3, bug_q4, dev_q1, dev_q2, dev_q3, dev_q4) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			inserir.setString(1, "Gustavo Henrique da Silva");
			inserir.setInt(2, 552428);
			inserir.setString(3,path);

			for (int i = 0; i < planetas.size(); i++) 
				inserir.setInt(i + 4, planetas.get(i).getBugsColididos());
			

			for (int i = 0; i < planetas.size(); i++) 
				inserir.setInt(i + 11, planetas.get(i).getDevsColididos());
			
			
			for (int i = 0; i < planetas.size(); i++) 			
				inserir.setInt(i + 18, planetas.get(i).getVelDeslocamento());
			
			
			for (int i = 0; i < planetas.size(); i++) 
				inserir.setDouble(i + 25, planetas.get(i).getDias());
			
			
			for (int i = 0; i < planetas.size(); i++) 
				inserir.setDouble(i + 32, planetas.get(i).getAnos());
			
			for (int i = 0; i < bugsQ.length; i++) 
				inserir.setInt(i + 39, bugsQ[i]);
			
			for (int i = 0; i < devsQ.length; i++)
				inserir.setInt(i + 43, devsQ[i]);

			
			inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}


	public ArrayList<String[]> LerDados() throws SQLException{
		
		ArrayList<String[]> dados = new ArrayList<String[]>();

		Connection conexao = new Conexao().getConexao();

		try {

			PreparedStatement stmt = conexao.prepareStatement("select * from javalar");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String[] datas = new String[47];

				datas[0] = rs.getString("nome"); //2
				datas[1] = rs.getString("matricula");  //3
				datas[2] = rs.getString("nome_arquivo"); //4
 
				for (int i = 5; i <= 47; i++) {
					datas[i - 2] = String.valueOf(rs.getInt(i));
				}
		
			
				
				dados.add(datas);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return dados;
		
	}
}