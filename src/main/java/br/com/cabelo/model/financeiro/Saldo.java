package br.com.cabelo.model.financeiro;

import br.com.cabelo.util.ResultadoValidacao;

import java.math.BigDecimal;

public class Saldo {

    private BigDecimal saldo = BigDecimal.ZERO;

    public BigDecimal getSaldo() {
        return saldo;
    }

    public ResultadoValidacao<BigDecimal> atribuirSaldo(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) return new ResultadoValidacao.Erro<>("O valor deve ser maior que zero!");
        this.saldo = valor;
        System.out.println("O saldo atual: " + this.getSaldoTotal());
        return new ResultadoValidacao.Sucesso<>(this.saldo);
    }

    public ResultadoValidacao<BigDecimal> adicionaSaldo(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) return new ResultadoValidacao.Erro<>("O valor deve ser maior que zero!");
        this.saldo = this.saldo.add(valor);
        System.out.println("O saldo atualizado: " + this.getSaldoTotal());
        return new ResultadoValidacao.Sucesso<>(this.saldo);
    }

    public ResultadoValidacao<BigDecimal> removeSaldo(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) return new ResultadoValidacao.Erro<>("O valor deve ser maior que zero!");
        if (this.saldo.compareTo(valor) < 0) return new ResultadoValidacao.Erro<>("O saldo atualizado deve ser maior que zero!");
        this.saldo = this.saldo.subtract(valor);
        System.out.println("O saldo atualizado: " + this.getSaldoTotal());
        return new ResultadoValidacao.Sucesso<>(this.saldo);
    }

    public BigDecimal getSaldoTotal() {
        return this.getSaldo();
    }
}