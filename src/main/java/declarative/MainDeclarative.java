package declarative;

import static datainfo.DataInfo.Gender.*;

import datainfo.DataInfo;
import datainfo.DataInfo.Person;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainDeclarative {

  public static void main(String[] args) {
    DataInfo d = new DataInfo();

    List<Person> people = d.generatePeople();
    List<Person> females = people.stream()
        .filter(person -> person.getGender().equals(FEMALE))
        .collect(Collectors.toList());

    // as a Predicate
    Predicate<Person> isMale = person -> person.getGender().equals(MALE);
    List<Person> males = people.stream()
        .filter(isMale)
        .collect(Collectors.toList());

  }

}
