package composite;

import java.util.ArrayList;
import java.util.List;

interface Arquivo {
    void mostrarDetalhes();
}

class ArquivoSimples implements Arquivo {
    private String nome;

    public ArquivoSimples(String nome) {
        this.nome = nome;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Arquivo: " + nome);
    }
}

class Pasta implements Arquivo {
    private String nome;
    private List<Arquivo> arquivos = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public void adicionar(Arquivo arquivo) {
        arquivos.add(arquivo);
    }

    public void remover(Arquivo arquivo) {
        arquivos.remove(arquivo);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Pasta: " + nome);
        for (Arquivo arquivo : arquivos) {
            arquivo.mostrarDetalhes();
        }
    }
}

public class Composite {
    public static void main(String[] args) {
        Arquivo arquivo1 = new ArquivoSimples("Documento1.txt");
        Arquivo arquivo2 = new ArquivoSimples("Foto1.jpg");
        Arquivo arquivo3 = new ArquivoSimples("Planilha1.xls");

        Pasta pasta1 = new Pasta("Trabalhos");
        pasta1.adicionar(arquivo1);
        pasta1.adicionar(arquivo2);

        Pasta pasta2 = new Pasta("Projetos");
        pasta2.adicionar(arquivo3);

        Pasta pastaPrincipal = new Pasta("Meu Computador");
        pastaPrincipal.adicionar(pasta1);
        pastaPrincipal.adicionar(pasta2);

        pastaPrincipal.mostrarDetalhes();
    }
}

