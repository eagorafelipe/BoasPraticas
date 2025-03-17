package br.com.cabelo.model.financeiro;

import br.com.cabelo.model.financeiro.pagamentos.Pagamentos;
import br.com.cabelo.model.financeiro.recebimentos.Recebimentos;

public class InformacoesFinanceiras {

    private final Saldo saldo;
    private Pagamentos pagamentos;
    private Recebimentos recebimentos;

    public InformacoesFinanceiras(Saldo saldo) {
        this.saldo = saldo;
    }

    public Saldo getSaldo() {
        return saldo;
    }
}