package br.com.cabelo;

import br.com.cabelo.model.contato.email.Contato;
import br.com.cabelo.model.contato.Email;
import br.com.cabelo.model.contato.endereco.Endereco;
import br.com.cabelo.model.Nome;
import br.com.cabelo.model.Pessoa;
import br.com.cabelo.model.Senha;
import br.com.cabelo.model.contato.telefone.Telefone;
import br.com.cabelo.model.financeiro.InformacoesFinanceiras;
import br.com.cabelo.model.financeiro.Saldo;
import br.com.cabelo.util.ResultadoValidacao;
import br.com.cabelo.util.ValidacaoException;
import br.com.cabelo.util.Validacoes;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        ResultadoValidacao<String> nome = Nome.validaNome("joaquim");
        ResultadoValidacao<String> sobrenome = Nome.validaSobrenome("sa");
        Nome iNome = new Nome(Validacoes.getValor(nome), Validacoes.getValor(sobrenome));

        ResultadoValidacao<String> senha = Senha.validaSenha("F31jAao!");
        Pessoa pessoa = new Pessoa(iNome, new Senha(Validacoes.getValor(senha)));

        System.out.println("O nome: " + pessoa.getNome() + " e a senha: " + pessoa.getSenha() + " são válidos!");

        ResultadoValidacao<String> email = Email.validaEmail("joaquim@email.com");
        Email iEmail = new Email(Validacoes.getValor(email));

        ResultadoValidacao<String> celular = Telefone.validaCelular("11999999999");
        Contato contato = new Contato(new Endereco(), new Telefone(Validacoes.getValor(celular)), iEmail);
        System.out.println(contato);

        Saldo saldo = new Saldo();
        ResultadoValidacao<BigDecimal> atribuiSaldo = saldo.atribuirSaldo(BigDecimal.valueOf(10));
        Validacoes.valida(atribuiSaldo);
        InformacoesFinanceiras informacoesFinanceiras = new InformacoesFinanceiras(saldo);

        try {
            ResultadoValidacao<BigDecimal> adicionaSaldo = informacoesFinanceiras.getSaldo().adicionaSaldo(BigDecimal.valueOf(100));
            Validacoes.valida(adicionaSaldo);
        } catch (ValidacaoException e) {
            System.out.println(e.getMessage());
            System.out.println("O saldo atual: " + informacoesFinanceiras.getSaldo().getSaldoTotal());
        }

        ResultadoValidacao<BigDecimal> removeSaldo = informacoesFinanceiras.getSaldo().removeSaldo(BigDecimal.valueOf(90));
        Validacoes.valida(removeSaldo);
    }
}