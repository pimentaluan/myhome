package myhome.factory;

import myhome.domain.Casa;
import myhome.domain.Imovel;

public class CasaFactory implements ImovelFactory {

    @Override
    public String tipo() {
        return "CASA";
    }

    @Override
    public Imovel criar(ImovelSpec spec) {
        double area = Double.parseDouble(spec.getOrDefault("area", "0"));
        double preco = Double.parseDouble(spec.getOrDefault("preco", "0"));
        String localizacao = spec.getOrDefault("localizacao", "");
        boolean quintal = Boolean.parseBoolean(spec.getOrDefault("quintal", "false"));
        int quartos = Integer.parseInt(spec.getOrDefault("quartos", "0"));
        return new Casa(area, preco, localizacao, quintal, quartos);
    }
}