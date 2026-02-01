package myhome.busca;
import java.util.List;
import java.util.stream.Collectors;

import myhome.domain.Anuncio;

public class FiltroPrecoDecorator extends BuscadorDecorator {
    private final double precoMaximo;

    public FiltroPrecoDecorator(BuscadorAnuncio busca, double precoMaximo) {
        super(busca);
        this.precoMaximo = precoMaximo;
    }
    
    @Override
    public List<Anuncio> buscar(List<Anuncio> anuncios) {
        List<Anuncio> listaFiltro = super.buscar(anuncios);

        return listaFiltro.stream()
                .filter(a -> a.getPreco() <= precoMaximo)
                .collect(Collectors.toList());
    }
}