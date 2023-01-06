package main.java;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UtilClass {

  protected static List<String> readLines(String fileName) {
    List<String> lines = null;
    try {
      Path file = Path.of(fileName);
      lines = Files.readAllLines(file);
    } catch (java.io.IOException ex) {
      lines = new ArrayList<>();
    }
    return lines;
  }

  protected static Set<Character> getCharacterSet(String item) {
    return item.chars()
        .mapToObj(ch -> (char) ch)
        .collect(Collectors.toSet());
  }
}
