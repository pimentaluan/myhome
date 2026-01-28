package myhome.state;

import myhome.domain.AnuncioStatus;

public class ModeracaoState implements AnuncioState {

    @Override public AnuncioStatus status() { return AnuncioStatus.MODERACAO; }

    @Override public void submeter(AnuncioContext ctx) { throw invalido("submeter"); }

    @Override
    public void aprovar(AnuncioContext ctx) {
        ctx.transicionarPara(new AtivoState());
    }

    @Override public void vender(AnuncioContext ctx) { throw invalido("vender"); }

    @Override
    public void suspender(AnuncioContext ctx) {
        ctx.transicionarPara(new SuspensoState());
    }

    @Override
    public void voltarRascunho(AnuncioContext ctx) {
        ctx.transicionarPara(new RascunhoState());
    }

    private IllegalStateException invalido(String acao) {
        return new IllegalStateException("Ação '" + acao + "' inválida no estado MODERACAO");
    }
}