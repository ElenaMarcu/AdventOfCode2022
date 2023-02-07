package em.adventofcode.year2022.days;

import static org.junit.Assert.assertEquals;

import em.adventofcode.year2022.MainTestClass;
import java.util.logging.Logger;

public class TestDay10 extends MainTestClass {

  private final Day10 day;

  public TestDay10() {
    day = new Day10("src/test/resources/inputDay10.txt");
    logger = Logger.getLogger(TestDay10.class.getName());
  }

  @Override
  public void testPart1() {
    long visitedPositions = day.part1();
    assertEquals(13140, visitedPositions);
  }

  @Override
  public void testPart2() {
    String message = day.part2();
    String testMessage = "##..##..##..##..##..##..##..##..##..##.." + System.lineSeparator()
        + "###...###...###...###...###...###...###."
        + System.lineSeparator() + "####....####....####....####....####...."
        + System.lineSeparator() + "#####.....#####.....#####.....#####....."
        + System.lineSeparator() + "######......######......######......####"
        + System.lineSeparator() + "#######.......#######.......#######.....";
    assertEquals(testMessage, message);
  }
}
