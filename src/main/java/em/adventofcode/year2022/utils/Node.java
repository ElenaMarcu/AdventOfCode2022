package em.adventofcode.year2022.utils;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

  private final T data;
  private final List<Node<T>> children;
  private Node<T> parent;

  public Node(T data) {
    this.data = data;
    this.children = new ArrayList<>();
  }

  public void addChildren(Node<T> child) {
    child.parent = this;
    children.add(child);
  }

  public Node<T> getParent() {
    return this.parent;
  }

  public Node<T> getNodeByData(Node<T> node, T data) {
    for (Node<T> currentNode : node.children) {
      if (currentNode.getData().equals(data)) {
        return currentNode;
      }
    }
    return null;
  }
  public boolean isLeaf (){
    return this.children.isEmpty();
  }

  public T getData(){
    return this.data;
  }

  public List<Node<T>> getChilds() {
    return this.children;
  }
}
