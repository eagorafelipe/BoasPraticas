package br.com.cabelo.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Validacoes {

    public static void valida(ResultadoValidacao<?>... validacoes) {
        List<String> erros = Arrays.stream(validacoes).map(ResultadoValidacao::getErro).filter(Optional::isPresent).map(Optional::get).toList();
        if (!erros.isEmpty()) throw new ValidacaoException(erros);
    }

    public static <T> T getValor(ResultadoValidacao<T> validacao) {
        return validacao.getValor().orElseThrow(() -> new ValidacaoException(validacao.getErro().orElse("Valor não encontrado!")));
    }

}