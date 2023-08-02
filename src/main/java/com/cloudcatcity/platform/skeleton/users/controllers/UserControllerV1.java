package com.cloudcatcity.platform.skeleton.users.controllers;

import java.util.Optional;
import java.util.Set;

import com.cloudcatcity.platform.skeleton.users.models.User;
import com.cloudcatcity.platform.skeleton.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class UserControllerV1 {

  @Autowired
  UserRepository repo;

  @GetMapping("age_between")
  Iterable<User> byAgeBetween( //
                               @RequestParam("min") int min, //
                               @RequestParam("max") int max) {
    return repo.findByAgeBetween(min, max);
  }

  @GetMapping("homeloc")
  Iterable<User> byHomeLoc(//
                           @RequestParam("lat") double lat, //
                           @RequestParam("lon") double lon, //
                           @RequestParam("d") double distance) {
    return repo.findByHomeLoc(new Point(lon, lat), new Distance(distance, Metrics.MILES));
  }

  @GetMapping("name")
  Iterable<User> byFirstNameAndLastName(@RequestParam("first") String firstName, //
                                        @RequestParam("last") String lastName) {
    return repo.findByFirstNameAndLastName(firstName, lastName);
  }

  @GetMapping("statement")
  Iterable<User> byPersonalStatement(@RequestParam("q") String q) {
    return repo.searchByPersonalStatement(q);
  }

  @PostMapping("new")
  User create(@RequestBody User newUser) {
    return repo.save(newUser);
  }
  
  @GetMapping("{id}")
  Optional<User> byId(@PathVariable String id) {
    return repo.findById(id);
  }

  @PutMapping("{id}")
  User update(@RequestBody User newUser, @PathVariable String id) {
    return repo.findById(id).map(person -> {
      person.setFirstName(newUser.getFirstName());
      person.setLastName(newUser.getLastName());
      person.setAge(newUser.getAge());
      person.setAddress(newUser.getAddress());
      person.setHomeLoc(newUser.getHomeLoc());
      person.setPersonalStatement(newUser.getPersonalStatement());

      return repo.save(person);
    }).orElseGet(() -> {
      return repo.save(newUser);
    });
  }

  @DeleteMapping("{id}")
  void delete(@PathVariable String id) {
    repo.deleteById(id);
  }
  
  @GetMapping("city")
  Iterable<User> byCity(@RequestParam("city") String city) {
    return repo.findByAddress_City(city);
  }
  
  @GetMapping("city_state")
  Iterable<User> byCityAndState(@RequestParam("city") String city, //
                                @RequestParam("state") String state) {
    return repo.findByAddress_CityAndAddress_State(city, state);
  }
  
  @GetMapping("skills")
  Iterable<User> byAnySkills(@RequestParam("skills") Set<String> skills) {
    return repo.findBySkills(skills);
  }
  
  @GetMapping("skills/all")
  Iterable<User> byAllSkills(@RequestParam("skills") Set<String> skills) {
    return repo.findBySkillsContainingAll(skills);
  }
  
  @GetMapping("search/{q}")
  Iterable<User> fullTextSearch(@PathVariable("q") String q) {
    return repo.search(q);
  }
}
