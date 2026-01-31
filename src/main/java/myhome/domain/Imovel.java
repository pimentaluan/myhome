package myhome.domain;

public abstract class Imovel {
    private final double area;
    private final double preco;
    private final String localizacao;

    public Imovel (double area, double preco, String localizacao) {
        this.area = area;
        this.preco = preco;
        this.localizacao = localizacao;
    }

    public double getArea() {
        return area;
    }
    public double getPreco() {
        return preco;
    }
    public String getLocalizacao() {
        return localizacao;
    }

    public abstract String tipo ();
    public abstract String resumo();
    public abstract Imovel copiar();  
}
