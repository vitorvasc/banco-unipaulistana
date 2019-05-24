package br.com.bancounipaulistana.classes.planosdeprevidencia;

/**
 *
 * @author vvasc
 */
public class Planos {
    private int id;
    private String nomePlano;
    private String descPlano;
    private int tempoLimite;

    public int getTempoLimite() {
        return tempoLimite;
    }

    public void setTempoLimite(int tempoLimite) {
        this.tempoLimite = tempoLimite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public String getDescPlano() {
        return descPlano;
    }

    public void setDescPlano(String descPlano) {
        this.descPlano = descPlano;
    }
    
    
}
