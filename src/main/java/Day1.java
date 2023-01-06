package main.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Day1 extends MainDay {

  private final Deque<Long> myStack;

  public Day1(String fileName) {
    lines = UtilClass.readLines(fileName);
    logger = Logger.getLogger(Day1.class.getName());
    myStack = new ArrayDeque<>();
    myStack.addAll(Arrays.asList(0L, 0L, 0L));
  }

  private void verifyIsTopThree(long currentNoOfCalories) {
    long first = myStack.peekFirst() == null ? 0 : myStack.getFirst();
    long last = myStack.peekLast() == null ? 0 : myStack.getLast();
    if (currentNoOfCalories >= first) {
      myStack.addFirst(currentNoOfCalories);
      myStack.removeLast();
    } else if (currentNoOfCalories > last) {
      myStack.removeLast();
      last = myStack.peekLast() == null ? 0 : myStack.getLast();
      if (currentNoOfCalories > last) {
        long temp = myStack.removeLast();
        myStack.addLast(currentNoOfCalories);
        myStack.addLast(temp);
      } else {
        myStack.addLast(currentNoOfCalories);
      }
    }
  }

  @Override
  public Long part1() {
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
  public Long part2() {
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
    return myStack.stream().reduce(0L, Long::sum);
  }

}
