package com.mypackage.model;

public class ElevatorTask {

  public static void main(String[] args) {
    Building building = Building.getInstance();
    Elevator elevator = new Elevator();
    building.setElevator(elevator);
    building.start();
  }

}
