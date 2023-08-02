package com.cloudcatcity.platform.skeleton.repositories;

import com.cloudcatcity.platform.skeleton.models.Person;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

import java.util.Set;

public interface PeopleRepository extends RedisDocumentRepository<Person, String> {
    // Find people by age range
    Iterable<Person> findByAgeBetween(int minAge, int maxAge);

    // Draws a circular geofilter around a spot and returns all people in that radius
    Iterable<Person> findByHomeLoc(Point point, Distance distance);

    // Find people by their first and last name
    Iterable<Person> findByFirstNameAndLastName(String firstName, String lastName);

    // Performs full text search on a person's personal Statement
    Iterable<Person> searchByPersonalStatement(String text);

    // Performing a tag search on city
    Iterable<Person> findByAddress_City(String city);

    // Performing a full-search on street
    Iterable<Person> findByAddress_CityAndAddress_State(String city, String state);

    // Search Persons that have one of multiple skills (OR condition)
    Iterable<Person> findBySkills(Set<String> skills);

    // Search Persons that have all of the skills (AND condition):
    Iterable<Person> findBySkillsContainingAll(Set<String> skills);

    // Performing a text search on all text fields:
    Iterable<Person> search(String text);
}