package adapter;

interface Tomada {
    void conectar();
}

class TomadaAmericana implements Tomada {
    @Override
    public void conectar() {
        System.out.println("Conectado à tomada americana.");
    }
}

class TomadaEuropeia {
    public void conectarEuropeia() {
        System.out.println("Conectado à tomada europeia.");
    }
}

class AdaptadorTomada implements Tomada {
    private TomadaEuropeia tomadaEuropeia;

    public AdaptadorTomada(TomadaEuropeia tomadaEuropeia) {
        this.tomadaEuropeia = tomadaEuropeia;
    }

    @Override
    public void conectar() {
        tomadaEuropeia.conectarEuropeia();
    }
}

public class Adapter {
    public static void main(String[] args) {
        Tomada tomadaAmericana = new TomadaAmericana();
        Tomada tomadaAdaptada = new AdaptadorTomada(new TomadaEuropeia());

        tomadaAmericana.conectar();
        tomadaAdaptada.conectar();
    }
}
