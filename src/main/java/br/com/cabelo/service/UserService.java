package br.com.cabelo.service;


import br.com.cabelo.log.LogManager;
import br.com.cabelo.v1.annotations.Inject;
import br.com.cabelo.v1.annotations.LogExecutionTime;
import br.com.cabelo.v1.annotations.Service;
import org.slf4j.Logger;

@Service
public class UserService {

    private static final Logger log = LogManager.getLogger(UserService.class);

    @Inject
    private NotificationService notificationService;

    @LogExecutionTime
    public void registerUser(String user) {
        log.info("Registrando o usuário {}", user);
        notificationService.sendNotification(user);
    }

}