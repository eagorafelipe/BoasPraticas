package br.com.cabelo.interfaces;

import br.com.cabelo.model.pedidos.Order;

public interface OrderService {
    Order createOrder(String productId, int quantity);
}