package br.com.bancounipaulistana.dao.conta;

import br.com.bancounipaulistana.classes.conta.Conta;
import br.com.bancounipaulistana.configs.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDao {

    private final Connection connection;

    public ContaDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean validaContas(Conta conta) {
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from contas where numerodaconta = ? and senha = ?");
            stmt.setInt(1, conta.getConta());
            stmt.setString(2, conta.getSenha());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return false;
    }

    public String getNomeCompleto(int numeroDaConta) {
        try {
            String nomeCompleto = "";

            PreparedStatement stmt = connection.prepareStatement("select nomecompleto from contas where numerodaconta = ?");
            stmt.setInt(1, numeroDaConta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                nomeCompleto = rs.getString(1);
            }
            rs.close();
            stmt.close();
            return nomeCompleto;
        } catch (Exception e) {
            System.out.println("Erro de exibição");
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }

    public double getSaldo(int numeroDaConta) {
        try {
            double saldo = 0.0;

            PreparedStatement stmt = connection.prepareStatement("select saldo from contas where numerodaconta = ?");
            stmt.setInt(1, numeroDaConta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                saldo = rs.getDouble(1);
            }
            rs.close();
            stmt.close();
            return saldo;
        } catch (Exception e) {
            System.out.println("Erro de exibição");
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }
}
