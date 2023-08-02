package com.cloudcatcity.platform.skeleton.users.repositories;

import com.cloudcatcity.platform.skeleton.users.models.User;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

import java.util.Set;

public interface UserRepository extends RedisDocumentRepository<User, String> {
    // Find people by age range
    Iterable<User> findByAgeBetween(int minAge, int maxAge);

    // Draws a circular geofilter around a spot and returns all people in that radius
    Iterable<User> findByHomeLoc(Point point, Distance distance);

    // Find people by their first and last name
    Iterable<User> findByFirstNameAndLastName(String firstName, String lastName);

    // Performs full text search on a person's personal Statement
    Iterable<User> searchByPersonalStatement(String text);

    // Performing a tag search on city
    Iterable<User> findByAddress_City(String city);

    // Performing a full-search on street
    Iterable<User> findByAddress_CityAndAddress_State(String city, String state);

    // Search Persons that have one of multiple skills (OR condition)
    Iterable<User> findBySkills(Set<String> skills);

    // Search Persons that have all of the skills (AND condition):
    Iterable<User> findBySkillsContainingAll(Set<String> skills);

    // Performing a text search on all text fields:
    Iterable<User> search(String text);
}