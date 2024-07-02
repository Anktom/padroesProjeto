package chainResponsibility;

abstract class Suporte {
    protected Suporte proximo;

    public void setProximo(Suporte proximo) {
        this.proximo = proximo;
    }

    public abstract void tratarProblema(String problema);
}

class SuporteNivel1 extends Suporte {
    @Override
    public void tratarProblema(String problema) {
        if (problema.equals("senha esquecida")) {
            System.out.println("Suporte Nível 1 resolveu o problema: " + problema);
        } else {
            if (proximo != null) {
                proximo.tratarProblema(problema);
            }
        }
    }
}

class SuporteNivel2 extends Suporte {
    @Override
    public void tratarProblema(String problema) {
        if (problema.equals("computador lento")) {
            System.out.println("Suporte Nível 2 resolveu o problema: " + problema);
        } else {
            if (proximo != null) {
                proximo.tratarProblema(problema);
            }
        }
    }
}

class SuporteNivel3 extends Suporte {
    @Override
    public void tratarProblema(String problema) {
        System.out.println("Suporte Nível 3 resolveu o problema: " + problema);
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Suporte suporte1 = new SuporteNivel1();
        Suporte suporte2 = new SuporteNivel2();
        Suporte suporte3 = new SuporteNivel3();

        suporte1.setProximo(suporte2);
        suporte2.setProximo(suporte3);

        suporte1.tratarProblema("senha esquecida");
        suporte1.tratarProblema("computador lento");
        suporte1.tratarProblema("falha de hardware");
    }
}
