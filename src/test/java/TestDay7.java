package test.java;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;
import main.java.Day7;

public class TestDay7 extends MainTestClass {

  private final Day7 day;

  public TestDay7() {
    day = new Day7("src/test/resources/inputDay7.txt");
    logger = Logger.getLogger(TestDay7.class.getName());
  }

  @Override
  public void testPart1() {
    long sum = day.part1();
    assertEquals(95437, sum);
  }

  @Override
  public void testPart2() {
    long sum = day.part2();
    assertEquals(24933642, sum);
  }
}
