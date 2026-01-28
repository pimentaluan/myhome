package myhome.state;

import java.util.logging.Logger;

public class StatusChangeLogListener implements StatusChangeListener {
    private static final Logger log = Logger.getLogger(StatusChangeLogListener.class.getName());

    @Override
    public void onStatusChanged(StatusChangeEvent event) {
        log.info(() -> "[LOG] Anuncio " + event.anuncioId()
                + " '" + event.titulo() + "' (" + event.anuncianteNome() + ") "
                + event.de() + " -> " + event.para()
                + " em " + event.em());
    }
}
