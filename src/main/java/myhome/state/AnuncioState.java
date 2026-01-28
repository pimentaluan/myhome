package myhome.state;

import myhome.domain.AnuncioStatus;

public interface AnuncioState {
    AnuncioStatus status();

    void submeter(AnuncioContext ctx);
    void aprovar(AnuncioContext ctx);
    void vender(AnuncioContext ctx);
    void suspender(AnuncioContext ctx);
    void voltarRascunho(AnuncioContext ctx);
}
