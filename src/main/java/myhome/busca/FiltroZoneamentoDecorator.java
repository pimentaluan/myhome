package myhome.busca;
import java.util.List;
import java.util.stream.Collectors;

import myhome.domain.Anuncio;

public class FiltroZoneamentoDecorator extends BuscadorDecorator {
    private final String zonaDesejada;

    public FiltroZoneamentoDecorator(BuscadorAnuncio busca, String zoneamento) {
        super(busca);
        this.zonaDesejada = zoneamento;
    }

    @Override
    public List<Anuncio> buscar(List<Anuncio> anuncios) {
        return super.buscar(anuncios).stream()
                .filter(a -> a.getImovel().getZoneamento().equalsIgnoreCase(zonaDesejada))
                .collect(Collectors.toList());
    }
    
}
