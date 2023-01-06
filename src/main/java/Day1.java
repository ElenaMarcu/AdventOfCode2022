package main.java;

import java.util.Arrays;
import java.util.logging.Logger;

public class Day1 extends MainDay {

  private final long[] myStack = {0, 0, 0};

  public Day1(String fileName) {
    lines = UtilClass.readLines(fileName);
    logger = Logger.getLogger(Day1.class.getName());
  }

  private void verifyIsTopThree(long currentNoOfCalories) {
    if (currentNoOfCalories >= myStack[0]) {
      addFirst(currentNoOfCalories);
    } else if (currentNoOfCalories > myStack[2]) {
      addLast(currentNoOfCalories);
    }
  }

  @Override
  public long part1() {
    long maxNoOfCalories = 0;
    long currentNoOfCalories = 0;
    for (String line : lines) {
      if (line.isEmpty() || line.isBlank()) {
        if (maxNoOfCalories < currentNoOfCalories) {
          maxNoOfCalories = currentNoOfCalories;
        }
        currentNoOfCalories = 0;
      } else {
        long value = Long.parseLong(line);
        currentNoOfCalories += value;
      }
    }
    return maxNoOfCalories;
  }

  @Override
  public long part2() {
    long currentNoOfCalories = 0;
    for (String line : lines
    ) {
      if (line.isEmpty() || line.isBlank()) {
        verifyIsTopThree(currentNoOfCalories);
        currentNoOfCalories = 0;
      } else {
        long value = Long.parseLong(line);
        currentNoOfCalories += value;
      }
    }
    verifyIsTopThree(currentNoOfCalories);
    return Arrays.stream(myStack).sum();
  }

  private void addFirst(long value) {
    myStack[2] = myStack[1];
    myStack[1] = myStack[0];
    myStack[0] = value;
  }

  private void addLast(long value) {
    if (value > myStack[1]) {
      myStack[2] = myStack[1];
      myStack[1] = value;
    } else {
      myStack[2] = value;
    }
  }
}
