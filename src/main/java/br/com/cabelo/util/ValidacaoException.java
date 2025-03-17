package br.com.cabelo.util;

import java.util.List;

public class ValidacaoException extends IllegalArgumentException {

    public ValidacaoException(String message) {
        super(message);
    }

    public ValidacaoException(List<String> erros) {
        super(String.join(System.lineSeparator(), erros));
    }
}