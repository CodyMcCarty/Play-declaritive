package declarative;

import datainfo.DataInfo;
import datainfo.DataInfo.Gender;
import datainfo.DataInfo.Person;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _Streams {

  public static void main(String[] args) {
    DataInfo di = new DataInfo();
    List<Person> people = di.generatePeople();

    Set<Gender> genders = people.stream()
        .map(person -> person.getGender())
        .collect(Collectors.toSet());
  }

}
