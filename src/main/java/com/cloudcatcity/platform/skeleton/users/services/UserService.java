package com.cloudcatcity.platform.skeleton.users.services;

import com.cloudcatcity.platform.skeleton.users.models.User;
import com.cloudcatcity.platform.skeleton.users.models.User$;
import com.redis.om.spring.search.stream.EntityStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import redis.clients.jedis.search.aggr.SortedField.SortOrder;

import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    EntityStream entityStream;

    // Find people by age range
    public Iterable<User> findByAgeBetween(int minAge, int maxAge) {
        return entityStream //
                .of(User.class) //
                .filter(User$.AGE.between(minAge, maxAge)) //
                .sorted(User$.AGE, SortOrder.ASC) //
                .collect(Collectors.toList());
    }

    // Find people by their first and last name
    public Iterable<User> findByFirstNameAndLastName(String firstName, String lastName) {
        return entityStream //
                .of(User.class) //
                .filter(User$.FIRST_NAME.eq(firstName)) //
                .filter(User$.LAST_NAME.eq(lastName)) //
                .collect(Collectors.toList());
    }

    public Iterable<User> findByHomeLoc(//
                                        Point point, Distance distance) {
        return entityStream //
                .of(User.class) //
                .filter(User$.HOME_LOC.near(point, distance)) //
                .collect(Collectors.toList());
    }

    // Performs full text search on a User's Useral Statement
    public Iterable<User> searchByPersonalStatement(String text) {
        return entityStream //
                .of(User.class) //
                .filter(User$.PERSONAL_STATEMENT.eq(text)) //
                .collect(Collectors.toList());
    }

}
