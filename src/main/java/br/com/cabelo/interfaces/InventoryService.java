package br.com.cabelo.interfaces;

public interface InventoryService {
    boolean isProductAvailable(String productId, int quantity);
}