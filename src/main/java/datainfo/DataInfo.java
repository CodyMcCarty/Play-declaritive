package datainfo;

import static datainfo.DataInfo.Gender.FEMALE;
import static datainfo.DataInfo.Gender.MALE;

import java.util.List;
import lombok.Data;

public class DataInfo {

  @Data
  public static class Person {
    private final String name;
    private final Gender gender;
  }

  public enum Gender {
    MALE,
    FEMALE
  }

  public List<Person> generatePeople() {
    return List.of(
        new Person("John", MALE),
        new Person("Dave", MALE),
        new Person("Tom", MALE),
        new Person("Sally", FEMALE),
        new Person("Mary", FEMALE),
        new Person("Jane", FEMALE));
  }

}
