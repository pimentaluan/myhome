package myhome.state;

import myhome.domain.AnuncioStatus;

public final class StateFactory {
    private StateFactory() {}

    public static AnuncioState from(AnuncioStatus status) {
        return switch (status) {
            case RASCUNHO -> new RascunhoState();
            case MODERACAO -> new ModeracaoState();
            case ATIVO -> new AtivoState();
            case VENDIDO -> new VendidoState();
            case SUSPENSO -> new SuspensoState();
        };
    }
}
