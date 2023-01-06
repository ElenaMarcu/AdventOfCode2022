package test.java;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;
import main.java.Day1;
import org.junit.Test;

public class TestDay1 extends MainTestClass {

  private final Day1 day;

  public TestDay1() {
    logger = Logger.getLogger(TestDay1.class.getName());
    day = new Day1("src/test/resources/inputDay1.txt");
  }

  @Test
  public void testPart1() {
    long part1Result = day.part1();
    assertEquals(24000, part1Result);
  }

  @Test
  public void testPart2() {
    long part2Result = day.part2();
    assertEquals(45000, part2Result);
  }
}
