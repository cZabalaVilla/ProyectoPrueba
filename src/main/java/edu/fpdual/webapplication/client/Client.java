package edu.fpdual.webapplication.client;

public abstract class Client<T>  {
    //para comprobar la conexion
    public abstract String ping();
    //Para obtener datos
    public abstract T get(String str);
    //Para actualizar datos
    public abstract boolean put(T entity);
    //Para crear datos
    public abstract boolean post(T entity);
    //Para borrar datos
    public abstract boolean delete(T entity);
}