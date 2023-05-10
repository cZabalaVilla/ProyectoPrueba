package edu.fpdual.webservice.model.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
public class User implements Comparable<User> {
    int userId;
    String userName;
    String userPassword;

    public User(ResultSet result) {
        try {
            this.userId = Integer.parseInt(result.getString("userId"));
            this.userName = result.getString("userName");
            this.userPassword = result.getString("userPassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int compareTo(User o) {
        return userId - o.userId;
    }
}