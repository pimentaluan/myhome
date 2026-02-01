package myhome.busca;
import java.util.ArrayList;
import java.util.List;

import myhome.domain.Anuncio;

//componente concreto: define comportamento basico -devolver a lista-
public class BuscadorPadrao implements BuscadorAnuncio {
    @Override 
    public List<Anuncio> buscar(List<Anuncio> anuncios) {
        return new ArrayList<>(anuncios);
    }
} 
    
