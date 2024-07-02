package prototype;

interface Documento extends Cloneable {
    Documento clonar();
    void exibir();
}

class Relatorio implements Documento {
    private String conteudo;

    public Relatorio(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public Documento clonar() {
        return new Relatorio(conteudo);
    }

    @Override
    public void exibir() {
        System.out.println("Relatório: " + conteudo);
    }
}

class Certificado implements Documento {
    private String nome;

    public Certificado(String nome) {
        this.nome = nome;
    }

    @Override
    public Documento clonar() {
        return new Certificado(nome);
    }

    @Override
    public void exibir() {
        System.out.println("Certificado: " + nome);
    }
}

public class Prototype {
    public static void main(String[] args) {
        Documento relatorio1 = new Relatorio("Relatório Anual");
        Documento relatorio2 = relatorio1.clonar();

        Documento certificado1 = new Certificado("Curso de Java");
        Documento certificado2 = certificado1.clonar();

        relatorio1.exibir();
        relatorio2.exibir();

        certificado1.exibir();
        certificado2.exibir();
    }
}
