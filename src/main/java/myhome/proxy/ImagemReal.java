package myhome.proxy;

// Objeto Real: Simula o carregamento de um arquivo de alta resolução
public class ImagemReal implements Imagem {
    private String nomeArquivo;

    public ImagemReal(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        carregarDoDisco();
    }

    private void carregarDoDisco() {
        // Simulando um delay ou consumo de recurso
        // Em um sistema real, aqui abriríamos o stream do arquivo
        System.out.println("[SISTEMA] -> Carregando arquivo pesado: " + nomeArquivo);
    }

    @Override
    public void exibir() {
        System.out.println("[DISPLAY] -> Exibindo imagem: " + nomeArquivo);
    }
}