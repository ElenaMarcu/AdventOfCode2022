package main.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class Day12 extends MainDay {

  private char[][] chars;
  private Point startPoint;
  private Point endPoint;
  private List<Point> startingPoints;

  public Day12(String fileName) {
    logger = Logger.getLogger(Day12.class.getName());
    lines = UtilClass.readLines(fileName);
    initVars();
  }

  private void initVars() {
    chars = new char[lines.size()][lines.get(0).length()];
    startingPoints = new ArrayList<>();
    int i = 0;
    for (String line : lines) {
      chars[i] = line.toCharArray();
      if (line.contains("S")) {
        startPoint = new Point(i, line.indexOf("S"));
        chars[startPoint.getX()][startPoint.getY()] = 'a';
      }
      if (line.contains("E")) {
        endPoint = new Point(i, line.indexOf("E"));
        chars[endPoint.getX()][endPoint.getY()] = 'z';
      }
      findALocations(i);
      i++;
    }
  }

  private void findALocations(int i) {
    for (int j = 0; j < chars[0].length; j++) {
      if (chars[i][j] == 'a') {
        startingPoints.add(new Point(i, j));
      }
    }
  }

  @Override
  public Integer part1() {
    return shortestPathBFS(startPoint, endPoint);
  }

  private Integer shortestPathBFS(Point startPoint, Point endPoint) {
    Deque<Point> queue = new ArrayDeque<>();
    Set<Point> visited = new HashSet<>();
    Map<Point, Point> parent = new HashMap<>();
    queue.add(startPoint);
    visited.add(startPoint);
    while (!queue.isEmpty()) {
      Point currentPoint = queue.removeFirst();
      char elevation = chars[currentPoint.getX()][currentPoint.getY()];
      List<Point> directions = getDirections(currentPoint);
      for (Point direction : directions) {
        char newElevation = chars[direction.getX()][direction.getY()];
        if (elevation - newElevation >= -1 && !visited.contains(direction)) {
          queue.addLast(direction);
          visited.add(direction);
          parent.put(direction, currentPoint);
          if (direction.equals(endPoint)) {
            return getDistance(parent, endPoint);
          }

        }
      }
    }
    return Integer.MAX_VALUE;
  }

  private int getDistance(Map<Point, Point> parent, Point endPoint) {
    Set<Point> path = new HashSet<>();
    Point node = endPoint;
    while (node != null) {
      path.add(node);
      node = parent.get(node);
    }
    return path.size() - 1;
  }

  private List<Point> getDirections(Point currentPoint) {
    List<Point> directions = new ArrayList<>();
    for (Direction direction : Direction.values()) {
      int newLine = currentPoint.getX() + direction.getX();
      int newColumn = currentPoint.getY() + direction.getY();
      if (0 <= newLine && newLine < chars.length && 0 <= newColumn
          && newColumn < chars[0].length) {
        directions.add(new Point(newLine, newColumn));
      }
    }
    return directions;
  }

  @Override
  public Integer part2() {
    int min = Integer.MAX_VALUE;
    for (Point point : startingPoints) {
      min = Integer.min(min, shortestPathBFS(point, endPoint));
    }
    return min;
  }

  private enum Direction {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1);

    private final int x;
    private final int y;

    Direction(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }
}
