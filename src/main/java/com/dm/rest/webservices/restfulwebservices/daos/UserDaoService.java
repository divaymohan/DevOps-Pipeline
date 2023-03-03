package com.dm.rest.webservices.restfulwebservices.daos;

import com.dm.rest.webservices.restfulwebservices.dtos.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"divay", LocalDate.now().minusYears(30)));
        users.add(new User(2, "ekta", LocalDate.now().minusYears(26)));
        users.add(new User(3, "karun", LocalDate.now().minusYears(25)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void createUser(User user){
        users.add(user);
    }

}
