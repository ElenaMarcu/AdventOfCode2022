package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Day8 extends MainDay {

  private final List<Map<Integer, Integer>> noFromCols;
  private final List<Map<Integer, Integer>> noFromLines;
  private final Integer[] maxFromCols;
  private Integer[][] mapOfTrees;

  public Day8(String fileName) {
    logger = Logger.getLogger(Day8.class.getName());
    lines = UtilClass.readLines(fileName);
    noFromCols = new ArrayList<>(lines.size());
    noFromLines = new ArrayList<>(lines.size());
    maxFromCols = new Integer[lines.size()];
    for (int i = 0; i < lines.size(); i++) {
      noFromCols.add(new HashMap<>());
      maxFromCols[i] = 0;
    }
    createMapOfTrees();
  }

  private void createMapOfTrees() {
    mapOfTrees = new Integer[lines.size()][lines.size()];
    int i = 0;
    for (String line : lines) {
      Map<Integer, Integer> lineElements = new HashMap<>();
      int j = 0;
      for (char ch : line.toCharArray()) {
        int val = Character.getNumericValue(ch);
        if (j > 0) {
          lineElements.putIfAbsent(val, 0);
          lineElements.computeIfPresent(val, (k, x) -> x = x + 1);
        }
        if (i == 0) {
          maxFromCols[j] = val;
        } else {
          noFromCols.get(j).putIfAbsent(val, 0);
          noFromCols.get(j).computeIfPresent(val, (k, x) -> x = x + 1);

        }
        mapOfTrees[i][j++] = val;
      }
      noFromLines.add(lineElements);
      i++;
    }
  }

  @Override
  public Integer part1() {
    int noOfTrees = 4 * lines.size() - 4;
    for (int i = 1; i < lines.size() - 1; i++) {
      int maxLine = mapOfTrees[i][0];
      for (int j = 1; j < lines.size() - 1; j++) {
        int currentTree = mapOfTrees[i][j];
        if (currentTree > maxLine && currentTree > maxFromCols[j]) {
          maxLine = currentTree;
          maxFromCols[j] = currentTree;
          noOfTrees++;
        } else if (currentTree > maxLine) {
          maxLine = currentTree;
          noOfTrees++;
        } else if (currentTree > maxFromCols[j]) {
          maxFromCols[j] = currentTree;
          noOfTrees++;
        } else if (isVisible(currentTree, noFromCols.get(j)) || isVisible(currentTree,
            noFromLines.get(i))) {
          noOfTrees++;
        }
        updateMap(currentTree, noFromCols.get(j));
        updateMap(currentTree, noFromLines.get(i));
      }
    }
    return noOfTrees;
  }

  private boolean isVisible(int currentTree, Map<Integer, Integer> presenceMap) {
    if (presenceMap.get(currentTree) > 1) {
      return false;
    }

    for (int i = currentTree + 1; i < 10; i++) {
      if (presenceMap.containsKey(i)) {
        return false;
      }
    }
    return true;
  }

  private void updateMap(int currentTree, Map<Integer, Integer> presenceMap) {
    if (presenceMap.get(currentTree) == 1) {
      presenceMap.remove(currentTree);
    }
    presenceMap.computeIfPresent(currentTree, (k, x) -> x = x - 1);
  }


  @Override
  public Integer part2() {
    int highestScenicScore = 0;
    for (int i = 1; i < lines.size() - 1; i++) {
      for (int j = 1; j < lines.size() - 1; j++) {
        int currentScenicScore = computeScenicScore(i, j);
        if (currentScenicScore > highestScenicScore) {
          highestScenicScore = currentScenicScore;
        }
      }
    }
    return highestScenicScore;
  }

  private int computeScenicScore(int i, int j) {
    if (mapOfTrees[i][j] == 0) {
      return 1;
    }
    return getLeftIndex(i, j) * getRightIndex(i, j) * getUpIndex(i, j) * getDownIndex(i, j);
  }

  private int getDownIndex(int line, int column) {
    for (int i = line + 1; i < mapOfTrees.length - 1; i++) {
      if (mapOfTrees[i][column] >= mapOfTrees[line][column]) {
        return i - line;
      }
    }
    return mapOfTrees.length - line - 1;
  }

  private int getUpIndex(int line, int column) {
    for (int i = line - 1; i > 0; i--) {
      if (mapOfTrees[i][column] >= mapOfTrees[line][column]) {
        return line - i;
      }
    }
    return line;
  }

  private int getRightIndex(int line, int column) {
    for (int j = column + 1; j < mapOfTrees.length - 1; j++) {
      if (mapOfTrees[line][j] >= mapOfTrees[line][column]) {
        return j - column;
      }
    }
    return mapOfTrees.length - column - 1;
  }

  private int getLeftIndex(int line, int column) {
    for (int j = column - 1; j > 0; j--) {
      if (mapOfTrees[line][j] >= mapOfTrees[line][column]) {
        return column - j;
      }
    }
    return column;
  }
}
