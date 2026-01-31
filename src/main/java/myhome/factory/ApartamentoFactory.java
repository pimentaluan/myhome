package myhome.factory;

import myhome.domain.Apartamento;
import myhome.domain.Imovel;

public class ApartamentoFactory implements ImovelFactory {

    @Override
    public String tipo() {
        return "APARTAMENTO";
    }

    @Override
    public Imovel criar(ImovelSpec spec) {
        double area = Double.parseDouble(spec.getOrDefault("area", "0"));
        double preco = Double.parseDouble(spec.getOrDefault("preco", "0"));
        int andar = Integer.parseInt(spec.getOrDefault("andar", "0"));
        boolean elevador = Boolean.parseBoolean(spec.getOrDefault("elevador", "false"));
        return new Apartamento(area, preco, andar, elevador);
    }
}
