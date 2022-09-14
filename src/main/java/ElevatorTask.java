import model.Building;
import model.Elevator;

public class ElevatorTask {

  public static void main(String[] args) {
    Building building = Building.getInstance();
    Elevator elevator = new Elevator();
    building.setElevator(elevator);
    building.start();
  }

}
