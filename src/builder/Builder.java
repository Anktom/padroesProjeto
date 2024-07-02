package builder;

class Carro {
    private String motor;
    private String cor;
    private int assentos;

    public Carro(String motor, String cor, int assentos) {
        this.motor = motor;
        this.cor = cor;
        this.assentos = assentos;
    }

    @Override
    public String toString() {
        return "Carro [motor=" + motor + ", cor=" + cor + ", assentos=" + assentos + "]";
    }
}

class CarroBuilder {
    private String motor;
    private String cor;
    private int assentos;

    public CarroBuilder setMotor(String motor) {
        this.motor = motor;
        return this;
    }

    public CarroBuilder setCor(String cor) {
        this.cor = cor;
        return this;
    }

    public CarroBuilder setAssentos(int assentos) {
        this.assentos = assentos;
        return this;
    }

    public Carro build() {
        return new Carro(motor, cor, assentos);
    }
}

public class Builder{
    public static void main(String[] args) {
        Carro carro = new CarroBuilder()
                .setMotor("V8")
                .setCor("Vermelho")
                .setAssentos(4)
                .build();
        System.out.println(carro);
    }
}
