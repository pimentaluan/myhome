package myhome.domain;

public class Terreno extends Imovel {
    private final String zoneamento;

    public Terreno(double area, double preco, String localizacao, String zoneamento) {
        super(area, preco, localizacao);
        this.zoneamento = zoneamento;
    }

    public String getZoneamento() { return zoneamento; }

    @Override public String tipo() { return "TERRENO"; }

    @Override
    public String resumo() {
        return String.format("Área: %.2f, Zoneamento: %s", this.getArea(), zoneamento);
    }

    @Override
    public Imovel copiar() {
        return new Terreno(this.getArea(), this.getPreco(), this.getLocalizacao(), this.zoneamento);
    }
}
