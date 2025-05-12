package br.com.cabelo;

import br.com.cabelo.interfaces.InventoryService;
import br.com.cabelo.interfaces.OrderService;
import br.com.cabelo.interfaces.ProductRepository;
import br.com.cabelo.log.LogManager;
import br.com.cabelo.model.pedidos.Order;
import br.com.cabelo.repository.JpaProductRepository;
import br.com.cabelo.service.DefaultInventoryService;
import br.com.cabelo.service.DefaultOrderService;
import br.com.cabelo.v3.container.DIContainer;
import org.slf4j.Logger;

import java.util.Properties;

public class Application {

    private static final Logger log;

    static {
        initLog();
        log = LogManager.getLogger(Main.class);
    }

    public static void main(String[] args) {

        // 1. Configura o framework
        DIContainer framework = new DIContainer();

        // Registra implementações para interfaces
        framework.register(ProductRepository.class, JpaProductRepository.class);
        framework.register(InventoryService.class, DefaultInventoryService.class);
        framework.register(OrderService.class, DefaultOrderService.class);

        // 2. Obtém instância do OrderService (todas as dependências serão injetadas automaticamente)
        OrderService orderService = framework.get(OrderService.class);

        // 3. Usa o serviço
        try {
            Order order = orderService.createOrder("123", 2);
            System.out.println("Order created: " + order.getOrderId() +
                    " for product: " + order.getProduct().getName());
        } catch (Exception e) {
            System.err.println("Error creating order: " + e.getMessage());
            e.printStackTrace();
        }

        // Teste de dependência circular (deve lançar exception)
        try {
            framework.get(OrderService.class).createOrder("999", 1);
        } catch (Exception e) {
            System.out.println("Dependência circular tratada: " + e.getMessage());
        }

        System.exit(0);
    }

    private static void initLog() {
        Properties props = new Properties();
        props.setProperty("log.level", "TRACE");
        props.setProperty("log.pattern", "%d{HH:mm:ss.SSS} %highlight(%-5level) [%10thread] %cyan(%-40logger{36}) - %msg%n");
        props.setProperty("log.file.path", "./logs/boas-praticas");
        props.setProperty("log.file.name", "boas-praticas.log");
        props.setProperty("log.file.maxSize", "10MB");
        props.setProperty("log.console", "true");

        LogManager.initialize(props);
    }
}