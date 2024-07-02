package Iterator;

import java.util.ArrayList;
import java.util.List;

interface Iterador {
    boolean temProximo();
    Object proximo();
}

class ColecaoLivros {
    private List<String> livros = new ArrayList<>();

    public void adicionarLivro(String livro) {
        livros.add(livro);
    }

    public Iterador criarIterador() {
        return new LivroIterador(livros);
    }

    private class LivroIterador implements Iterador {
        private int indice = 0;
        private List<String> livros;

        public LivroIterador(List<String> livros) {
            this.livros = livros;
        }

        @Override
        public boolean temProximo() {
            return indice < livros.size();
        }

        @Override
        public Object proximo() {
            if (this.temProximo()) {
                return livros.get(indice++);
            }
            return null;
        }
    }
}

public class Iterator {
    public static void main(String[] args) {
        ColecaoLivros colecao = new ColecaoLivros();
        colecao.adicionarLivro("Livro 1");
        colecao.adicionarLivro("Livro 2");
        colecao.adicionarLivro("Livro 3");

        Iterador iterador = colecao.criarIterador();
        while (iterador.temProximo()) {
            System.out.println(iterador.proximo());
        }
    }
}
