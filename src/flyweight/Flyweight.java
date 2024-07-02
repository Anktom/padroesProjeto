package flyweight;

import java.util.HashMap;
import java.util.Map;

interface Arvore {
    void plantar(int x, int y);
}

class ArvoreConcreta implements Arvore {
    private String tipo;

    public ArvoreConcreta(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void plantar(int x, int y) {
        System.out.println("Plantando uma árvore do tipo " + tipo + " na posição (" + x + ", " + y + ")");
    }
}

class FabricaArvores {
    private static final Map<String, Arvore> ARVORES = new HashMap<>();

    public static Arvore getArvore(String tipo) {
        Arvore arvore = ARVORES.get(tipo);
        if (arvore == null) {
            arvore = new ArvoreConcreta(tipo);
            ARVORES.put(tipo, arvore);
        }
        return arvore;
    }
}

public class Flyweight{
    public static void main(String[] args) {
        Arvore arvore1 = FabricaArvores.getArvore("Carvalho");
        arvore1.plantar(10, 20);

        Arvore arvore2 = FabricaArvores.getArvore("Carvalho");
        arvore2.plantar(30, 40);

        Arvore arvore3 = FabricaArvores.getArvore("Pinheiro");
        arvore3.plantar(50, 60);

        Arvore arvore4 = FabricaArvores.getArvore("Carvalho");
        arvore4.plantar(70, 80);
    }
}
