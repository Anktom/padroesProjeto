package proxy;

interface Imagem {
    void exibir();
}

class ImagemReal implements Imagem {
    private String nomeArquivo;

    public ImagemReal(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        carregarImagem(nomeArquivo);
    }

    private void carregarImagem(String nomeArquivo) {
        System.out.println("Carregando " + nomeArquivo);
    }

    @Override
    public void exibir() {
        System.out.println("Exibindo " + nomeArquivo);
    }
}

class ProxyImagem implements Imagem {
    private ImagemReal imagemReal;
    private String nomeArquivo;

    public ProxyImagem(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void exibir() {
        if (imagemReal == null) {
            imagemReal = new ImagemReal(nomeArquivo);
        }
        imagemReal.exibir();
    }
}

public class Proxy {
    public static void main(String[] args) {
        Imagem imagem = new ProxyImagem("foto.jpg");

        // Imagem será carregada e exibida
        imagem.exibir();

        // Imagem não será carregada novamente
        imagem.exibir();
    }
}
