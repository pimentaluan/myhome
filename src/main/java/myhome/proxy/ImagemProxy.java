package myhome.proxy;

public class ImagemProxy implements Imagem {
    private ImagemReal imagemReal; 
    private String nomeArquivo;

    public ImagemProxy(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        
    }

    @Override
    public void exibir() {
        
        if (imagemReal == null) {
            System.out.println("[PROXY] -> Objeto real não existe. Criando agora...");
            imagemReal = new ImagemReal(nomeArquivo);
        }
        imagemReal.exibir();
    }
}