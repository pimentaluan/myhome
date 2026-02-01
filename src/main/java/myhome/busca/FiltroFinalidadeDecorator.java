package myhome.busca;
import java.util.List;
import java.util.stream.Collectors;

import myhome.domain.Anuncio;

public class FiltroFinalidadeDecorator extends BuscadorDecorator {
    private final String finalidadeDesejada;

    public FiltroFinalidadeDecorator(BuscadorAnuncio busca, String finalidadeDesejada) {
        super(busca);
        this.finalidadeDesejada = finalidadeDesejada;
    }
    @Override
    public List<Anuncio> buscar(List<Anuncio> anuncios) {
        return super.buscar(anuncios).stream()
                .filter(a -> a.getImovel().getFinalidade().equalsIgnoreCase(finalidadeDesejada))
                .collect(Collectors.toList());
    }
    
}
