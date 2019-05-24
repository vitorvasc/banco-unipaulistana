package br.com.bancounipaulistana.dao.planosdeprevidencia;

import br.com.bancounipaulistana.classes.planosdeprevidencia.Planos;
import br.com.bancounipaulistana.configs.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanosDao {
    
    private final Connection connection;
    
    public PlanosDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public List<Planos> planosDisponiveis() {
        ArrayList<Planos> planos = new ArrayList();
        
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from previdencia_planos");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Planos plano = new Planos();
                plano.setId(rs.getInt("id"));
                plano.setNomePlano(rs.getString("nome_plano"));
                plano.setDescPlano(rs.getString("desc_plano"));
                plano.setTempoLimite(rs.getInt("tempo_limite"));
                planos.add(plano);
            }
            rs.close();
            stmt.close();
            return planos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public Planos buscarPlano(Planos plano){
        
        try {       
            Planos planos = new Planos();
          
            PreparedStatement stmt = connection.prepareStatement("select * from previdencia_planos where id = ?");
            stmt.setInt(1, plano.getId());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                planos.setId(rs.getInt("id"));
                planos.setNomePlano(rs.getString("nome_plano"));
                planos.setDescPlano(rs.getString("desc_plano"));
                planos.setTempoLimite(rs.getInt("tempo_limite"));
            }
            rs.close();
            stmt.close();
            return planos;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public int getPlanoTempoLimite(String numeroDoPlano) {
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from previdencia_planos where id = ?");
            System.out.println(stmt);
            stmt.setString(1, numeroDoPlano);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                return rs.getInt("tempo_limite");
            }
            
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
