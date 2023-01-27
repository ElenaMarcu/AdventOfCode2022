package main.java;

import java.util.Arrays;
import java.util.logging.Logger;

public class Day10 extends MainDay {

  private int x = 1;
  private int cycle = 1;
  private long signalStrength = 0;
  private char[][] crt;
  private Sprite sprite;

  public Day10(String fileName) {
    logger = Logger.getLogger(Day10.class.getName());
    lines = UtilClass.readLines(fileName);
  }

  @Override
  public Long part1() {
    for (String line : lines) {
      if ("noop".equals(line)) {
        basicInstruction();
      } else {
        int v = Integer.parseInt((line.split("\\s+"))[1]);
        executeAddxInstruction(v);
      }
    }
    return signalStrength;
  }

  private void executeAddxInstruction(int v) {
    basicInstruction();
    cycle++;
    x += v;
    checkCycle();
  }

  private void basicInstruction() {
    cycle++;
    checkCycle();
  }

  private void checkCycle() {
    if (Arrays.asList(20, 60, 100, 140, 180, 220).contains(cycle)) {
      signalStrength += (long) cycle * x;
    }
  }

  @Override
  public String part2() {
    sprite = new Sprite();
    crt = new char[6][40];
    x = 1;
    cycle = 1;
    for (String line : lines) {
      if ("noop".equals(line)) {
        updateCrt();
      } else {
        int v = Integer.parseInt((line.split("\\s+"))[1]);
        updateCrt();
        updateCrt();
        x += v;
        sprite.updateSprite(x);
      }
    }

    return getMessage();
  }

  private String getMessage() {
    StringBuilder messageToPrint = new StringBuilder();
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 40; j++) {
        messageToPrint.append(crt[i][j]);
      }
      if (i < 5) {
        messageToPrint.append(System.lineSeparator());
      }
    }
    return messageToPrint.toString();
  }

  private void updateCrt() {
    int xCycle = (cycle - 1) / 40;
    int yCycle = (cycle - 1) % 40;
    crt[xCycle][yCycle] = sprite.getPixelValue(yCycle);
    cycle++;

  }
}
