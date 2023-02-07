package em.adventofcode.year2022.days;

import static org.junit.Assert.assertEquals;

import em.adventofcode.year2022.MainTestClass;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.logging.Logger;
import org.junit.Test;

public class TestDay5 extends MainTestClass {

  private final Day5 day;

  public TestDay5() {
    logger = Logger.getLogger(TestDay5.class.getName());
    day = new Day5("src/test/resources/inputDay5.txt");
  }

  @Test
  public void testPart1() {
    day.setStacks(populateDeque());
    String part1Result = day.part1();
    assertEquals("CMZ", part1Result);
  }

  @Test
  public void testPart2() {
    day.setStacks(populateDeque());
    String part2Result = day.part2();
    assertEquals("MCD", part2Result);
  }

  private Deque<String>[] populateDeque() {
    Deque<String>[] stacks = new Deque[3];
    Deque<String> hashSet = new ArrayDeque<>(
        Arrays.asList("Z", "N"));
    stacks[0] = hashSet;
    hashSet = new ArrayDeque<>(Arrays.asList("M", "C", "D"));
    stacks[1] = hashSet;
    hashSet = new ArrayDeque<>(List.of("P"));
    stacks[2] = hashSet;
    return stacks;
  }
}
