package myhome.busca;

import java.util.List;
import java.util.stream.Collectors;
import myhome.domain.Anuncio;

public class FiltroAreaMinima extends BuscadorDecorator {
    private final double areaMinima;

    public FiltroAreaMinima(BuscadorAnuncio busca, double areaMinima) {
        super(busca);
        this.areaMinima = areaMinima;
    } 

    @Override 
    public List<Anuncio> buscar(List<Anuncio> anuncios) {
        return super.buscar(anuncios).stream()
                .filter(a -> a.getImovel().getArea() >= areaMinima)
                .collect(Collectors.toList());
    }
}