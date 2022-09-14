package model;

import java.util.ArrayList;
import java.util.List;

public class Floor {

  private final int label;
  private final PeopleBirth peopleBirth = new PeopleBirth();
  private List<Direction> directionList;
  private boolean isFirst;
  private boolean isLast;
  private List<Person> peopleList;

  public Floor(int label) {
    this.label = label;
    isFirst = false;
    isLast = false;
    createPeople();
    createDirection();
  }

  private void createPeople() {
    peopleList = peopleBirth.createPeople(label);
  }

  private void createDirection() {
    directionList = new ArrayList<>();
    if (isFirst) {
      directionList.add(Direction.UP);
    } else if (isLast) {
      directionList.add(Direction.DOWN);
    } else {
      directionList.add(Direction.UP);
      directionList.add(Direction.DOWN);
    }
  }

  public void setFirst(boolean first) {
    isFirst = first;
  }


  public void setLast(boolean last) {
    isLast = last;
  }

  public int getLabel() {
    return label;
  }

  public List<Person> getPeopleList() {
    return peopleList;
  }
}
