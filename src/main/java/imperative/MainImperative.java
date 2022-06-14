package imperative;

import static datainfo.DataInfo.Gender.FEMALE;

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
 *
 * */

class _Function {
  public static void main(String[] args) {
    int plusOne = increment(1);
  }

  static int increment(int num) {
    return num += 1;
  }
}
