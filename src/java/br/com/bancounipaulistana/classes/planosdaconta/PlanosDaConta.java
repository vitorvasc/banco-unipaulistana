package br.com.bancounipaulistana.classes.planosdaconta;

public class PlanosDaConta {
    private int id;
    private int titular;
    private String dataAquisicao;
    private int tempoLimite;
    private int idPlano;
    private int planoAtivo;
    private String nomeDoPlano;

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getNomeDoPlano() {
        return nomeDoPlano;
    }

    public void setNomeDoPlano(String nomeDoPlano) {
        this.nomeDoPlano = nomeDoPlano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTitular() {
        return titular;
    }

    public void setTitular(int titular) {
        this.titular = titular;
    }

    public int getTempoLimite() {
        return tempoLimite;
    }

    public void setTempoLimite(int tempoLimite) {
        this.tempoLimite = tempoLimite;
    }

    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public int getPlanoAtivo() {
        return planoAtivo;
    }

    public void setPlanoAtivo(int planoAtivo) {
        this.planoAtivo = planoAtivo;
    }
    
    
}
