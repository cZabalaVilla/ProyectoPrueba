package edu.fpdual.webapplication.service.client;

public abstract class Client<T> {
    public abstract String ping();

    public abstract T get(String str);

    public abstract T put(String str);

    public abstract T post(T t);
}