package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

public class Day11 extends MainDay {

  private Map<Integer, Monkey> monkeys;
  private Map<Integer, Long> noInspectedItems;

  public Day11(String fileName) {
    logger = Logger.getLogger(Day11.class.getName());
    lines = UtilClass.readLines(fileName);
  }

  @Override
  public Long part1() {
    initMonkeys();
    startRounds(3, 20);
    return getProduct();
  }

  @Override
  public Long part2() {
    initMonkeys();
    computeAndSetCommonDivider();
    startRounds(1, 10000);
    return getProduct();
  }

  private Long getProduct() {
    Long[] firstTwo = noInspectedItems.values().stream().sorted(Comparator.reverseOrder())
        .limit(2)
        .toArray(Long[]::new);
    return firstTwo[0] * firstTwo[1];
  }

  private void computeAndSetCommonDivider() {
    Long commonDivider = 1L;
    for (Monkey monkey : monkeys.values()) {
      commonDivider *= monkey.getDivBy();
    }
    Monkey.setCommonDivider(commonDivider);
  }

  private void startRounds(int commonDivider, int noOfRounds) {
    noInspectedItems = new HashMap<>();
    for (int i = 0; i < noOfRounds; i++) {
      for (Entry<Integer, Monkey> pair : monkeys.entrySet()) {
        Monkey currentMonkey = pair.getValue();
        while (currentMonkey.hasItems()) {
          Long worryLevel = currentMonkey.getWorryLevel(commonDivider);
          noInspectedItems.putIfAbsent(pair.getKey(), 0L);
          noInspectedItems.computeIfPresent(pair.getKey(), (k, v) -> v = v + 1);
          Integer monkeyNo = currentMonkey.getMonkeyNo(worryLevel);
          monkeys.get(monkeyNo).addItem(worryLevel);
        }
      }
    }
  }

  private void initMonkeys() {
    monkeys = new LinkedHashMap<>();
    Monkey currentMonkey = null;
    for (String line : lines) {
      String[] splitLine = line.strip().split("\\s+");
      switch (splitLine[0]) {
        case "Monkey":
          int monkeyNo = Integer.parseInt(splitLine[1].replace(":", ""));
          currentMonkey = new Monkey();
          monkeys.put(monkeyNo, currentMonkey);
          break;
        case "Starting":
          List<String> list = new ArrayList<>(
              Arrays.asList(
                  line.strip().replace("Starting items: ", "").replace(",", "").split("\\s+")));
          assert currentMonkey != null;
          currentMonkey.setItems(list);
          break;
        case "Operation:":
          assert currentMonkey != null;
          currentMonkey.setSign(splitLine[splitLine.length - 2]);
          currentMonkey.setSecondParam(splitLine[splitLine.length - 1]);
          break;
        case "Test:":
          assert currentMonkey != null;
          currentMonkey.setDivBy(Integer.parseInt(splitLine[splitLine.length - 1]));
          break;
        case "If":
          assert currentMonkey != null;
          if ("true:".equals(splitLine[1])) {
            currentMonkey.setIsTrue(Integer.parseInt(splitLine[splitLine.length - 1]));
          } else {
            currentMonkey.setIsFalse(Integer.parseInt(splitLine[splitLine.length - 1]));
          }
          break;
        default:
          break;
      }
    }
  }
}
