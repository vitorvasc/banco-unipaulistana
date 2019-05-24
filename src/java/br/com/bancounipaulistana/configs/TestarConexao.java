package br.com.bancounipaulistana.configs;

public class TestarConexao {
    public static void main(String[] args) {
        ConnectionFactory connect = new ConnectionFactory();
        connect.getConnection();
    }
}
