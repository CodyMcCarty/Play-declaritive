package declarative;

import static datainfo.DataInfo.Gender.FEMALE;
import static datainfo.DataInfo.Gender.MALE;

import datainfo.DataInfo;
import datainfo.DataInfo.Person;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import org.w3c.dom.ls.LSOutput;

public class MainDeclarative {

  public static void main(String[] args) {
    DataInfo d = new DataInfo();

    List<Person> people = d.generatePeople();
    List<Person> females =
        people.stream()
            .filter(person -> person.getGender().equals(FEMALE))
            .collect(Collectors.toList());

    // as a Predicate(true or false), I `introduced var` to:
    // `person -> person.getGender().equals(FEMALE)`
    Predicate<Person> isMale = person -> person.getGender().equals(MALE);
    List<Person> males = people.stream().filter(isMale).collect(Collectors.toList());
  }

}

// messing around with functional interface
class _FunctionDec {
  public static void main(String[] args) {
    DataInfo d = new DataInfo();
    int plusOne = increment.apply(1);
    int tenFold = timesTen.apply(plusOne);

    Function<Integer, Integer> addOneThenTimesTen = increment
        .andThen(timesTen);
    int fifty = addOneThenTimesTen.apply(4);
    int thirty = increment
        .andThen(timesTen).apply(2);
    int fortyNine = numPlusTwoTimesBy.apply(5, 7);
    greeting.accept(new Person("Cody", MALE));
    greetingDu.accept(new Person("Barbie", FEMALE), true);
    greetingDu.accept(new Person("Sally", FEMALE), false);
    boolean isFalse = isMale.test(new Person("May", FEMALE));
    boolean isFalse2 = isStartWithC.test(new Person("Kody", MALE));
    boolean isTrue = isStartWithC.test(new Person("Cody", MALE));
    boolean isTrue2 = isMale
        .and(isStartWithC)
        .test(new Person("Cody", MALE));

    Supplier<String> getDbConnecitonUrl = () -> "jdbc://localhost:5432/users";
    String DBUrl = getDbConnecitonUrl.get();
    Supplier<List<Person>> getPeople = () -> d.generatePeople();
    List<Person> people = getPeople.get();
  }

  static Function<Integer, Integer> increment = num -> num + 1;
  static Function<Integer, Integer> timesTen = num -> num * 10;
  static BiFunction<Integer, Integer, Integer> numPlusTwoTimesBy = (num, multiplyBy) ->
      (num + 2) * multiplyBy;
  static Consumer<Person> greeting = person -> {
    System.out.println( new StringBuilder()
        .append("Hello ")
        .append(person.getGender().equals(MALE) ? "Mr. ": "Ms. ")
        .append(person.getName())
        .append(", How you liking Declarative?")
    );
  };
  static BiConsumer<Person, Boolean> greetingDu = (person, isGerman) -> {
    if (!isGerman) {
      greeting.accept(person);
    } else {
      System.out.println(
          new StringBuilder()
              .append("Hallo ")
              .append(person.getGender().equals(MALE) ? "Herr " : "Frau ")
              .append(person.getName())
              .append(", verwenden Sie gerne Deklarative?")
      );
    }
  };
  static Predicate<Person> isMale = (person) -> person.getGender().equals(MALE);
  static Predicate<Person> isStartWithC = (person) -> person.getName().startsWith("C");


}
