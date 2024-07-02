package bridge;

interface MetodoPagamento {
    void pagar(int quantia);
}

class PagamentoCartaoCredito implements MetodoPagamento {
    @Override
    public void pagar(int quantia) {
        System.out.println("Pagamento de " + quantia + " feito com Cartão de Crédito.");
    }
}

class PagamentoBoleto implements MetodoPagamento {
    @Override
    public void pagar(int quantia) {
        System.out.println("Pagamento de " + quantia + " feito com Boleto.");
    }
}

abstract class Pagamento {
    protected MetodoPagamento metodoPagamento;

    public Pagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public abstract void processarPagamento(int quantia);
}

class PagamentoOnline extends Pagamento {
    public PagamentoOnline(MetodoPagamento metodoPagamento) {
        super(metodoPagamento);
    }

    @Override
    public void processarPagamento(int quantia) {
        System.out.println("Processando pagamento online...");
        metodoPagamento.pagar(quantia);
    }
}

class PagamentoLojaFisica extends Pagamento {
    public PagamentoLojaFisica(MetodoPagamento metodoPagamento) {
        super(metodoPagamento);
    }

    @Override
    public void processarPagamento(int quantia) {
        System.out.println("Processando pagamento na loja física...");
        metodoPagamento.pagar(quantia);
    }
}

public class Bridge {
    public static void main(String[] args) {
        Pagamento pagamentoOnline = new PagamentoOnline(new PagamentoCartaoCredito());
        pagamentoOnline.processarPagamento(500);

        Pagamento pagamentoLojaFisica = new PagamentoLojaFisica(new PagamentoBoleto());
        pagamentoLojaFisica.processarPagamento(200);
    }
}

