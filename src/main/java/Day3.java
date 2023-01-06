package main.java;

import java.util.Set;
import java.util.logging.Logger;

public class Day3 extends MainDay {

  public Day3(String fileName) {
    lines = UtilClass.readLines(fileName);
    logger = Logger.getLogger(Day3.class.getName());
  }

  private static int getPriorityValue(char commonItem) {
    if (Character.isUpperCase(commonItem)) {
      return commonItem - 'A' + 27;
    } else {
      return commonItem - 'a' + 1;
    }
  }

  @Override
  public long part1() {
    long sum = 0;
    for (String line : lines) {
      String part1 = (String) line.subSequence(0, line.length() / 2);
      String part2 = (String) line.subSequence(line.length() / 2, line.length());
      Set<Character> charP1 = UtilClass.getCharacterSet(part1);
      Set<Character> charP2 = UtilClass.getCharacterSet(part2);
      charP1.retainAll(charP2);
      sum += getPriorityValue((char) (charP1.toArray())[0]);
    }
    return sum;
  }

  @Override
  public long part2() {
    int sum = 0;
    Set<Character> charP1;
    Set<Character> charP2;
    Set<Character> charP3;
    for (int i = 0; i <= lines.size() - 3; i += 3) {
      charP1 = UtilClass.getCharacterSet(lines.get(i));
      charP2 = UtilClass.getCharacterSet(lines.get(i + 1));
      charP3 = UtilClass.getCharacterSet(lines.get(i + 2));
      charP1.retainAll(charP2);
      charP1.retainAll(charP3);
      sum += getPriorityValue((char) (charP1.toArray())[0]);
    }
    return sum;
  }
}

