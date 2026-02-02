package myhome.state;

import myhome.domain.Anuncio;
import myhome.domain.AnuncioStatus;

import java.time.Instant;

public class AnuncioContext {
    private final Anuncio anuncio;
    private AnuncioState state;
    private final StatusChangeDispatcher dispatcher;

    public AnuncioContext(Anuncio anuncio, StatusChangeDispatcher dispatcher) {
        this.anuncio = anuncio;
        this.dispatcher = dispatcher;
        this.state = StateFactory.from(anuncio.getStatus());
    }

    public Anuncio anuncio() {
        return anuncio;
    }

    public AnuncioStatus status() {
        return state.status();
    }

    public void submeter() { state.submeter(this); }
    public void aprovar() { state.aprovar(this); }
    public void vender() { state.vender(this); }
    public void suspender() { state.suspender(this); }
    public void voltarRascunho() { state.voltarRascunho(this); }

    void transicionarPara(AnuncioState novo) {
        var de = this.state.status();
        var para = novo.status();

        this.state = novo;
        anuncio.setStatus(para);

        dispatcher.disparar(new StatusChangeEvent(
                anuncio.getId(),
                anuncio.getTitulo(),
                anuncio.getAnunciante().getNome(),
                anuncio.getAnunciante().getContato(),         
                anuncio.getAnunciante().getPreferenciaCanal(),
                de,
                para,
                Instant.now()
        ));
    }
}
