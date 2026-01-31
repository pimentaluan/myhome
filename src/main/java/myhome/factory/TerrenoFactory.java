package myhome.factory;

import myhome.domain.Imovel;
import myhome.domain.Terreno;

public class TerrenoFactory implements ImovelFactory {

    @Override
    public String tipo() {
        return "TERRENO";
    }

    @Override
    public Imovel criar(ImovelSpec spec) {
        double area = Double.parseDouble(spec.getOrDefault("area", "0"));
        double preco = Double.parseDouble(spec.getOrDefault("preco", "0"));
        String localizacao = spec.getOrDefault("localizacao", "");
        String zoneamento = spec.getOrDefault("zoneamento", "RESIDENCIAL");
        return new Terreno(area, preco, localizacao, zoneamento);
    }
    
}
