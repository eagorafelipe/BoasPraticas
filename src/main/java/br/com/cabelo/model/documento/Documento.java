package br.com.cabelo.model.documento;

public interface Documento {

    void validacao(String documento) throws ValidacaoDocumentoException;


}