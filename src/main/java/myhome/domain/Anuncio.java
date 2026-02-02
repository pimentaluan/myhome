package myhome.domain;

import java.util.UUID;

import myhome.proxy.Imagem;

public class Anuncio {
    private final String id = UUID.randomUUID().toString();
    private final String titulo;
    private final Imovel imovel;
    private final Anunciante anunciante;

    private AnuncioStatus status = AnuncioStatus.RASCUNHO;

    private Imagem foto;

    public Anuncio(String titulo, Imovel imovel, Anunciante anunciante) {
        this.titulo = titulo;
        this.imovel = imovel;
        this.anunciante = anunciante;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public double getPreco() { return imovel.getPreco(); }
    public Imovel getImovel() { return imovel; }
    public Anunciante getAnunciante() { return anunciante; }
    public AnuncioStatus getStatus() { return status; }
    public Imagem getFoto() { return foto; }
    public void setFoto(Imagem foto) { this.foto = foto; }

    public void setStatus(AnuncioStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String temFoto = (foto != null) ? "Sim" : "Não";
        return "Anuncio{\n id=" + id +
                ",\n titulo='" + titulo + '\'' +
                ",\n preco=" + getPreco() +
                ",\n localizacao=" + imovel.getLocalizacao() +
                ",\n imovel=" + imovel.tipo() +
                "(área=" +imovel.getArea() + ", " + imovel.resumo() + ")" +
                ",\n anunciante=" + anunciante.getNome() +
                ",\n status=" + status +
                ",\n possuiFoto=" + temFoto +
                "\n} " +
                "\n--------------------------------------------";
    }
}