package test.java;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class MainTestClass {

  protected static Logger logger;

  public static void main(String[] args) {
    for (String arg : args) {
      String className = "test.java.TestDay" + arg;
      testDay(className);
    }
  }

  public static void testDay(String className) {
    try {
      MainTestClass testClass = (MainTestClass) Class.forName(className)
          .getDeclaredConstructor().newInstance();
      logger.log(Level.INFO, "Testing class {0}", className);
      testClass.testPart1();
      testClass.testPart2();
      logger.log(Level.INFO, "All tests passed");
    } catch (ReflectiveOperationException exception) {
      logger.log(Level.WARNING, exception.toString());
    }
  }

  public abstract void testPart1();

  public abstract void testPart2();

}
