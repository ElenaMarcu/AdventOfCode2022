package em.adventofcode.year2022.days;

import static org.junit.Assert.assertEquals;

import em.adventofcode.year2022.MainTestClass;
import java.util.logging.Logger;

public class TestDay11 extends MainTestClass {
  private final Day11 day;

  public TestDay11() {
    day = new Day11("src/test/resources/inputDay11.txt");
    logger = Logger.getLogger(TestDay11.class.getName());
  }

  @Override
  public void testPart1() {
    long visitedPositions = day.part1();
    assertEquals(10605, visitedPositions);
  }

  @Override
  public void testPart2() {
    long visitedPositions = day.part2();
    assertEquals(2713310158L, visitedPositions);
  }
}
