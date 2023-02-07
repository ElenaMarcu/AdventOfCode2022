package em.adventofcode.year2022.days;

import static org.junit.Assert.assertEquals;

import em.adventofcode.year2022.MainTestClass;
import java.util.logging.Logger;
import org.junit.Test;

public class TestDay4 extends MainTestClass {
  private final Day4 day;

  public TestDay4() {
    logger = Logger.getLogger(TestDay4.class.getName());
    day = new Day4("src/test/resources/inputDay4.txt");
  }

  @Test
  public void testPart1() {
    long part1Result = day.part1();
    assertEquals(2, part1Result);
  }

  @Test
  public void testPart2() {
    long part2Result = day.part2();
    assertEquals(4, part2Result);
  }
}
