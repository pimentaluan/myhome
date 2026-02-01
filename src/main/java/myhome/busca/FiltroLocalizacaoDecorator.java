package myhome.busca;
import java.util.List;
import java.util.stream.Collectors;
import myhome.domain.Anuncio;

public class FiltroLocalizacaoDecorator extends BuscadorDecorator {
    private final String localizacaoDesejada; 

    public FiltroLocalizacaoDecorator(BuscadorAnuncio busca, String localizacaoDesejada) {
        super(busca);
        this.localizacaoDesejada = localizacaoDesejada.toLowerCase();
    }

    @Override
    public List<Anuncio> buscar(List<Anuncio> anuncios) {
        return super.buscar(anuncios).stream()
        .filter(a -> a.getImovel().getLocalizacao().toLowerCase().contains(localizacaoDesejada))
        .collect(Collectors.toList());
    }
}
