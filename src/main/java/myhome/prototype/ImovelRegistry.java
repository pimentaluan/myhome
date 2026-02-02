package myhome.prototype;

import java.util.HashMap;
import java.util.Map;

import myhome.domain.Apartamento;
import myhome.domain.Casa;
import myhome.domain.Imovel;

public class ImovelRegistry {
    private final Map<String, Imovel> prototipos = new HashMap<>();

    public ImovelRegistry() {
        prototipos.put("APARTAMENTO_PADRAO", 
            new Apartamento(60.0, 0.0, "A definir", 1, true, 2));


        prototipos.put("CASA_PADRAO", 
            new Casa(120.0, 0.0, "A definir", true, 3));
    }       
    

    public Imovel criarNovo(String chave) {
        Imovel modelo = prototipos.get(chave);
        return (modelo != null) ? modelo.copiar() : null;
    }
}