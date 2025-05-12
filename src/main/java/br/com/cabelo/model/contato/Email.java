package br.com.cabelo.model.contato;

import br.com.cabelo.util.ResultadoValidacao;
import br.com.cabelo.util.Validacoes;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email {

    private final String email;

    private static final Pattern EMAIL_REGEX = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public static ResultadoValidacao<String> validaEmail(String email) {
        if (Objects.isNull(email) || email.isEmpty()) return new ResultadoValidacao.Erro<>("O email deve ser informado!");
        if (!EMAIL_REGEX.matcher(email).matches()) return new ResultadoValidacao.Erro<>("O email informado é inválido!");
        return new ResultadoValidacao.Sucesso<>(email);
    }

    public static String validaEmail2(String email) {
        Validacoes
                .de(email)
                .quando(e -> Objects.isNull(e) || e.isEmpty(), "O email deve ser informado!")
                .quando(e -> !EMAIL_REGEX.matcher(e).matches(), "O email informado é inválido!");
        return email;
    }

    @Override
    public String toString() {
        return this.getEmail();
    }
}