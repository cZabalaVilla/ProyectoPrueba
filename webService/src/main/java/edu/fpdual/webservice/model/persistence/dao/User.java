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
        this.userName = userName.toLowerCase();
        this.userPassword = userPassword;
        this.admn = admn;
    }

    public User(ResultSet resultSet) {
        try {
            this.userId = resultSet.getInt("userId");
            this.userName = resultSet.getString("userName");
            this.userPassword = resultSet.getString("userPassword");
            this.admn = resultSet.getBoolean("admn");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(User o) {
        return userId - o.userId;
    }
}