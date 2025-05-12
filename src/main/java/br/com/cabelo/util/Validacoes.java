package br.com.cabelo.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Validacoes<T> {

    private final T valor;

    private Validacoes(T valor){
        this.valor = valor;
    }

    public static void valida(ResultadoValidacao<?>... validacoes) {
        List<String> erros = Arrays.stream(validacoes).map(ResultadoValidacao::getErro).filter(Optional::isPresent).map(Optional::get).toList();
        if (!erros.isEmpty()) throw new ValidacaoException(erros);
    }

    public static <T> T getValor(ResultadoValidacao<T> validacao) {
        return validacao.getValor().orElseThrow(() -> new ValidacaoException(validacao.getErro().orElse("Valor não encontrado!")));
    }

    public static <T> Validacoes<T> de(T valor){
        return new Validacoes<>(valor);
    }

    public Validacoes<T> quando(Predicate<T> condicao, String msgErro){
        if(condicao.test(valor)) throw new ValidacaoException(msgErro);
        return this;
    }



}