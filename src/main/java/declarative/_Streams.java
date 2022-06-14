package declarative;

import datainfo.DataInfo;
import datainfo.DataInfo.Gender;
import datainfo.DataInfo.Person;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class _Streams {

  public static void main(String[] args) {
    DataInfo di = new DataInfo();
    List<Person> people = di.generatePeople();

    Set<Gender> genders = people.stream()
        .map(person -> person.getGender())
        .collect(Collectors.toSet());

    // promoted to var
    Function<Person, String> personStringFunction = person -> person.getName();
    Function<String, Integer> stringIntegerFunction = name -> name.length();
    Collector<Integer, ?, List<Integer>> integerListCollector = Collectors.toList();
    Predicate<Integer> integerPredicate = length -> length > 0;
    List<Integer> nameLengths = people.stream()
        .map(personStringFunction)
        .map(stringIntegerFunction)
        .filter(integerPredicate)
        .collect(integerListCollector);
  }

}
