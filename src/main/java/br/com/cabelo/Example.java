package br.com.cabelo;

import br.com.cabelo.interfaces.Repository;
import br.com.cabelo.interfaces.Service;
import br.com.cabelo.log.LogManager;
import br.com.cabelo.repository.RepositoryImpl;
import br.com.cabelo.service.ServiceImpl;
import br.com.cabelo.v3.container.DIContainer;
import org.slf4j.Logger;

import java.util.Properties;

public class Example {

    private static final Logger log;

    static {
        initLog();
        log = LogManager.getLogger(Main.class);
    }

    public static void main(String[] args) {
        DIContainer container = new DIContainer();
        container.register(Service.class, ServiceImpl.class);
        container.register(Repository.class, RepositoryImpl.class);

        Service service = container.get(Service.class);

        service.doSomething();
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