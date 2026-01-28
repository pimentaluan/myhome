package myhome.state;

import myhome.domain.AnuncioStatus;

public class AtivoState implements AnuncioState {

    @Override public AnuncioStatus status() { return AnuncioStatus.ATIVO; }

    @Override public void submeter(AnuncioContext ctx) { throw invalido("submeter"); }
    @Override public void aprovar(AnuncioContext ctx) { throw invalido("aprovar"); }

    @Override
    public void vender(AnuncioContext ctx) {
        ctx.transicionarPara(new VendidoState());
    }

    @Override
    public void suspender(AnuncioContext ctx) {
        ctx.transicionarPara(new SuspensoState());
    }

    @Override public void voltarRascunho(AnuncioContext ctx) { throw invalido("voltarRascunho"); }

    private IllegalStateException invalido(String acao) {
        return new IllegalStateException("Ação '" + acao + "' inválida no estado ATIVO");
    }
}