package decorator;

interface Forma {
    void desenhar();
}

class Circulo implements Forma {
    @Override
    public void desenhar() {
        System.out.println("Desenhando um círculo.");
    }
}

class Retangulo implements Forma {
    @Override
    public void desenhar() {
        System.out.println("Desenhando um retângulo.");
    }
}

abstract class FormaDecorator implements Forma {
    protected Forma formaDecorada;

    public FormaDecorator(Forma formaDecorada) {
        this.formaDecorada = formaDecorada;
    }

    public void desenhar() {
        formaDecorada.desenhar();
    }
}

class FormaVermelhaDecorator extends FormaDecorator {
    public FormaVermelhaDecorator(Forma formaDecorada) {
        super(formaDecorada);
    }

    @Override
    public void desenhar() {
        formaDecorada.desenhar();
        setBordaVermelha(formaDecorada);
    }

    private void setBordaVermelha(Forma formaDecorada) {
        System.out.println("Cor da borda: Vermelha.");
    }
}

public class Decorator {
    public static void main(String[] args) {
        Forma circulo = new Circulo();
        Forma circuloVermelho = new FormaVermelhaDecorator(new Circulo());

        System.out.println("Círculo com borda normal");
        circulo.desenhar();

        System.out.println("\nCírculo com borda vermelha");
        circuloVermelho.desenhar();
    }
}
