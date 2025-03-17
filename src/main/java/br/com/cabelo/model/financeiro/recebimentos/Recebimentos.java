package br.com.cabelo.model.financeiro.recebimentos;

import java.util.ArrayList;
import java.util.List;

public class Recebimentos {

    private final List<Recebimento> recebimentos = new ArrayList<>();

    public List<Recebimento> getRecebimentos() {
        return recebimentos;
    }

    public void adicionarRecebimento(Recebimento recebimento) {
        recebimentos.add(recebimento);
    }

    public void removerRecebimento(Recebimento recebimento) {
        recebimentos.remove(recebimento);
    }
}