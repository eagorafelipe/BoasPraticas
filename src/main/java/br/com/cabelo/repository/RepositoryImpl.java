package br.com.cabelo.repository;

import br.com.cabelo.interfaces.Repository;
import br.com.cabelo.v3.annotations.LogExecutionTime;
import br.com.cabelo.v3.annotations.Scope;
import br.com.cabelo.v3.enums.ScopeType;

import java.util.concurrent.TimeUnit;

@Scope(ScopeType.SINGLETON)
public class RepositoryImpl implements Repository {
    @Override
    @LogExecutionTime
    public String getData() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Simple Data";
    }
}