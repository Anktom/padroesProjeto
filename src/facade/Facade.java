package facade;

class SistemaReservaVoo {
    public void reservarVoo(String origem, String destino) {
        System.out.println("Voo reservado de " + origem + " para " + destino);
    }
}

class SistemaReservaHotel {
    public void reservarHotel(String localizacao) {
        System.out.println("Hotel reservado em " + localizacao);
    }
}

class SistemaReservaCarro {
    public void reservarCarro(String localizacao) {
        System.out.println("Carro reservado em " + localizacao);
    }
}

class FacadeReservaViagem {
    private SistemaReservaVoo sistemaVoo;
    private SistemaReservaHotel sistemaHotel;
    private SistemaReservaCarro sistemaCarro;

    public FacadeReservaViagem() {
        sistemaVoo = new SistemaReservaVoo();
        sistemaHotel = new SistemaReservaHotel();
        sistemaCarro = new SistemaReservaCarro();
    }

    public void reservarViagemCompleta(String origem, String destino, String localizacaoHotel) {
        sistemaVoo.reservarVoo(origem, destino);
        sistemaHotel.reservarHotel(localizacaoHotel);
        sistemaCarro.reservarCarro(localizacaoHotel);
        System.out.println("Viagem completa reservada com sucesso!");
    }
}

public class Facade {
    public static void main(String[] args) {
        FacadeReservaViagem facadeReservaViagem = new FacadeReservaViagem();
        facadeReservaViagem.reservarViagemCompleta("São Paulo", "Nova York", "Manhattan");
    }
}
