package myhome.moderation;

import myhome.domain.Anuncio;

import java.util.ArrayList;
import java.util.List;

public class ModerationChain {
    private final List<ModerationRule> rules = new ArrayList<>();

    public ModerationChain adicionar(ModerationRule rule) {
        rules.add(rule);
        return this;
    }

    public ModerationResult avaliar(Anuncio anuncio) {
        ModerationResult result = new ModerationResult();
        for (var rule : rules) {
            rule.avaliar(anuncio, result);

            if (result.decision() == ModerationDecision.AUTO_REPROVAR) break;
        }
        return result;
    }
}