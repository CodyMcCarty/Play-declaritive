package imperative;

import static datainfo.DataInfo.Gender.FEMALE;
import static datainfo.DataInfo.Gender.MALE;

import datainfo.DataInfo;
import datainfo.DataInfo.Person;
import java.util.ArrayList;
import java.util.List;

public class MainImperative {

  public static void main(String[] args) {
    DataInfo d = new DataInfo();

    List<Person> people = d.generatePeople();
    List<Person> females = new ArrayList<>();

    for (Person person : people) {
      if (person.getGender().equals(FEMALE)) {
        females.add(person);
      }
    }
  }
}
/*
 * adding extra space to make MainImperative line up with MainDeclarative
 * info found here:
 *  https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/package-summary.html
 *
 * */

class _FunctionImp {
  public static void main(String[] args) {
    int plusOne = increment(1);
    int fortyNine = numPlusTwoTimesBy(5, 7);
    greeting(new Person("Cody", MALE));
  }

  static int increment(int num) {
    return num += 1;
  }

  static int numPlusTwoTimesBy(int num, int multiplyBy) {
    return (num + 2) * multiplyBy;
  }

  static void greeting(Person person) {
      System.out.println( new StringBuilder()
          .append("Hello ")
          .append(person.getGender().equals(MALE) ? "Mr. ": "Ms. ")
          .append(person.getName())
          .append(", Still using imperative, eh?")
      );
  }
}
