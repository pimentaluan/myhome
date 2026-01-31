package myhome.domain;

public abstract class Imovel {
    private final double area;
    private final double preco;

    public Imovel (double area, double preco) {
        this.area = area;
        this.preco = preco;
    }

    public double area() {
        return area;
    }
    public double preco() {
        return preco;
    }
    public abstract String tipo ();
    public abstract String resumo();
    public abstract Imovel copiar();  
}
