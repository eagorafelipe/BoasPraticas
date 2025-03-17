package br.com.cabelo.util;

import java.util.Optional;

public abstract class ResultadoValidacao<T> {

    private ResultadoValidacao() {
    }

    public abstract Optional<T> getValor();

    protected abstract Optional<String> getErro();

    public static class Sucesso<T> extends ResultadoValidacao<T> {

        private final T valor;

        public Sucesso(T valor) {
            this.valor = valor;
        }

        @Override
        public Optional<T> getValor() {
            return Optional.of(valor);
        }

        @Override
        protected Optional<String> getErro() {
            return Optional.empty();
        }
    }

    public static class Erro<T> extends ResultadoValidacao<T> {

        private final String erro;

        public Erro(String erro) {
            this.erro = erro;
        }

        @Override
        public Optional<T> getValor() {
            return Optional.empty();
        }

        @Override
        public Optional<String> getErro() {
            return Optional.of(erro);
        }
    }
}