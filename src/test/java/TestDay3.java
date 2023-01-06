package test.java;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;
import main.java.Day3;
import org.junit.Test;

public class TestDay3 extends MainTestClass {

  private final Day3 day;

  public TestDay3() {
    logger = Logger.getLogger(TestDay3.class.getName());
    day = new Day3("src/test/resources/inputDay3.txt");
  }

  @Test
  public void testPart1() {
    long part1Result = day.part1();
    assertEquals(157, part1Result);
  }

  @Test
  public void testPart2() {
    long part2Result = day.part2();
    assertEquals(70, part2Result);
  }
}
