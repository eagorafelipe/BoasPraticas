package br.com.cabelo.model;

import br.com.cabelo.util.ResultadoValidacao;

import java.util.Objects;
import java.util.regex.Pattern;

public class Senha {

    private final String senha;

    private static final Pattern SENHA_FORTE_REGEX = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    public Senha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public static ResultadoValidacao<String> validaSenha(String senha) {
        if (Objects.isNull(senha) || senha.isEmpty()) return new ResultadoValidacao.Erro<>("A senha deve ser informada!");
        if (!SENHA_FORTE_REGEX.matcher(senha).matches()) return new ResultadoValidacao.Erro<>("Senha fraca: deve ter pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas, números e símbolos.");
        return new ResultadoValidacao.Sucesso<>(senha);
    }

    @Override
    public String toString() {
        return this.getSenha();
    }
}