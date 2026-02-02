package myhome.notification;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class TelegramService implements CanalNotificacao {
    private static final Logger log = Logger.getLogger(TelegramService.class.getName());
    private static final String BOT_TOKEN = "8425467554:AAF0Usvc4NpQooWogCK3CcimI0eLM_VabYM";
    private static final String BASE_URL = "https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage";

    @Override
    public void enviar(String mensagem, String destino) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            String json = String.format("{\"chat_id\":\"%s\", \"text\":\"%s\"}",
                    destino,
                    mensagem.replace("\"", "'"));

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                log.warning(() -> "[TELEGRAM] Falha ao enviar: " + response.body());
            }

        } catch (Exception e) {
            log.severe(() -> "Erro crítico no TelegramService: " + e.getMessage());
        }
    }
}