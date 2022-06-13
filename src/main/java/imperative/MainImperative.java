package imperative;

import static datainfo.DataInfo.Gender.*;

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


