package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {
    private static List<User1> users = new ArrayList<>();

    private static int usersCount = 0;
    static{
        users.add(new User1(++usersCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User1(++usersCount,"Eve", LocalDate.now().minusYears(20)));
        users.add(new User1(++usersCount,"Jim", LocalDate.now().minusYears(40)));
    }

    public List<User1> findAll() {
        return users;
    }

    public User1 findOne(int id) {
        Predicate<? super User1> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

    public User1 save(User1 user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
