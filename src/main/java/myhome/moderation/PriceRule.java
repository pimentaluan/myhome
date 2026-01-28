package myhome.moderation;

import myhome.domain.Anuncio;

public class PriceRule implements ModerationRule {

    @Override
    public void avaliar(Anuncio anuncio, ModerationResult result) {
        double preco = anuncio.getPreco();

        if (preco <= 0) {
            result.setDecision(ModerationDecision.AUTO_REPROVAR);
            result.addMotivo("Preço inválido (<= 0).");
            return;
        }

        if (preco < 1000) {
            result.setDecision(ModerationDecision.MANUAL);
            result.addMotivo("Preço muito baixo, revisar manualmente.");
        }
    }
}