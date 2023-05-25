package edu.fpdual.webapplication;

import edu.fpdual.webapplication.dfo.Password;

public class MainTest {

    public static void main(String[] args) {
        Password pwd = new Password("admin");
        System.out.println(pwd);
    }
}
