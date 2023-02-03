package test.java;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;
import main.java.Day12;

public class TestDay12 extends MainTestClass {

  private final Day12 day;

  public TestDay12() {
    day = new Day12("src/test/resources/inputDay12.txt");
    logger = Logger.getLogger(TestDay12.class.getName());
  }

  @Override
  public void testPart1() {
    int steps = day.part1();
    assertEquals(31, steps);
  }

  @Override
  public void testPart2() {
    int steps = day.part2();
    assertEquals(29, steps);
  }
}
