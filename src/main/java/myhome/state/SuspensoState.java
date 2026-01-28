package myhome.state;

import myhome.domain.AnuncioStatus;

public class SuspensoState implements AnuncioState {

    @Override public AnuncioStatus status() { return AnuncioStatus.SUSPENSO; }

    @Override public void submeter(AnuncioContext ctx) { throw invalido("submeter"); }
    @Override public void aprovar(AnuncioContext ctx) { throw invalido("aprovar"); }
    @Override public void vender(AnuncioContext ctx) { throw invalido("vender"); }
    @Override public void suspender(AnuncioContext ctx) { throw invalido("suspender"); }

    @Override
    public void voltarRascunho(AnuncioContext ctx) {
        ctx.transicionarPara(new RascunhoState());
    }

    private IllegalStateException invalido(String acao) {
        return new IllegalStateException("Ação '" + acao + "' inválida no estado SUSPENSO");
    }
}
