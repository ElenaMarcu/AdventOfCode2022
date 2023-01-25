package test.java;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;
import main.java.Day9;

public class TestDay9 extends MainTestClass {

  private final Day9 day;

  public TestDay9() {
    day = new Day9("src/test/resources/inputDay9.txt");
    logger = Logger.getLogger(TestDay9.class.getName());
  }

  @Override
  public void testPart1() {
    int visitedPositions = day.part1();
    assertEquals(13, visitedPositions);
  }

  @Override
  public void testPart2() {
    int visitedPositions = day.part2();
    assertEquals(1, visitedPositions);
  }
}
