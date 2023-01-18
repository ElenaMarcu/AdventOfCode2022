package main.java;

public class NodeRepresentation {
  private String name;
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
    if(this.name.equals(obj.name))
      return true;
  return false;
  }
}
