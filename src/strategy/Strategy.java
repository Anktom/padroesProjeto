interface EstrategiaImposto {
    double calcularImposto(double valor);
}

class ImpostoBrasil implements EstrategiaImposto {
    @Override
    public double calcularImposto(double valor) {
        return valor * 0.2;
    }
}

class ImpostoEUA implements EstrategiaImposto {
    @Override
    public double calcularImposto(double valor) {
        return valor * 0.15;
    }
}

class ImpostoAlemanha implements EstrategiaImposto {
    @Override
    public double calcularImposto(double valor) {
        return valor * 0.25;
    }
}

class CalculadoraImposto {
    private EstrategiaImposto estrategia;

    public void setEstrategia(EstrategiaImposto estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(double valor) {
        return estrategia.calcularImposto(valor);
    }
}

public class Strategy {
    public static void main(String[] args) {
        CalculadoraImposto calculadora = new CalculadoraImposto();

        calculadora.setEstrategia(new ImpostoBrasil());
        System.out.println("Imposto no Brasil: " + calculadora.calcular(1000));

        calculadora.setEstrategia(new ImpostoEUA());
        System.out.println("Imposto nos EUA: " + calculadora.calcular(1000));

        calculadora.setEstrategia(new ImpostoAlemanha());
        System.out.println("Imposto na Alemanha: " + calculadora.calcular(1000));
    }
}
