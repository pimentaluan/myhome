package myhome.moderation;

import myhome.config.ConfigManager;
import myhome.domain.Anuncio;

public class ProhibitedTermsRule implements ModerationRule {

    @Override
    public void avaliar(Anuncio anuncio, ModerationResult result) {
        var termos = ConfigManager.getInstance().termosProibidos();
        String titulo = anuncio.getTitulo().toLowerCase();

        for (var termo : termos) {
            if (!termo.isBlank() && titulo.contains(termo.toLowerCase())) {
                result.setDecision(ModerationDecision.AUTO_REPROVAR);
                result.addMotivo("Título contém termo proibido: '" + termo + "'");
                return;
            }
        }
    }
}