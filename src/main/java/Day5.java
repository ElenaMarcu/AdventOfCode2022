package main.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 extends MainDay {

  private final Pattern pattern;
  private Deque<String>[] stacks;
  private Boolean isStackSet = false;
  private Matcher matcher;

  public Day5(String fileName) {
    lines = UtilClass.readLines(fileName);
    logger = Logger.getLogger(Day5.class.getName());
    pattern = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");
  }

  private String printStacks() {
    StringBuilder output = new StringBuilder();
    for (Deque<String> stack : stacks) {
      output.append(stack.getLast());
    }
    isStackSet = false;
    return output.toString();
  }

  private void moveCratesPart1(int noOfCrates, int stackSource, int stackDestination) {
    for (int i = 0; i < noOfCrates; i++) {
      try {
        String crate = stacks[stackSource].removeLast();
        stacks[stackDestination].addLast(crate);
      } catch (
          NoSuchElementException ignored) {
        // do nothing
      }
    }
  }

  private void populateStacks() {
    stacks = new Deque[9];
    Deque<String> hashSet = new ArrayDeque<>(
        Arrays.asList("S", "M", "R", "N", "W", "J", "V", "T"));
    stacks[0] = hashSet;
    hashSet = new ArrayDeque<>(Arrays.asList("B", "W", "D", "J", "Q", "P", "C", "V"));
    stacks[1] = hashSet;
    hashSet = new ArrayDeque<>(Arrays.asList("B", "J", "F", "H", "D", "R", "P"));
    stacks[2] = hashSet;
    hashSet = new ArrayDeque<>(Arrays.asList("F", "R", "P", "B", "M", "N", "D"));
    stacks[3] = hashSet;
    hashSet = new ArrayDeque<>(Arrays.asList("H", "V", "R", "P", "T", "B"));
    stacks[4] = hashSet;
    hashSet = new ArrayDeque<>(Arrays.asList("C", "B", "P", "T"));
    stacks[5] = hashSet;
    hashSet = new ArrayDeque<>(Arrays.asList("B", "J", "R", "P", "L"));
    stacks[6] = hashSet;
    hashSet = new ArrayDeque<>(Arrays.asList("N", "C", "S", "L", "T", "Z", "B", "W"));
    stacks[7] = hashSet;
    hashSet = new ArrayDeque<>(Arrays.asList("L", "S", "G"));
    stacks[8] = hashSet;
  }

  @Override
  public String part1() {
    verifyStacks();
    for (String line : lines) {
      matcher = pattern.matcher(line);
      if (matcher.find()) {
        int noOfCrates = Integer.parseInt(matcher.group(1));
        int stackSource = Integer.parseInt(matcher.group(2)) - 1;
        int stackDestination = Integer.parseInt(matcher.group(3)) - 1;
        moveCratesPart1(noOfCrates, stackSource, stackDestination);
      }
    }
    return printStacks();
  }

  private void verifyStacks() {
    if (Boolean.FALSE.equals(isStackSet)) {
      populateStacks();
    }
  }

  @Override
  public String part2() {
    verifyStacks();
    for (String line : lines) {
      matcher = pattern.matcher(line);
      if (matcher.find()) {
        int noOfCrates = Integer.parseInt(matcher.group(1));
        int stackSource = Integer.parseInt(matcher.group(2)) - 1;
        int stackDestination = Integer.parseInt(matcher.group(3)) - 1;
        moveCratesPart2(noOfCrates, stackSource, stackDestination);
      }
    }
    return printStacks();
  }

  private void moveCratesPart2(int noOfCrates, int stackSource, int stackDestination) {
    Deque<String> tempStack = new ArrayDeque<>();
    for (int i = 0; i < noOfCrates; i++) {
      try {
        String crate = stacks[stackSource].removeLast();
        tempStack.addLast(crate);
      } catch (NoSuchElementException ex) {
        //do nothing
      }
    }
    while (!tempStack.isEmpty()) {
      stacks[stackDestination].addLast(tempStack.removeLast());
    }
  }

  public void setStacks(Deque<String>[] populateDeque) {
    this.stacks = populateDeque;
    isStackSet = true;
  }
}
