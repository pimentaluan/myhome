package myhome.state;

import myhome.domain.AnuncioStatus;

public class RascunhoState implements AnuncioState {

    @Override public AnuncioStatus status() { return AnuncioStatus.RASCUNHO; }

    @Override
    public void submeter(AnuncioContext ctx) {
        ctx.transicionarPara(new ModeracaoState());
    }

    @Override public void aprovar(AnuncioContext ctx) { throw invalido("aprovar"); }
    @Override public void vender(AnuncioContext ctx) { throw invalido("vender"); }
    @Override public void suspender(AnuncioContext ctx) { throw invalido("suspender"); }

    @Override
    public void voltarRascunho(AnuncioContext ctx) {
        throw invalido("voltarRascunho");
    }

    private IllegalStateException invalido(String acao) {
        return new IllegalStateException("Ação '" + acao + "' inválida no estado RASCUNHO");
    }
}
