package myhome.moderation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModerationResult {
    private ModerationDecision decision = ModerationDecision.AUTO_APROVAR;
    private final List<String> motivos = new ArrayList<>();

    public ModerationDecision decision() { return decision; }
    public List<String> motivos() { return Collections.unmodifiableList(motivos); }

    public void setDecision(ModerationDecision decision) {
        if (this.decision == ModerationDecision.AUTO_REPROVAR) return;

        if (this.decision == ModerationDecision.MANUAL && decision == ModerationDecision.AUTO_APROVAR) return;

        this.decision = decision;
    }

    public void addMotivo(String motivo) {
        motivos.add(motivo);
    }
}