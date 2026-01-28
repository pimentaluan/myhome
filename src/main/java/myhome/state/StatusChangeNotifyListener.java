package myhome.state;

import java.util.logging.Logger;

public class StatusChangeNotifyListener implements StatusChangeListener {
    private static final Logger log = Logger.getLogger(StatusChangeNotifyListener.class.getName());

    @Override
    public void onStatusChanged(StatusChangeEvent event) {
        log.info(() -> "[NOTIF] Para " + event.anuncianteNome()
                + ": seu anúncio '" + event.titulo() + "' mudou para " + event.para());
    }
}
