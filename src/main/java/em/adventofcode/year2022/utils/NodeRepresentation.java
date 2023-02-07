package em.adventofcode.year2022.utils;

public class NodeRepresentation {
  private final String name;
  private Long size;

  public NodeRepresentation(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    NodeRepresentation obj = (NodeRepresentation)o;
    return this.name.equals(obj.name);
  }
}
