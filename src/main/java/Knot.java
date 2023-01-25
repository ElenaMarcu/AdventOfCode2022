package main.java;

public class Knot {

  private int x;
  private int y;

  public Knot(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void moveHead(Direction direction) {
    switch (direction) {
      case UP:
        this.x--;
        break;
      case DOWN:
        this.x++;
        break;
      case LEFT:
        this.y--;
        break;
      case RIGHT:
        this.y++;
        break;
    }
  }

  public void moveTail(Knot head) {
    if (isAdjacent(head))
    {
      return;
    }
      this.y = this.y + (int)Math.signum(head.y - y);
      this.x = this.x + (int)Math.signum(head.x - x);
  }

  private boolean isAdjacent(Knot head) {
    return (Math.abs(head.y - y) + Math.abs(head.x - x) == 1 || Math.abs(head.y - y) + Math.abs(head.x - x) == 0 || (Math.abs(head.y - y)==1 && Math.abs(head.x - x) == 1));
  }

  public String getCurrentPosition() {
    return this.x + "," +this.y;
  }

  public enum Direction {
    UP, DOWN, LEFT, RIGHT;
  }
}
