package edu.fpdual.webapplication;

import edu.fpdual.webapplication.utilities.Password;

import java.sql.Date;

public class MainTest {

    public static void main(String[] args) {
        Password pwd = new Password("admin");
        System.out.println(pwd);
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
    }
}
