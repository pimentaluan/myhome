package myhome.domain;

import java.util.UUID;

public class Anuncio {
    private final String id = UUID.randomUUID().toString();
    private final String titulo;
    private final double preco;
    private final Imovel imovel;
    private final Anunciante anunciante;

    private AnuncioStatus status = AnuncioStatus.RASCUNHO;

    public Anuncio(String titulo, double preco, Imovel imovel, Anunciante anunciante) {
        this.titulo = titulo;
        this.preco = preco;
        this.imovel = imovel;
        this.anunciante = anunciante;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public double getPreco() { return preco; }
    public Imovel getImovel() { return imovel; }
    public Anunciante getAnunciante() { return anunciante; }
    public AnuncioStatus getStatus() { return status; }

    public void setStatus(AnuncioStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Anuncio{id=" + id +
                ", titulo='" + titulo + '\'' +
                ", preco=" + preco +
                ", imovel=" + imovel.tipo() + "(" + imovel.resumo() + ")" +
                ", anunciante=" + anunciante.getNome() +
                ", status=" + status +
                '}';
    }
}