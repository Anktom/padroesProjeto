package command;

interface Comando {
    void executar();
}

class Luz {
    public void ligar() {
        System.out.println("Luz ligada.");
    }

    public void desligar() {
        System.out.println("Luz desligada.");
    }
}

class ComandoLigarLuz implements Comando {
    private Luz luz;

    public ComandoLigarLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void executar() {
        luz.ligar();
    }
}

class ComandoDesligarLuz implements Comando {
    private Luz luz;

    public ComandoDesligarLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void executar() {
        luz.desligar();
    }
}

class ControleRemoto {
    private Comando comando;

    public void setComando(Comando comando) {
        this.comando = comando;
    }

    public void pressionarBotao() {
        comando.executar();
    }
}

public class Command {
    public static void main(String[] args) {
        Luz luz = new Luz();
        Comando ligar = new ComandoLigarLuz(luz);
        Comando desligar = new ComandoDesligarLuz(luz);

        ControleRemoto controle = new ControleRemoto();

        controle.setComando(ligar);
        controle.pressionarBotao();

        controle.setComando(desligar);
        controle.pressionarBotao();
    }
}
