package memento;

class Texto {
    private String conteudo;

    public void escrever(String texto) {
        conteudo = texto;
    }

    public TextoMemento salvar() {
        return new TextoMemento(conteudo);
    }

    public void restaurar(TextoMemento memento) {
        conteudo = memento.getConteudo();
    }

    public String ler() {
        return conteudo;
    }
}

class TextoMemento {
    private final String conteudo;

    public TextoMemento(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }
}

public class Memento {
    public static void main(String[] args) {
        Texto texto = new Texto();
        texto.escrever("Versão 1");
        TextoMemento memento1 = texto.salvar();

        texto.escrever("Versão 2");
        TextoMemento memento2 = texto.salvar();

        texto.escrever("Versão 3");

        System.out.println("Estado atual: " + texto.ler());

        texto.restaurar(memento1);
        System.out.println("Estado restaurado para Versão 1: " + texto.ler());

        texto.restaurar(memento2);
        System.out.println("Estado restaurado para Versão 2: " + texto.ler());
    }
}
