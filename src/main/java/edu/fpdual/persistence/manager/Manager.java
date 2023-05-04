package edu.fpdual.persistence.manager;

import edu.fpdual.persistence.dao.Usuario;

import java.sql.Connection;
import java.util.List;

public interface Manager<T> {
    List<T> findAll(Connection con);
    T findBy(Connection con,String fieldName, Object value);
}