package template;

abstract class Jogo {
    abstract void iniciar();
    abstract void jogar();
    abstract void finalizar();

    // Template method
    public final void jogarJogo() {
        iniciar();
        jogar();
        finalizar();
    }
}

class Xadrez extends Jogo {
    @Override
    void iniciar() {
        System.out.println("Xadrez iniciado!");
    }

    @Override
    void jogar() {
        System.out.println("Jogando Xadrez...");
    }

    @Override
    void finalizar() {
        System.out.println("Xadrez finalizado!");
    }
}

class Futebol extends Jogo {
    @Override
    void iniciar() {
        System.out.println("Futebol iniciado!");
    }

    @Override
    void jogar() {
        System.out.println("Jogando Futebol...");
    }

    @Override
    void finalizar() {
        System.out.println("Futebol finalizado!");
    }
}

public class Template {
    public static void main(String[] args) {
        Jogo xadrez = new Xadrez();
        xadrez.jogarJogo();

        System.out.println();

        Jogo futebol = new Futebol();
        futebol.jogarJogo();
    }
}
