package myhome.domain;

public class Casa implements Imovel {
    private final boolean quintal;

    public Casa(boolean quintal) {
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
        return new Casa(this.quintal);
    }
}
