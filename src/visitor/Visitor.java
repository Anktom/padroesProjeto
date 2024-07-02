package visitor;

interface RelatorioVisitor {
    void visitar(ContaCorrente contaCorrente);
    void visitar(ContaPoupanca contaPoupanca);
}

class RelatorioDetalhado implements RelatorioVisitor {
    @Override
    public void visitar(ContaCorrente contaCorrente) {
        System.out.println("Relatório Detalhado - Conta Corrente: " + contaCorrente.getSaldo());
    }

    @Override
    public void visitar(ContaPoupanca contaPoupanca) {
        System.out.println("Relatório Detalhado - Conta Poupança: " + contaPoupanca.getSaldo());
    }
}

class RelatorioResumido implements RelatorioVisitor {
    @Override
    public void visitar(ContaCorrente contaCorrente) {
        System.out.println("Relatório Resumido - Conta Corrente");
    }

    @Override
    public void visitar(ContaPoupanca contaPoupanca) {
        System.out.println("Relatório Resumido - Conta Poupança");
    }
}

interface Conta {
    void aceitar(RelatorioVisitor visitor);
}

class ContaCorrente implements Conta {
    private double saldo;

    public ContaCorrente(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void aceitar(RelatorioVisitor visitor) {
        visitor.visitar(this);
    }
}

class ContaPoupanca implements Conta {
    private double saldo;

    public ContaPoupanca(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void aceitar(RelatorioVisitor visitor) {
        visitor.visitar(this);
    }
}

public class Visitor{
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente(1000.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca(5000.0);

        RelatorioDetalhado relatorioDetalhado = new RelatorioDetalhado();
        RelatorioResumido relatorioResumido = new RelatorioResumido();

        System.out.println("Relatório Detalhado:");
        contaCorrente.aceitar(relatorioDetalhado);
        contaPoupanca.aceitar(relatorioDetalhado);

        System.out.println("\nRelatório Resumido:");
        contaCorrente.aceitar(relatorioResumido);
        contaPoupanca.aceitar(relatorioResumido);
    }
}
