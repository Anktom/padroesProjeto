package mediator;

import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
    void enviarMensagem(String mensagem, Usuario usuario);
    void adicionarUsuario(Usuario usuario);
}

class ChatMediatorImpl implements ChatMediator {
    private List<Usuario> usuarios;

    public ChatMediatorImpl() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public void enviarMensagem(String mensagem, Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u != usuario) {
                u.receber(mensagem);
            }
        }
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
}

abstract class Usuario {
    protected ChatMediator mediator;
    protected String nome;

    public Usuario(ChatMediator mediator, String nome) {
        this.mediator = mediator;
        this.nome = nome;
    }

    public abstract void enviar(String mensagem);
    public abstract void receber(String mensagem);
}

class UsuarioImpl extends Usuario {
    public UsuarioImpl(ChatMediator mediator, String nome) {
        super(mediator, nome);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println(this.nome + ": Enviando mensagem = " + mensagem);
        mediator.enviarMensagem(mensagem, this);
    }

    @Override
    public void receber(String mensagem) {
        System.out.println(this.nome + ": Recebendo mensagem = " + mensagem);
    }
}

public class Mediator {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        Usuario usuario1 = new UsuarioImpl(mediator, "João");
        Usuario usuario2 = new UsuarioImpl(mediator, "Maria");
        Usuario usuario3 = new UsuarioImpl(mediator, "Carlos");

        mediator.adicionarUsuario(usuario1);
        mediator.adicionarUsuario(usuario2);
        mediator.adicionarUsuario(usuario3);

        usuario1.enviar("Olá a todos!");
    }
}
