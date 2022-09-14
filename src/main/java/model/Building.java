package model;

import java.util.ArrayList;
import java.util.List;

public class Building {

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
    int floors = (int) (Math.random() * (21 - 5 + 1) + 5);
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
