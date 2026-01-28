package myhome.repository;

import myhome.domain.Anuncio;

import java.util.*;

public class AnuncioRepository {
    private final Map<String, Anuncio> store = new LinkedHashMap<>();

    public void salvar(Anuncio a) {
        store.put(a.getId(), a);
    }

    public Optional<Anuncio> porId(String id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Anuncio> listarTodos() {
        return new ArrayList<>(store.values());
    }
}