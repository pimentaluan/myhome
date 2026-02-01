package myhome.busca;
import java.util.List;

import myhome.domain.Anuncio;

//decorator base. possui a ref para objt envolvido 
public abstract class BuscadorDecorator implements BuscadorAnuncio {
    private final BuscadorAnuncio origem;

    public BuscadorDecorator(BuscadorAnuncio busca ) {
        this.origem = busca;
    }
    @Override
    public List<Anuncio> buscar(List<Anuncio> anuncios) {
        return origem.buscar(anuncios);
    }  
}
