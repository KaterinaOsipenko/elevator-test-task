package com.mypackage.model;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

  private static int step;
  private final int capacity = 5;
  private final Building building = Building.getInstance();
  private final List<Person> personList;
  private Direction direction;
  private int currentFloor;
  private List<Integer> desiredFloors;
  public Elevator() {
    step = 1;
    direction = Direction.UP;
    personList = new ArrayList<>();
  }
  public void start() {
    currentFloor = getFloor(1).getLabel();
    getIn();
    getAllFloors();
    ride();
  }
  private void ride() {
    if (step > 100) {
      System.out.println("Elevator sleep!!");
      return;
    }
    displayStep();
    currentFloor += direction == Direction.UP ? 1 : -1;
    if (currentFloor == building.getMaxFloor()) {
      direction = Direction.DOWN;
    } else if (currentFloor == 1) {
      direction = Direction.UP;
    }
    if (desiredFloors.contains(currentFloor) || personList.size() < capacity) {
      getOut();
      if (personList.size() < capacity) {
        getIn();
      }
      getAllFloors();
    }
    ride();
  }
  private void displayStep() {
    StringBuilder steps = new StringBuilder();
    steps.append("\t\t\tStep ").append(step).append("\n");
    for (Floor floor : building.getFloorsList()) {
      if (floor.getLabel() == currentFloor) {
        steps.append(personList.size()).append(" |").append(floor.getLabel()).append("^   ")
            .append(floor.getLabel()).append("^|   ");
      } else {
        steps.append("  |").append(floor.getLabel()).append("    ").append(floor.getLabel())
            .append("|   ");
      }
      for (Person person : floor.getPeopleList()) {
        steps.append(person.getDesiredFloor()).append(" ");
      }
      steps.append("\n");
    }
    step++;
    System.out.println(steps);
  }
  private Floor getFloor(int label) {
    return building.getFloorsList().stream().filter(floor -> floor.getLabel() == label).findAny()
        .get();
  }
  private void getAllFloors() {
    if (desiredFloors == null) {
      desiredFloors = new ArrayList<>();
    } else {
      desiredFloors.clear();
    }
    for (Person person : personList) {
      desiredFloors.add(person.getDesiredFloor());
    }
  }
  private void getOut() {
    Floor floor = getFloor(currentFloor);
    while (personList.stream().anyMatch(person -> person.getDesiredFloor() == currentFloor)) {
      Person personInElevator = personList.stream()
          .filter(person -> person.getDesiredFloor() == currentFloor)
          .findAny().get();
      floor.getPeopleList().add(personInElevator);
      personList.remove(personInElevator);
      personInElevator.setCurrentFloor(currentFloor);
      personInElevator.chooseFloor();
    }
  }
  private void getIn() {
    Floor floor = getFloor(currentFloor);

    if (direction == Direction.UP) {
      while (floor.getPeopleList().stream()
          .anyMatch(person -> person.getDesiredFloor() > currentFloor)
          && personList.size() < capacity) {
        Person personOnFloor = floor.getPeopleList().stream()
            .filter(person -> person.getDesiredFloor() > currentFloor).findAny().get();
        personList.add(personOnFloor);
        floor.getPeopleList().remove(personOnFloor);
      }
    } else {
      while (floor.getPeopleList().stream()
          .anyMatch(person -> person.getDesiredFloor() < currentFloor)
          && personList.size() < capacity) {
        Person personOnFloor = floor.getPeopleList().stream()
            .filter(person -> person.getDesiredFloor() < currentFloor).findAny().get();
        personList.add(personOnFloor);
        floor.getPeopleList().remove(personOnFloor);
      }
    }
  }
}
