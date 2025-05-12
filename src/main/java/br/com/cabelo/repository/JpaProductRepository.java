package br.com.cabelo.repository;

import br.com.cabelo.interfaces.ProductRepository;
import br.com.cabelo.model.pedidos.Product;
import br.com.cabelo.v3.annotations.LogExecutionTime;
import br.com.cabelo.v3.annotations.Scope;
import br.com.cabelo.v3.enums.ScopeType;

import java.util.concurrent.TimeUnit;

@Scope(ScopeType.SINGLETON)
public class JpaProductRepository implements ProductRepository {

    @Override
    @LogExecutionTime
    public Product findById(String id) {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException ignored) {
        }

        return new Product(id, "Product " + id, 100);
    }

    @Override
    public void save(Product product) {
        System.out.println("Salvando o produto: " + product.getName());
    }
}