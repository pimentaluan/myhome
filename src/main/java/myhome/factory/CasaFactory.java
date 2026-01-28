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
        boolean quintal = Boolean.parseBoolean(spec.getOrDefault("quintal", "false"));
        return new Casa(quintal);
    }
}