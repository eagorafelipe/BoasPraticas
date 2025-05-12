package br.com.cabelo.interfaces;

import br.com.cabelo.model.pedidos.Product;

public interface ProductRepository {
    Product findById(String id);
    void save(Product product);
}