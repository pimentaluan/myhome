package myhome.domain;

public class Apartamento extends Imovel {
    private final int andar;
    private final boolean elevador;

    public Apartamento(double area, double preco, int andar, boolean elevador) {
        super(area, preco);
        this.andar = andar;
        this.elevador = elevador;
    }

    public int getAndar() { return andar; }
    public boolean isElevador() { return elevador; }

    @Override public String tipo() { return "APARTAMENTO"; }

    @Override
    public String resumo() {
        return "andar=" + andar + ", elevador=" + elevador;
    }

    @Override
    public Imovel copiar() {
        return new Apartamento(this.area(), this.preco(), this.andar, this.elevador);
    }
}
