package br.com.cabelo.service;

import br.com.cabelo.interfaces.InventoryService;
import br.com.cabelo.interfaces.OrderService;
import br.com.cabelo.interfaces.ProductRepository;
import br.com.cabelo.model.pedidos.Order;
import br.com.cabelo.model.pedidos.Product;
import br.com.cabelo.v3.annotations.Inject;
import br.com.cabelo.v3.annotations.LogExecutionTime;

import java.util.UUID;

public class DefaultOrderService implements OrderService {

    @Inject
    private InventoryService inventoryService;

    @Inject
    private ProductRepository productRepository;

    @Override
    @LogExecutionTime
    public Order createOrder(String productId, int quantity) {
        if(!inventoryService.isProductAvailable(productId, quantity)) throw new RuntimeException("Produto fora do estoque!");
        Product product = productRepository.findById(productId);
        return new Order(UUID.randomUUID().toString(), product, quantity);
    }
}