package myhome.moderation;

import myhome.state.AnuncioContext;

import java.util.logging.Logger;

public class ModerationService {
    private static final Logger log = Logger.getLogger(ModerationService.class.getName());

    private final ModerationChain chain;

    public ModerationService(ModerationChain chain) {
        this.chain = chain;
    }

    public ModerationResult submeterParaModeracao(AnuncioContext ctx) {
        ctx.submeter();

        var result = chain.avaliar(ctx.anuncio());

        switch (result.decision()) {
            case AUTO_APROVAR -> ctx.aprovar();
            case AUTO_REPROVAR -> ctx.suspender();
            case MANUAL -> log.info("Moderacao manual necessária. Mantendo em MODERACAO.");
        }

        return result;
    }
}