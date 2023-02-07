package em.adventofcode.year2022.days;

import em.adventofcode.year2022.MainDay;
import em.adventofcode.year2022.utils.UtilClass;
import java.util.Set;
import java.util.logging.Logger;

public class Day6 extends MainDay {

  public Day6(String fileName) {
    lines = UtilClass.readLines(fileName);
    logger = Logger.getLogger(Day6.class.getName());
  }

  @Override
  public Integer part1() {
    return findIndex(4);
  }

  @Override
  public Integer part2() {
    return findIndex(14);
  }

  private Integer findIndex(int noDistinctChars) {
    String line = lines.get(0);
    int index = 0;
    while (index < line.length() - noDistinctChars) {
      String charsToTest = line.substring(index, index + noDistinctChars);
      Set<Character> chars = UtilClass.getCharacterSet(charsToTest);
      if (chars.size() == noDistinctChars) {
        return index + noDistinctChars;
      }
      index++;
    }
    return 0;
  }
}
