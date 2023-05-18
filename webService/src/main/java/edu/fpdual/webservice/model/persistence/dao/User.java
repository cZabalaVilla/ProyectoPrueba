package edu.fpdual.webservice.model.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
public class User implements Comparable<User> {
    private int userId;
    private String userName;
    private String userPassword;
    boolean admn;


    public User(String userName, String userPassword, boolean admn) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.admn = admn;
    }

    public User(ResultSet result) {
        try {
            this.userId = result.getInt("userId");
            this.userName = result.getString("userName");
            this.userPassword = result.getString("userPassword");
            this.admn = result.getBoolean("admn");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(User o) {
        return userId - o.userId;
    }
}