package br.com.cabelo.model;

import br.com.cabelo.log.LogManager;
import br.com.cabelo.util.ResultadoValidacao;
import org.slf4j.Logger;

import java.util.Objects;

public class Nome {

    private final String nome;
    private final String sobrenome;

    private static final Logger log = LogManager.getLogger(Nome.class);

    public Nome(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public static ResultadoValidacao<String> validaNome(String nome) {
        log.debug("Validando o nome: {}", nome);
        if (Objects.isNull(nome) || nome.isEmpty()) return new ResultadoValidacao.Erro<>("O nome deve ser informado!");
        return nome.length() >= 3 ? new ResultadoValidacao.Sucesso<>(nome) : new ResultadoValidacao.Erro<>("O nome deve ter pelo menos 3 caracteres!");
    }

    public static ResultadoValidacao<String> validaSobrenome(String sobrenome) {
        log.debug("Validando o sobrenome: {}", sobrenome);
        if (Objects.isNull(sobrenome) || sobrenome.isEmpty()) return new ResultadoValidacao.Erro<>("O sobrenome deve ser informado!");
        return sobrenome.length() >= 2 ? new ResultadoValidacao.Sucesso<>(sobrenome) : new ResultadoValidacao.Erro<>("O sobrenome deve ter pelo menos 3 caracteres!");
    }

    @Override
    public String toString() {
        return this.getNome() + " " + this.getSobrenome();
    }
}