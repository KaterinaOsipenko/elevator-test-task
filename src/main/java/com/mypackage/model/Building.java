package com.mypackage.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Building {

  private static final int MAX_FLOOR = 21;
  private static final int MIN_FLOOR = 5;
  private static Building building = null;
  private List<Floor> floorsList;
  private Elevator elevator;
  private int maxFloor;

  private Building() {
    System.out.println("Building create");
  }

  public static Building getInstance() {
    if (building == null) {
      building = new Building();
    }
    return building;
  }

  public void setElevator(Elevator elevator) {
    this.elevator = elevator;
  }

  public void start() {
    Random random = new Random();
    int floors = random.nextInt((MAX_FLOOR - MIN_FLOOR) + 1) + MIN_FLOOR;
    setMaxFloor(floors);
    createFloors();
    elevator.start();
  }

  public int getMaxFloor() {
    return maxFloor;
  }

  public void setMaxFloor(int maxFloor) {
    this.maxFloor = maxFloor;
  }

  public List<Floor> getFloorsList() {
    return floorsList;
  }

  private void createFloors() {
    System.out.println("Create floors " + maxFloor);
    floorsList = new ArrayList<>(maxFloor);
    for (int i = 0; i < maxFloor; i++) {
      int label = i + 1;
      Floor floor = new Floor(label);
      if (i + 1 == 1) {
        floor.setFirst(true);
      } else if (i == maxFloor - 1) {
        floor.setLast(true);
      }
      floorsList.add(floor);
    }
  }
}
