package model;

import java.util.ArrayList;
import java.util.List;

public class PeopleBirth {

  public List<Person> createPeople(int label) {
    int peopleNumber = (int) (Math.random() * 11);
    List<Person> personList = new ArrayList<>(label);
    for (int i = 0; i < peopleNumber; i++) {
      Person person = new Person(label);
      personList.add(person);
    }
    return personList;
  }

}
