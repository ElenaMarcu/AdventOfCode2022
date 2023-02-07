package em.adventofcode.year2022.days;

import em.adventofcode.year2022.MainDay;
import em.adventofcode.year2022.utils.UtilClass;
import java.util.Map;
import java.util.logging.Logger;

public class Day2 extends MainDay {

  public Day2(String fileName) {
    lines = UtilClass.readLines(fileName);
    logger = Logger.getLogger(Day2.class.getName());
  }

  private long computeSum(Map<String, Integer> values) {
    long sum = 0;
    for (String line : lines) {
      line = line.trim().strip();
      sum += values.get(line);
    }
    return sum;
  }

  @Override
  public Long part1() {
    Map<String, Integer> mapPart1 = Map.of("A X", 4, "A Y", 8, "A Z", 3, "B X", 1, "B Y", 5, "B Z",
        9, "C X", 7, "C Y", 2,
        "C Z", 6);
    return computeSum(mapPart1);
  }

  @Override
  public Long part2() {
    Map<String, Integer> mapPart2 = Map.of("A X", 3, "A Y", 4, "A Z", 8, "B X", 1, "B Y", 5, "B Z",
        9, "C X", 2, "C Y", 6,
        "C Z", 7);
    return computeSum(mapPart2);
  }
}
