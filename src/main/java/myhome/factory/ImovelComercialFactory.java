package myhome.factory;
import myhome.domain.Imovel;
import myhome.domain.ImovelComercial;

public class ImovelComercialFactory implements ImovelFactory {

    @Override
    public String tipo() {
        return "IMOVEL_COMERCIAL";
    }

    @Override
    public Imovel criar(ImovelSpec spec) {
        double area = Double.parseDouble(spec.getOrDefault("area", "0"));
        double preco = Double.parseDouble(spec.getOrDefault("preco", "0"));
        String finalidade = spec.getOrDefault("finalidade", "GERAL");
        return new ImovelComercial(area, preco, finalidade);
    }
    
}
