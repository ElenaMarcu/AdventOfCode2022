package main.java;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>This is the main class for the solutions for Advent of code 2022
 * <a href="https://adventofcode.com/2022">Advent of code 2022!</a> </p>
 */
public class MainDay {

  protected static Logger logger;
  protected static List<String> lines;
  protected static Pattern pattern;
  protected static Matcher matcher;

  /**
   * Main method where the day/days for which we are running are mentioned in args
   */
  public static void main(String[] args) {
    for (String arg : args) {
      String fileName = "src/main/resources/inputDay" + arg + ".txt";
      String className = "main.java.Day" + arg;
      testDay(className, fileName);
    }
  }

  private static void testDay(String className, String fileName) {
    try {
      MainDay day = (MainDay) Class.forName(className).getDeclaredConstructor(String.class)
          .newInstance(fileName);
      logger.log(Level.INFO, "Running {0}", className);
      String part1Result = String.valueOf(day.part1());
      logger.log(Level.INFO, part1Result);
      String part2Result = String.valueOf(day.part2());
      logger.log(Level.INFO, part2Result);
    } catch (ReflectiveOperationException exception) {
      logger.log(Level.WARNING, exception.toString());
    }
  }

  public long part1() {
    return 0;
  }

  public long part2() {
    return 0;
  }
}
