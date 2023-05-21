package edu.fpdual.webapplication.service;

import edu.fpdual.webapplication.client.UserClient;
import edu.fpdual.webapplication.dto.User;

import java.util.List;

public class UserService {
    private final UserClient userClient;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public String ping() {
        return userClient.ping();
    }

    public List<User> getAllUsers() {
        return userClient.get();
    }

    public User getUser(String userName) {
        return userClient.get(userName);
    }

    public boolean updateUser(User user) {
        return userClient.put(user);
    }

    public boolean createUser(User user) {
        return userClient.post(user);
    }

    public boolean deleteUser(User user) {
        return userClient.delete(user);
    }
}
