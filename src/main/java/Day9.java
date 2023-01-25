package main.java;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import main.java.Knot.Direction;

public class Day9 extends MainDay {

  private Set<String> visitedPositions;
  private Knot[] knots;

  public Day9(String fileName) {
    logger = Logger.getLogger(Day9.class.getName());
    lines = UtilClass.readLines(fileName);
  }

  @Override
  public Integer part1() {
    startMotion(2);
    return visitedPositions.size();
  }

  @Override
  public Integer part2() {
    startMotion(10);
    return visitedPositions.size();
  }

  private void startMotion(int size) {
    initVars(size);
    for (String line : lines) {
      String[] values = line.split(" ");
      Direction direction = getDirection(values[0]);
      int steps = Integer.parseInt(values[1]);
      moveKnots(direction, steps);
    }
  }

  private void initVars(int size) {
    visitedPositions = new HashSet<>();
    knots = new Knot[size];
    for (int i = 0; i < size; i++) {
      knots[i] = new Knot(0, 0);
    }
  }

  private void moveKnots(Direction direction, int steps) {
    for (int j = 0; j < steps; j++) {
      knots[0].moveHead(direction);
      for (int i = 1; i < knots.length; i++) {
        knots[i].moveTail(knots[i - 1]);
      }
      visitedPositions.add(knots[knots.length - 1].getCurrentPosition());
    }
  }


  private Direction getDirection(String value) {
    switch (value) {
      case "D":
        return Direction.DOWN;
      case "U":
        return Direction.UP;
      case "R":
        return Direction.RIGHT;
      case "L":
        return Direction.LEFT;
      default:
        return null;
    }
  }


}
