package myhome.factory;

import myhome.domain.Imovel;

import java.util.HashMap;
import java.util.Map;

public class ImovelPresetCatalog {
    private final Map<String, Imovel> presets = new HashMap<>();

    public void registrar(String nomePreset, Imovel prototype) {
        presets.put(nomePreset.toUpperCase(), prototype);
    }

    public Imovel criarAPartirDePreset(String nomePreset) {
        Imovel proto = presets.get(nomePreset.toUpperCase());
        if (proto == null) {
            throw new IllegalArgumentException("Preset não encontrado: " + nomePreset);
        }
        return proto.copiar();
    }
}