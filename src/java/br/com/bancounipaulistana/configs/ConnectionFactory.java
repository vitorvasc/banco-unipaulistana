package br.com.bancounipaulistana.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bancounipaulistana", "root", "");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro de conexão com o banco de dados.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
