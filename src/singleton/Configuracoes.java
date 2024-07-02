package singleton;

import java.util.HashMap;
import java.util.Map;

public class Configuracoes {
    private static Configuracoes instance;
    private Map<String, String> configuracoes;

    private Configuracoes() {
        configuracoes = new HashMap<>();
        configuracoes.put("tema", "claro");
        configuracoes.put("idioma", "pt-BR");
    }

    public static Configuracoes getInstance() {
        if (instance == null) {
            synchronized (Configuracoes.class) {
                if (instance == null) {
                    instance = new Configuracoes();
                }
            }
        }
        return instance;
    }

    public String getConfiguracao(String chave) {
        return configuracoes.get(chave);
    }

    public void setConfiguracao(String chave, String valor) {
        configuracoes.put(chave, valor);
    }

    public static void main(String[] args) {
        Configuracoes config = Configuracoes.getInstance();

        System.out.println("Tema: " + config.getConfiguracao("tema"));
        System.out.println("Idioma: " + config.getConfiguracao("idioma"));

        config.setConfiguracao("tema", "escuro");
        config.setConfiguracao("idioma", "en-US");

        Configuracoes config2 = Configuracoes.getInstance();
        System.out.println("Tema alterado: " + config2.getConfiguracao("tema"));
        System.out.println("Idioma alterado: " + config2.getConfiguracao("idioma"));

        if (config == config2) {
            System.out.println("As instâncias são iguais.");
        } else {
            System.out.println("As instâncias são diferentes.");
        }
    }
}
