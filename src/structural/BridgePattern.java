package structrual;

abstract class Shape {
  abstract public void draw();

  private Drawing dp;

  Shape(Drawing dp) {
    this.dp = dp;
  }

  public void drawLine(double x1, double x2, double y1, double y2) {
    dp.drawLine(x1, x2, y1, y2);
  }

  public void drawCircle(double x, double y, double r) {
    dp.drawCircle(x, y, r);
  }

}

class Rectangle extends Shape {

  double x1, x2, y1, y2;

  Rectangle(Drawing dp, double x1, double x2, double y1, double y2) {
    super(dp);
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
  }

  public void draw() {
    drawLine(x1, y1, x2, y1);
    drawLine(x2, y1, x2, y2);
    drawLine(x2, y2, x1, y2);
    drawLine(x1, y2, x1, y1);

  }
}

class Circle extends Shape {

  double x, y, r;

  Circle(Drawing dp, double x, double y, double r) {
    super(dp);
    this.x = x;
    this.y = y;
    this.r = r;

  }

  @Override
  public void draw() {
    drawCircle(x, y, r);
  }
}

abstract class Drawing {
  abstract public void drawLine(double x1, double x2, double y1, double y2);

  abstract public void drawCircle(double x, double y, double r);
}

class V1Drawing extends Drawing {
  DP1 dp1;

  V1Drawing() {
    dp1 = new DP1();
  }

  public void drawLine(double x1, double x2, double y1, double y2) {
    dp1.draw_a_line(x1, x2, y1, y2);
  }

  public void drawCircle(double x, double y, double r) {
    dp1.draw_a_circle(x, y, r);
  }
}

class V2Drawing extends Drawing {
  DP2 dp2;

  V2Drawing() {
    dp2 = new DP2();
  }

  public void drawLine(double x1, double x2, double y1, double y2) {
    dp2.drawline(x1, x2, y1, y2);
  }

  public void drawCircle(double x, double y, double r) {
    dp2.drawcircle(x, y, r);
  }
}

class DP1 {
  public void draw_a_line(double x1, double x2, double y1, double y2) {
    System.out.println("DP1: draw_a_line(): " + x1 + ", " + x2 + ", " + y1 + ", " + y2);
  }

  public void draw_a_circle(double x, double y, double r) {
    System.out.println("DP1: draw_a_circle():" + x + ", " + y + ", " + r);

  }
}

class DP2 {
  public void drawline(double x1, double x2, double y1, double y2) {
    System.out.println("DP2: drawline(): " + x1 + ", " + x2 + ", " + y1 + ", " + y2);
  }

  public void drawcircle(double x, double y, double r) {
    System.out.println("DP2: drawcircle():" + x + ", " + y + ", " + r);

  }
}

public class BridgePattern {

  public static void main(String[] args) {
    System.out.println("Bridge Pattern\n\n");
    run();
    System.out.println("\n\nDone done");
  }

  public static void run() {
    Shape r1, r2;
    Drawing dp;

    dp = new V1Drawing();
    r1 = new Rectangle(dp, 1, 1, 2, 2);

    dp = new V2Drawing();
    r2 = new Circle(dp, 2, 2, 3);

    r1.draw();
    r2.draw();

  }

}
