package abstractFactory;

interface DispositivoInteligente {
    void conectar();
}

class LuzInteligente implements DispositivoInteligente {
    @Override
    public void conectar() {
        System.out.println("Luz Inteligente conectada.");
    }
}

class CameraInteligente implements DispositivoInteligente {
    @Override
    public void conectar() {
        System.out.println("Câmera Inteligente conectada.");
    }
}

interface FabricaDispositivosInteligentes {
    DispositivoInteligente criarLuz();
    DispositivoInteligente criarCamera();
}

class FabricaCasa implements FabricaDispositivosInteligentes {
    @Override
    public DispositivoInteligente criarLuz() {
        return new LuzInteligente();
    }

    @Override
    public DispositivoInteligente criarCamera() {
        return new CameraInteligente();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        FabricaDispositivosInteligentes fabrica = new FabricaCasa();

        DispositivoInteligente luz = fabrica.criarLuz();
        DispositivoInteligente camera = fabrica.criarCamera();

        luz.conectar();
        camera.conectar();
    }
}
