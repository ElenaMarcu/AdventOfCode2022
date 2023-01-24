package test.java;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;
import main.java.Day8;

public class TestDay8 extends MainTestClass {

  private final Day8 day;

  public TestDay8() {
    day = new Day8("src/test/resources/inputDay8.txt");
    logger = Logger.getLogger(TestDay8.class.getName());
  }

  @Override
  public void testPart1() {
    int noOfTrees = day.part1();
    assertEquals(21, noOfTrees);
  }

  @Override
  public void testPart2() {
    int noOfTrees = day.part2();
    assertEquals(8, noOfTrees);
  }
}
