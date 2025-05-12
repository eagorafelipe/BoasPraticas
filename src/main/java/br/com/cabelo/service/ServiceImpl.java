package br.com.cabelo.service;

import br.com.cabelo.interfaces.Repository;
import br.com.cabelo.interfaces.Service;
import br.com.cabelo.v3.annotations.Inject;
import br.com.cabelo.v3.annotations.LogExecutionTime;

public class ServiceImpl implements Service {

    @Inject
    private Repository repository;

    @Override
    @LogExecutionTime
    public void doSomething() {
        String data = repository.getData();
        System.out.println("Processing: " + data);
    }
}