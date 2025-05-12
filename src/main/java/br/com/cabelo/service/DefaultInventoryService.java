package br.com.cabelo.service;

import br.com.cabelo.interfaces.InventoryService;
import br.com.cabelo.interfaces.ProductRepository;
import br.com.cabelo.model.pedidos.Product;
import br.com.cabelo.v3.annotations.Inject;
import br.com.cabelo.v3.annotations.LogExecutionTime;

public class DefaultInventoryService implements InventoryService {

    @Inject
    private ProductRepository productRepository;

    @Override
    @LogExecutionTime
    public boolean isProductAvailable(String productId, int quantity) {
        Product product = productRepository.findById(productId);
        return product != null && quantity > 0;
    }

}