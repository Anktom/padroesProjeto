package state;

interface Estado {
    void fazerAcao(Contexto contexto);
}

class EstadoLigado implements Estado {
    @Override
    public void fazerAcao(Contexto contexto) {
        System.out.println("Estado atual: Ligado");
        contexto.setEstado(this);
    }

    @Override
    public String toString() {
        return "Ligado";
    }
}

class EstadoDesligado implements Estado {
    @Override
    public void fazerAcao(Contexto contexto) {
        System.out.println("Estado atual: Desligado");
        contexto.setEstado(this);
    }

    @Override
    public String toString() {
        return "Desligado";
    }
}

class Contexto {
    private Estado estado;

    public Contexto() {
        estado = null;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}

public class State {
    public static void main(String[] args) {
        Contexto contexto = new Contexto();

        EstadoLigado ligado = new EstadoLigado();
        ligado.fazerAcao(contexto);

        System.out.println(contexto.getEstado().toString());

        EstadoDesligado desligado = new EstadoDesligado();
        desligado.fazerAcao(contexto);

        System.out.println(contexto.getEstado().toString());
    }
}

