package myhome.domain;

public class Anunciante extends Usuario {
    private String contato;      
    private String preferenciaCanal;   

    public Anunciante(String nome, String contato, String preferencia) {
        super(nome);
        this.contato = contato;
        this.preferenciaCanal = preferencia;
    }

    public String getContato() { return contato; }
    public String getPreferenciaCanal() { return preferenciaCanal; }
}