package myhome.config;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public final class ConfigManager {
    private static volatile ConfigManager instance;
    private final Properties props = new Properties();

    private ConfigManager() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) throw new IllegalStateException("config.properties não encontrado em resources");
            props.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao carregar config.properties", e);
        }
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) instance = new ConfigManager();
            }
        }
        return instance;
    }

    public double taxaComissao() {
        return Double.parseDouble(props.getProperty("taxa.comissao", "0.0"));
    }

    public int limiteUploadFotos() {
        return Integer.parseInt(props.getProperty("limite.upload.fotos", "0"));
    }

    public List<String> termosProibidos() {
        String raw = props.getProperty("termos.proibidos", "");
        if (raw.isBlank()) return List.of();
        return Arrays.stream(raw.split(";"))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .toList();
    }
}
