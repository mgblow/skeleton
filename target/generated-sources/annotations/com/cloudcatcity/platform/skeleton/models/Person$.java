package com.cloudcatcity.platform.skeleton.models;

import com.cloudcatcity.platform.skeleton.persons.models.Person;
import com.redis.om.spring.metamodel.MetamodelField;
import com.redis.om.spring.metamodel.SearchFieldAccessor;
import com.redis.om.spring.metamodel.indexed.GeoField;
import com.redis.om.spring.metamodel.indexed.NumericField;
import com.redis.om.spring.metamodel.indexed.TagField;
import com.redis.om.spring.metamodel.indexed.TextField;
import com.redis.om.spring.metamodel.indexed.TextTagField;
import java.lang.Integer;
import java.lang.NoSuchFieldException;
import java.lang.SecurityException;
import java.lang.String;
import java.lang.reflect.Field;
import java.util.Set;
import org.springframework.data.geo.Point;

public final class Person$ {
  public static Field age;

  public static Field lastName;

  public static Field id;

  public static Field firstName;

  public static Field personalStatement;

  public static Field homeLoc;

  public static Field skills;

  public static NumericField<Person, Integer> AGE;

  public static TextTagField<Person, String> LAST_NAME;

  public static TextTagField<Person, String> ID;

  public static TextTagField<Person, String> FIRST_NAME;

  public static TextField<Person, String> PERSONAL_STATEMENT;

  public static GeoField<Person, Point> HOME_LOC;

  public static TagField<Person, Set<String>> SKILLS;

  public static MetamodelField<Person, String> _KEY;

  static {
    try {
      age = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "age");
      lastName = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "lastName");
      id = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "id");
      firstName = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "firstName");
      personalStatement = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "personalStatement");
      homeLoc = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "homeLoc");
      skills = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "skills");
      AGE = new NumericField<Person, Integer>(new SearchFieldAccessor("age", "$.age", age),true);
      LAST_NAME = new TextTagField<Person, String>(new SearchFieldAccessor("lastName", "$.lastName", lastName),true);
      ID = new TextTagField<Person, String>(new SearchFieldAccessor("id", "$.id", id),true);
      FIRST_NAME = new TextTagField<Person, String>(new SearchFieldAccessor("firstName", "$.firstName", firstName),true);
      PERSONAL_STATEMENT = new TextField<Person, String>(new SearchFieldAccessor("personalStatement", "$.personalStatement", personalStatement),true);
      HOME_LOC = new GeoField<Person, Point>(new SearchFieldAccessor("homeLoc", "$.homeLoc", homeLoc),true);
      SKILLS = new TagField<Person, Set<String>>(new SearchFieldAccessor("skills", "$.skills", skills),true);
      _KEY = new MetamodelField<Person, String>("__key", String.class, true);
    } catch(NoSuchFieldException | SecurityException e) {
      System.err.println(e.getMessage());
    }
  }
}
