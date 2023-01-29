package main.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Monkey {

  private static Long commonDivider;
  private Deque<Long> items;
  private String sign;
  private String secondParam;
  private Integer divBy;
  private Integer isTrue;
  private Integer isFalse;

  public static void setCommonDivider(Long commonDivider) {
    Monkey.commonDivider = commonDivider;
  }

  public void setItems(List<String> items) {
    this.items = items.stream().map(Long::parseLong)
        .collect(Collectors.toCollection(ArrayDeque::new));
  }

  public void addItem(Long item) {
    this.items.addLast(item);
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public void setSecondParam(String secondParam) {
    this.secondParam = secondParam;
  }

  public void setIsTrue(Integer isTrue) {
    this.isTrue = isTrue;
  }

  public void setIsFalse(Integer isFalse) {
    this.isFalse = isFalse;
  }

  public boolean hasItems() {
    return (items != null && !items.isEmpty());
  }

  public Integer getMonkeyNo(Long value) {
    if (value % divBy == 0) {
      return isTrue;
    }
    return isFalse;
  }

  public Long getWorryLevel(int worryDiv) {
    Long worryLevel = getOperationResult();
    if (worryDiv == 1) {
      return worryLevel % Monkey.commonDivider;
    }
    return Math.floorDiv(worryLevel, worryDiv);
  }

  private Long getOperationResult() {
    Long item = items.removeFirst();
    Long secondItem = getSecondParam(item);
    if ("*".equals(sign)) {
      return item * secondItem;
    }
    return item + secondItem;
  }

  public Integer getDivBy() {
    return divBy;
  }

  public void setDivBy(Integer divBy) {
    this.divBy = divBy;
  }

  private Long getSecondParam(Long item) {
    if ("old".equals(secondParam)) {
      return item;
    }
    return Long.valueOf(secondParam);
  }
}
