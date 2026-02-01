package myhome.busca;
import java.util.List;
import java.util.stream.Collectors;

import myhome.domain.Anuncio;

public class FiltroQuartosDecorator extends BuscadorDecorator {
    private final int quartosMinimos;

    public FiltroQuartosDecorator(BuscadorAnuncio busca, int quartosMinimos) {
        super(busca);
        this.quartosMinimos = quartosMinimos;
    }

    @Override
    public List<Anuncio> buscar(List<Anuncio> anuncios) {
        return super.buscar(anuncios).stream()
                .filter(a -> a.getImovel().getQuartos() >= quartosMinimos)
                .collect(Collectors.toList());
    }
    
}
