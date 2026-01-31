package myhome.domain;

public class ImovelComercial extends Imovel {
    private final String finalidade;

    public ImovelComercial(double area, double preco, String localizacao, String finalidade) {
        super(area, preco, localizacao);
        this.finalidade = finalidade;
    }

    public String getFinalidade() { return finalidade; }

    @Override public String tipo() { return "IMOVEL_COMERCIAL"; }

    @Override
    public String resumo() {
        return String.format("Área: %.2f, Finalidade: %s", this.getArea(), finalidade);
    }

    @Override
    public Imovel copiar() {
        return new ImovelComercial(this.getArea(), this.getPreco(), this.getLocalizacao(), this.finalidade);
    }
    
}
