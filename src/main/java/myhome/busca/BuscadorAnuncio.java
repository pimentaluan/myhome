package myhome.busca;
import java.util.List;

import myhome.domain.Anuncio;

public interface BuscadorAnuncio {
    List<Anuncio> buscar(List <Anuncio> anuncios);
    
}
