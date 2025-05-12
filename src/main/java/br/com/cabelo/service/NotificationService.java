package br.com.cabelo.service;

import br.com.cabelo.log.LogManager;
import br.com.cabelo.v1.annotations.Service;
import org.slf4j.Logger;

@Service
public class NotificationService {

    private static final Logger log = LogManager.getLogger(NotificationService.class);

    public void sendNotification(String user) {
        log.info("Enviando notificação para o usuário {}", user);
    }
}