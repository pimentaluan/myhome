package myhome.domain;

import java.util.UUID;

public class Anuncio {
    private final String id = UUID.randomUUID().toString();
    private final String titulo;
    private final Imovel imovel;
    private final Anunciante anunciante;

    private AnuncioStatus status = AnuncioStatus.RASCUNHO;

    public Anuncio(String titulo, Imovel imovel, Anunciante anunciante) {
        this.titulo = titulo;
        this.imovel = imovel;
        this.anunciante = anunciante;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public double getPreco() { return imovel.preco(); }
    public Imovel getImovel() { return imovel; }
    public Anunciante getAnunciante() { return anunciante; }
    public AnuncioStatus getStatus() { return status; }

    public void setStatus(AnuncioStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Anuncio{\n id=" + id +
                ",\n titulo='" + titulo + '\'' +
                ",\n preco=" + getPreco() +
                ",\n imovel=" + imovel.tipo() +
                "(área=" +imovel.area() + ", " + imovel.resumo() + ")" +
                ",\n anunciante=" + anunciante.getNome() +
                ",\n status=" + status +
                "\n} " +
                "\n--------------------------------------------";
    }
}