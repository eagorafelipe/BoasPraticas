package br.com.cabelo.model.financeiro.pagamentos;

import java.util.ArrayList;
import java.util.List;

public class Pagamentos {

    private final List<Pagamento> pagamentos = new ArrayList<>();

    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void removerPagamento(Pagamento pagamento) {
        pagamentos.remove(pagamento);
    }
}