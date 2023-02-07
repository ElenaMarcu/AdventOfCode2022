package em.adventofcode.year2022.utils;
public class Sprite {

  private int spriteLeft = 0;
  private int spriteRight = 2;

  public void updateSprite(int x) {
    spriteLeft = (x - 1);
    spriteRight= (x + 1);

  }

  public char getPixelValue(int yCycle) {
    if (spriteLeft <= yCycle && spriteRight >=yCycle) {
      return '#';
    }
    return '.';
  }
}
