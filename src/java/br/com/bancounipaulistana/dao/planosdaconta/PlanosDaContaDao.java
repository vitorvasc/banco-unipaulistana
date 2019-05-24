package br.com.bancounipaulistana.dao.planosdaconta;

import br.com.bancounipaulistana.classes.planosdaconta.PlanosDaConta;
import br.com.bancounipaulistana.classes.planosdeprevidencia.Planos;
import br.com.bancounipaulistana.configs.ConnectionFactory;
import br.com.bancounipaulistana.dao.planosdeprevidencia.PlanosDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vvasc
 */
public class PlanosDaContaDao {

    private final Connection connection;

    public PlanosDaContaDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public List<PlanosDaConta> listarPlanosContratados(int conta) {
        ArrayList<PlanosDaConta> planosContratados = new ArrayList();
        
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from previdencia where titular = ?");
            stmt.setInt(1, conta);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Planos plano = new Planos();
                PlanosDao pDao = new PlanosDao();
                PlanosDaConta pdcDao = new PlanosDaConta();
                plano.setId(rs.getInt("id_plano"));
                
                pdcDao.setId(rs.getInt("id"));
                pdcDao.setDataAquisicao(rs.getString("data_aquisicao"));
                pdcDao.setIdPlano(rs.getInt("id_plano"));
                pdcDao.setNomeDoPlano(pDao.buscarPlano(plano).getNomePlano());
                pdcDao.setPlanoAtivo(rs.getInt("plano_ativo"));
                pdcDao.setTempoLimite(rs.getInt("tempo_limite"));
                pdcDao.setTitular(conta);
                planosContratados.add(pdcDao);
            }
            
            rs.close();
            stmt.close();
            return planosContratados;
                       
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void adquirirPlano(Planos plano, int conta) {
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into previdencia(titular, data_aquisicao, tempo_limite, id_plano, plano_ativo) values (?,?,?,?,?)");
            stmt.setInt(1, conta);
            
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date(); 
            stmt.setString(2, dateFormat.format(data));
            stmt.setInt(3, plano.getTempoLimite());
            stmt.setInt(4, plano.getId());
            stmt.setInt(5, 1);
            
            stmt.execute();
            stmt.close();
            
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }

    }
}
