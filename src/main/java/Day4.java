package main.java;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 extends MainDay {

  private final Pattern pattern;
  private Matcher matcher;

  public Day4(String fileName) {
    lines = UtilClass.readLines(fileName);
    logger = Logger.getLogger(Day4.class.getName());
    pattern = Pattern.compile("(\\d*)-(\\d*),(\\d*)-(\\d*)");
  }

  @Override
  public Long part1() {
    long pairs = 0;
    for (String line : lines) {
      matcher = pattern.matcher(line);
      if (matcher.find()) {
        int startElf1 = Integer.parseInt(matcher.group(1));
        int endElf1 = Integer.parseInt(matcher.group(2));
        int startElf2 = Integer.parseInt(matcher.group(3));
        int endElf2 = Integer.parseInt(matcher.group(4));
        if ((startElf1 <= startElf2 && endElf2 <= endElf1) || (startElf2 <= startElf1
            && endElf1 <= endElf2)) {
          pairs++;
        }
      }
    }
    return pairs;
  }

  @Override
  public Long part2() {
    long pairs = 0;
    for (String line : lines) {
      matcher = pattern.matcher(line);
      if (matcher.find()) {
        int startElf1 = Integer.parseInt(matcher.group(1));
        int endElf1 = Integer.parseInt(matcher.group(2));
        int startElf2 = Integer.parseInt(matcher.group(3));
        int endElf2 = Integer.parseInt(matcher.group(4));
        if ((startElf1 <= startElf2 && endElf2 <= endElf1) || (startElf2 <= startElf1
            && endElf1 <= endElf2) ||
            (startElf1 <= startElf2 && startElf2 <= endElf1) || (startElf2 <= startElf1
            && startElf1 <= endElf2)) {
          pairs++;
        }
      }
    }
    return pairs;
  }
}

