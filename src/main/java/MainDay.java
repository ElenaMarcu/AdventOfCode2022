package main.java;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class MainDay {

  protected static Logger logger;
  protected static List<String> lines;

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

  public abstract Object part1();

  public abstract Object part2();

}
