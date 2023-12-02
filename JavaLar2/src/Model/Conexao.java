package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String host;
    private String user;
    private String password;
    private String Database;

    public Conexao() {
        this.host = "da_java.mysql.dbaas.com.br";
        this.Database = "da_java";
        this.user = "da_java";
        this.password = "Tecnicas*2023@";

        // Carregando o driver MySQL JDBC
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL JDBC não encontrado");
            e.printStackTrace();
        }
    }

    public Connection getConexao() throws SQLException {
        String url = "jdbc:mysql://" + this.host + "/" + this.Database + "?enabledTLSProtocols=TLSv1.2&verifyServerCertificate=false&useSSL=true";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Falha na conexão com o MySQL");
            throw ex;
        }
    }
}
