package em.adventofcode.year2022.days;

import em.adventofcode.year2022.MainDay;
import em.adventofcode.year2022.utils.Node;
import em.adventofcode.year2022.utils.NodeRepresentation;
import em.adventofcode.year2022.utils.UtilClass;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Day7 extends MainDay {

  private Node<NodeRepresentation> root;
  private final Map<String, Long> nodeSums;

  public Day7(String fileName) {
    logger = Logger.getLogger(Day7.class.getName());
    lines = UtilClass.readLines(fileName);
    createTree();
    nodeSums = new HashMap<>();

  }

  @Override
  public Long part1() {
    computeSum(root, "/");
    return nodeSums.values().stream().filter(v -> v < 100000).mapToLong(Long::longValue).sum();
  }

  @Override
  public Long part2() {
    Long valueToFind = 30000000 - (70000000 - nodeSums.get("/"));
    return nodeSums.values().stream().filter(v -> v > valueToFind).sorted().findFirst().orElse(0L);
  }

  private void createTree() {
    NodeRepresentation rootData = new NodeRepresentation("/");
    root = new Node<>(rootData);
    Node<NodeRepresentation> currentNode = root;
    for (String line : lines) {
      currentNode = processLine(line, currentNode);
    }
  }

  private Node<NodeRepresentation> processLine(String line, Node<NodeRepresentation> currentNode) {
    line = line.trim();
    switch (line) {
      case "$ cd /":
        currentNode = root;
        return currentNode;
      case "$ ls":
        return currentNode;
      case "$ cd ..":
        currentNode = currentNode.getParent();
        return currentNode;
      default:
        break;
    }

    String[] ch = line.split("\\s+");
    if (line.startsWith("$")) {
      currentNode = currentNode.getNodeByData(currentNode, new NodeRepresentation(ch[2]));
    } else {
      NodeRepresentation childRep = new NodeRepresentation(ch[1]);
      if (!"dir".equals(ch[0])) {
        childRep.setSize(Long.valueOf(ch[0]));
      }
      Node<NodeRepresentation> child = new Node<>(childRep);
      currentNode.addChildren(child);
    }
    return currentNode;
  }

  private void computeSum(Node<NodeRepresentation> node, String directory) {
    if (node == null) {
      return;
    }
    for (Node<NodeRepresentation> currentNode : node.getChilds()) {
      if (currentNode.isLeaf()) {
        addValueToMap(currentNode.getData().getSize(), directory);
      } else {

        computeSum(currentNode, directory + "." + currentNode.getData().getName());
        addValueToMap(nodeSums.get(directory + "." + currentNode.getData().getName()), directory);
      }
    }
  }

  private void addValueToMap(Long size, String directory) {
    if (nodeSums.containsKey(directory)) {
      nodeSums.computeIfPresent(directory, (key, val) -> val + size);
    } else {
      nodeSums.computeIfAbsent(directory, k -> size);
    }
  }
}
