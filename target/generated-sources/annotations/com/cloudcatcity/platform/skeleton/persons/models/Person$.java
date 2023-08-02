package com.cloudcatcity.platform.skeleton.persons.models;

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
  public static Field lastName;

  public static Field age;

  public static Field personalStatement;

  public static Field homeLoc;

  public static Field skills;

  public static Field id;

  public static Field address_state;

  public static Field address_country;

  public static Field address_houseNumber;

  public static Field address_postalCode;

  public static Field address_street;

  public static Field address_city;

  public static Field firstName;

  public static TextTagField<Person, String> LAST_NAME;

  public static NumericField<Person, Integer> AGE;

  public static TextField<Person, String> PERSONAL_STATEMENT;

  public static GeoField<Person, Point> HOME_LOC;

  public static TagField<Person, Set<String>> SKILLS;

  public static TextTagField<Person, String> ID;

  public static TextTagField<Person, String> ADDRESS_STATE;

  public static TextTagField<Person, String> ADDRESS_COUNTRY;

  public static TextTagField<Person, String> ADDRESS_HOUSE_NUMBER;

  public static TextTagField<Person, String> ADDRESS_POSTAL_CODE;

  public static TextField<Person, String> ADDRESS_STREET;

  public static TextTagField<Person, String> ADDRESS_CITY;

  public static TextTagField<Person, String> FIRST_NAME;

  public static MetamodelField<Person, String> _KEY;

  static {
    try {
      lastName = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "lastName");
      age = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "age");
      personalStatement = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "personalStatement");
      homeLoc = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "homeLoc");
      skills = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "skills");
      id = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "id");
      address_state = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "address").getType(), "state");
      address_country = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "address").getType(), "country");
      address_houseNumber = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "address").getType(), "houseNumber");
      address_postalCode = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "address").getType(), "postalCode");
      address_street = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "address").getType(), "street");
      address_city = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "address").getType(), "city");
      firstName = com.redis.om.spring.util.ObjectUtils.getDeclaredFieldTransitively(Person.class, "firstName");
      LAST_NAME = new TextTagField<Person, String>(new SearchFieldAccessor("lastName", "$.lastName", lastName),true);
      AGE = new NumericField<Person, Integer>(new SearchFieldAccessor("age", "$.age", age),true);
      PERSONAL_STATEMENT = new TextField<Person, String>(new SearchFieldAccessor("personalStatement", "$.personalStatement", personalStatement),true);
      HOME_LOC = new GeoField<Person, Point>(new SearchFieldAccessor("homeLoc", "$.homeLoc", homeLoc),true);
      SKILLS = new TagField<Person, Set<String>>(new SearchFieldAccessor("skills", "$.skills", skills),true);
      ID = new TextTagField<Person, String>(new SearchFieldAccessor("id", "$.id", id),true);
      ADDRESS_STATE = new TextTagField<Person, String>(new SearchFieldAccessor("address_state", "$.address.state", address_state),true);
      ADDRESS_COUNTRY = new TextTagField<Person, String>(new SearchFieldAccessor("address_country", "$.address.country", address_country),true);
      ADDRESS_HOUSE_NUMBER = new TextTagField<Person, String>(new SearchFieldAccessor("address_houseNumber", "$.address.houseNumber", address_houseNumber),true);
      ADDRESS_POSTAL_CODE = new TextTagField<Person, String>(new SearchFieldAccessor("address_postalCode", "$.address.postalCode", address_postalCode),true);
      ADDRESS_STREET = new TextField<Person, String>(new SearchFieldAccessor("address_street", "$.address.street", address_street),true);
      ADDRESS_CITY = new TextTagField<Person, String>(new SearchFieldAccessor("address_city", "$.address.city", address_city),true);
      FIRST_NAME = new TextTagField<Person, String>(new SearchFieldAccessor("firstName", "$.firstName", firstName),true);
      _KEY = new MetamodelField<Person, String>("__key", String.class, true);
    } catch(NoSuchFieldException | SecurityException e) {
      System.err.println(e.getMessage());
    }
  }
}
