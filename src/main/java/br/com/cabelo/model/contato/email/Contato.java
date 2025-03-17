package br.com.cabelo.model.contato.email;

import br.com.cabelo.model.contato.Email;
import br.com.cabelo.model.contato.endereco.Endereco;
import br.com.cabelo.model.contato.telefone.Telefone;

public record Contato(Endereco endereco, Telefone telefone, Email email) {

    @Override
    public String toString() {
        return "endereco=" + endereco + ", " + telefone + ", email=" + email;
    }
}