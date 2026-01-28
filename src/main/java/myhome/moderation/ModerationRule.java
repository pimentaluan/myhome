package myhome.moderation;

import myhome.domain.Anuncio;

public interface ModerationRule {
    void avaliar(Anuncio anuncio, ModerationResult result);
}