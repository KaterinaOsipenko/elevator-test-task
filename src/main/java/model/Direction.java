package model;

public enum Direction {

  UP("up"),
  DOWN("down");

  private final String label;

  Direction(String label) {
    this.label = label;
  }

  public String getLabel() {
    return this.label;
  }
}
