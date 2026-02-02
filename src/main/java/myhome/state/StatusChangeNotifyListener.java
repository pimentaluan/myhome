package myhome.state;

import java.util.Map;
import java.util.logging.Logger;

import myhome.notification.CanalNotificacao;
import myhome.notification.TelegramService;

public class StatusChangeNotifyListener implements StatusChangeListener {
    private static final Logger log = Logger.getLogger(StatusChangeNotifyListener.class.getName());

    private final Map<String, CanalNotificacao> canais = Map.of(
            "TELEGRAM", new TelegramService());

    @Override
    public void onStatusChanged(StatusChangeEvent event) {
        String mensagem = "Olá " + event.anuncianteNome()
                + ": seu anúncio '" + event.titulo() + "' mudou para " + event.para();

        log.info(() -> "[NOTIF] " + mensagem);
        
        String preferencia = event.preferenciaCanal();
        String destino = event.contatoDestino();

        CanalNotificacao canal = canais.get(preferencia.toUpperCase());

        if (canal != null) {
            canal.enviar(mensagem, destino);
        } else {
            log.warning("Nenhum canal de envio configurado para a preferência: " + preferencia);
        }
    }
}

