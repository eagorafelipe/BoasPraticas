package br.com.cabelo.model;

import br.com.cabelo.model.contato.email.Contato;
import br.com.cabelo.model.financeiro.InformacoesFinanceiras;

public class Pessoa {

    private final Nome nome;
    private final Senha senha;
    private Contato contato;

    private InformacoesFinanceiras informacoesFinanceiras;

    public Pessoa(Nome nome, Senha senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Nome getNome() {
        return nome;
    }

    public Senha getSenha() {
        return senha;
    }

    public void atribuirContato(Contato contato) {
        this.contato = contato;
    }

    public Contato getContato() {
        return contato;
    }

    public void atribuirInformacoesFinanceiras(InformacoesFinanceiras informacoesFinanceiras) {
        this.informacoesFinanceiras = informacoesFinanceiras;
    }

}