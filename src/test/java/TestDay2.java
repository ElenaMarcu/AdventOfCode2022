package test.java;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;
import main.java.Day2;
import org.junit.Test;

public class TestDay2 extends MainTestClass {

  private final Day2 day;

  public TestDay2() {
    logger = Logger.getLogger(TestDay2.class.getName());
    day = new Day2("src/test/resources/inputDay2.txt");
  }

  @Test
  public void testPart1() {
    long part1Result = day.part1();
    assertEquals(15, part1Result);
  }

  @Test
  public void testPart2() {
    long part2Result = day.part2();
    assertEquals(12, part2Result);
  }
}
