package myhome.domain;

public class Apartamento extends Imovel {
    private final int andar;
    private final boolean elevador;
    private final int quartos;

    public Apartamento(double area, double preco, String localizacao, int andar, boolean elevador, int quartos) {
        super(area, preco, localizacao);
        this.andar = andar;
        this.elevador = elevador;
        this.quartos = quartos;
    }

    public int getAndar() { return andar; }
    public boolean isElevador() { return elevador; }
    public int getQuartos() { return quartos; }

    @Override public String tipo() { return "APARTAMENTO"; }

    @Override
    public String resumo() {
        return "andar=" + andar + ", elevador=" + elevador + ", quartos=" + quartos;
    }

    @Override
    public Imovel copiar() {
        return new Apartamento(this.getArea(), this.getPreco(), this.getLocalizacao(), this.andar, this.elevador, this.quartos);
    }
}
