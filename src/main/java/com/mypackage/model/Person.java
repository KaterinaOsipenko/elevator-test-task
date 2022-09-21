package com.mypackage.model;

public class Person {
  private final Building building = Building.getInstance();
  private int currentFloor;
  private int desiredFloor;
  public Person(int currentFloor) {
    this.currentFloor = currentFloor;
    chooseFloor();
  }
  public void chooseFloor() {
    int desiredFloorNumber = (int) (Math.random() * (building.getMaxFloor()) + 1);
    if (desiredFloorNumber == currentFloor) {
      if (desiredFloorNumber == building.getMaxFloor()) {
        desiredFloorNumber -= 1;
      } else {
        desiredFloorNumber += 1;
      }
    }
    desiredFloor = desiredFloorNumber;
    System.out.println("Person " + currentFloor + " " + desiredFloorNumber);
  }
  public int getDesiredFloor() {
    return desiredFloor;
  }
  public void setCurrentFloor(int currentFloor) {
    this.currentFloor = currentFloor;
  }
}
