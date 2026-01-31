package myhome.domain;

public class Casa extends Imovel {
    private final boolean quintal;
    private final int quartos;

    public Casa(double area, double preco, String localizacao, boolean quintal, int quartos) {
        super(area, preco, localizacao);
        this.quintal = quintal;
        this.quartos = quartos;
    }

    public boolean isQuintal() { return quintal; }
    public int getQuartos() { return quartos; }

    @Override public String tipo() { return "CASA"; }

    @Override
    public String resumo() {
        return "quintal=" + quintal + ", quartos=" + quartos;
    }

    @Override
    public Imovel copiar() {
        return new Casa(this.getArea(), this.getPreco(), this.getLocalizacao(), this.quintal, this.quartos);
    }
}
