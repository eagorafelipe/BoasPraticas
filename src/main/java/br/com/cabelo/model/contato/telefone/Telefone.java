package br.com.cabelo.model.contato.telefone;

import br.com.cabelo.util.ResultadoValidacao;

import java.util.Objects;
import java.util.regex.Pattern;

public class Telefone {

    private final String celular;
    private final String fixo;

    private static final Pattern TELEFONE_REGEX = Pattern.compile("^\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}$");

    public Telefone(String celular, String fixo) {
        this.celular = celular;
        this.fixo = fixo;
    }

    public Telefone(String celular) {
        this(celular, null);
    }

    public String getFixo() {
        return Objects.isNull(fixo) ? "" : fixo;
    }

    public String getCelular() {
        return celular;
    }

    public static ResultadoValidacao<String> validaCelular(String celular) {
        if (Objects.isNull(celular) || celular.isEmpty()) return new ResultadoValidacao.Erro<>("O celular deve ser informado!");
        if (!TELEFONE_REGEX.matcher(celular).matches()) return new ResultadoValidacao.Erro<>("O celular informado é inválido!");
        return new ResultadoValidacao.Sucesso<>(celular);
    }

    public static ResultadoValidacao<String> validaFixo(String fixo) {
        if (Objects.isNull(fixo) || fixo.isEmpty()) return new ResultadoValidacao.Sucesso<>("Telefone fixo não informado!");
        if (!TELEFONE_REGEX.matcher(fixo).matches()) return new ResultadoValidacao.Erro<>("O telefone fixo informado é inválido!");
        return new ResultadoValidacao.Sucesso<>(fixo);
    }

    @Override
    public String toString() {
        return "Celular: " + this.getCelular() + (!this.getFixo().isEmpty() ? " Fixo: " + this.getFixo() : "");
    }
}