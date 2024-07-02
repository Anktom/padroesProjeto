abstract class Transporte {
    public abstract void entregar();
}

class Caminhao extends Transporte {
    @Override
    public void entregar() {
        System.out.println("Entrega por caminhão.");
    }
}

class Navio extends Transporte {
    @Override
    public void entregar() {
        System.out.println("Entrega por navio.");
    }
}

abstract class Logistica {
    public void planejarEntrega() {
        Transporte transporte = criarTransporte();
        transporte.entregar();
    }

    protected abstract Transporte criarTransporte();
}

class LogisticaRodoviaria extends Logistica {
    @Override
    protected Transporte criarTransporte() {
        return new Caminhao();
    }
}

class LogisticaMaritima extends Logistica {
    @Override
    protected Transporte criarTransporte() {
        return new Navio();
    }
}

public class Factory {
    public static void main(String[] args) {
        Logistica logisticaRodoviaria = new LogisticaRodoviaria();
        logisticaRodoviaria.planejarEntrega();

        Logistica logisticaMaritima = new LogisticaMaritima();
        logisticaMaritima.planejarEntrega();
    }
}
