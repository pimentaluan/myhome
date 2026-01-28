package myhome.state;

import myhome.domain.AnuncioStatus;

public class VendidoState implements AnuncioState {

    @Override public AnuncioStatus status() { return AnuncioStatus.VENDIDO; }

    @Override public void submeter(AnuncioContext ctx) { throw invalido("submeter"); }
    @Override public void aprovar(AnuncioContext ctx) { throw invalido("aprovar"); }
    @Override public void vender(AnuncioContext ctx) { throw invalido("vender"); }
    @Override public void suspender(AnuncioContext ctx) { throw invalido("suspender"); }
    @Override public void voltarRascunho(AnuncioContext ctx) { throw invalido("voltarRascunho"); }

    private IllegalStateException invalido(String acao) {
        return new IllegalStateException("Ação '" + acao + "' inválida no estado VENDIDO");
    }
}