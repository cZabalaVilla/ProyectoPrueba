package com.example.persistence.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
public class UsuarioManager {
    package org.example.jdbc.persistence.manager;

import org.example.jdbc.persistence.connector.MySQLConnector;
import org.example.jdbc.persistence.manager.dao.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class CityManager {

        public List<City> findById(Connection con, int id){

            try(PreparedStatement stm = con.prepareStatement("SELECT * FROM City WHERE ID = ?")){

                stm.setInt(1, id);

                ResultSet result = stm.executeQuery();

                result.beforeFirst();

                List<City> cities = new ArrayList<>();

                while(result.next()){
                    cities.add(new City(result));
                }

                return cities;

            }catch(SQLException e){
                e.printStackTrace();
                return null;
            }

        }

    }

        public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = new MySQLConnector().getMySQLConnection();
        List<City> cities = new CityManager().findById(con,664);
        for (City city : cities) {
            System.out.println(city);
        }
        con.close();
    }*/
