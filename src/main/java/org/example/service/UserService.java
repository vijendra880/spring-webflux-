package org.example.service;

import org.example.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static Map<Integer, User> users = new HashMap<>();

    static {
        users.put(1, new User(1, "vijendra"));
    }

    public Mono<User> getUser(int userId) {
        return Mono.fromSupplier(() -> getUserFromDB(userId));
    }

    private User getUserFromDB(int userId) {
        return users.get(userId);
    }
}
