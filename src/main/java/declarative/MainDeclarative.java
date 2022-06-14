package declarative;

import static datainfo.DataInfo.Gender.FEMALE;
import static datainfo.DataInfo.Gender.MALE;

import datainfo.DataInfo;
import datainfo.DataInfo.Person;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainDeclarative {

  public static void main(String[] args) {
    DataInfo d = new DataInfo();

    List<Person> people = d.generatePeople();
    List<Person> females =
        people.stream()
            .filter(person -> person.getGender().equals(FEMALE))
            .collect(Collectors.toList());

    // as a Predicate
    Predicate<Person> isMale = person -> person.getGender().equals(MALE);
    List<Person> males = people.stream().filter(isMale).collect(Collectors.toList());
  }

}

class _Function {
  public static void main(String[] args) {
    int plusOne = increment.apply(1);
    int tenFold = timesTen.apply(plusOne);

    Function<Integer, Integer> addOneThenTimesTen = increment
        .andThen(timesTen);
    int fifty = addOneThenTimesTen.apply(4);
    int thirty = increment
        .andThen(timesTen).apply(2);
  }

  static Function<Integer, Integer> increment = num -> num + 1;
  static Function<Integer, Integer> timesTen = num -> num * 10;
}
