package myhome.domain;

public class Casa extends Imovel {
    private final boolean quintal;

    public Casa(double area, double preco, boolean quintal) {
        super(area, preco);
        this.quintal = quintal;
    }

    public boolean isQuintal() { return quintal; }

    @Override public String tipo() { return "CASA"; }

    @Override
    public String resumo() {
        return "quintal=" + quintal;
    }

    @Override
    public Imovel copiar() {
        return new Casa(this.area(), this.preco(), this.quintal);
    }
}
