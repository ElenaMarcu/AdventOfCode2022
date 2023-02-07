package em.adventofcode.year2022.days;

import static org.junit.Assert.assertEquals;

import em.adventofcode.year2022.MainTestClass;
import java.util.logging.Logger;
import org.junit.Test;

public class TestDay6 extends MainTestClass {

  private final Day6 day;

  public TestDay6() {
    logger = Logger.getLogger(TestDay6.class.getName());
    day = new Day6("src/test/resources/inputDay6.txt");
  }

  @Test
  public void testPart1() {
    int index = day.part1();
    assertEquals(5, index);
  }

  @Test
  public void testPart2() {
    int index = day.part2();
    assertEquals(23, index);
  }
}
