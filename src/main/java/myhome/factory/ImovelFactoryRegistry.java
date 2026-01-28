package myhome.factory;

import myhome.domain.Imovel;

import java.util.HashMap;
import java.util.Map;

public class ImovelFactoryRegistry {
    private final Map<String, ImovelFactory> factories = new HashMap<>();

    public void registrar(ImovelFactory factory) {
        factories.put(factory.tipo().toUpperCase(), factory);
    }

    public Imovel criar(ImovelSpec spec) {
        String key = spec.tipo().toUpperCase();
        ImovelFactory factory = factories.get(key);
        if (factory == null) {
            throw new IllegalArgumentException("Tipo de imóvel não suportado: " + spec.tipo());
        }
        return factory.criar(spec);
    }
}
