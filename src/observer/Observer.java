package observer;

import java.util.ArrayList;
import java.util.List;

interface Observador {
    void atualizar(String mensagem);
}

class Usuario implements Observador {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println(nome + " recebeu: " + mensagem);
    }
}

class Blog {
    private List<Observador> usuarios = new ArrayList<>();

    public void adicionarUsuario(Observador usuario) {
        usuarios.add(usuario);
    }

    public void removerUsuario(Observador usuario) {
        usuarios.remove(usuario);
    }

    public void novaPublicacao(String mensagem) {
        for (Observador usuario : usuarios) {
            usuario.atualizar(mensagem);
        }
    }
}

public class Observer {
    public static void main(String[] args) {
        Blog blog = new Blog();

        Usuario usuario1 = new Usuario("Alice");
        Usuario usuario2 = new Usuario("Bob");

        blog.adicionarUsuario(usuario1);
        blog.adicionarUsuario(usuario2);

        blog.novaPublicacao("Nova postagem no blog!");

        blog.removerUsuario(usuario1);

        blog.novaPublicacao("Outra nova postagem no blog!");
    }
}
