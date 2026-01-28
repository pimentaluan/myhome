package myhome.factory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImovelSpec {
    private final String tipo;
    private final Map<String, String> dados;

    public ImovelSpec(String tipo, Map<String, String> dados) {
        this.tipo = tipo;
        this.dados = new HashMap<>(dados);
    }

    public String tipo() {
        return tipo;
    }

    public Map<String, String> dados() {
        return Collections.unmodifiableMap(dados);
    }

    public String get(String chave) {
        return dados.get(chave);
    }

    public String getOrDefault(String chave, String valorPadrao) {
        return dados.getOrDefault(chave, valorPadrao);
    }
}
