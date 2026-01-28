package myhome.moderation;

import myhome.domain.Anuncio;

public class MinTitleLengthRule implements ModerationRule {

    private final int min;

    public MinTitleLengthRule(int min) {
        this.min = min;
    }

    @Override
    public void avaliar(Anuncio anuncio, ModerationResult result) {
        if (anuncio.getTitulo() == null || anuncio.getTitulo().trim().length() < min) {
            result.setDecision(ModerationDecision.MANUAL);
            result.addMotivo("Título curto demais (min " + min + " chars).");
        }
    }
}
