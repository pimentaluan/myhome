package myhome.busca;
import java.util.List;
import java.util.stream.Collectors;

import myhome.domain.Anuncio;

public class FiltroElevadorDecorator extends BuscadorDecorator {
    public FiltroElevadorDecorator(BuscadorAnuncio busca) {
        super(busca);
    }

    @Override
    public List<Anuncio> buscar(List<Anuncio> anuncios) {
        return super.buscar(anuncios).stream()
                .filter(a -> a.getImovel().temElevador())
                .collect(Collectors.toList());
    }
    
}
