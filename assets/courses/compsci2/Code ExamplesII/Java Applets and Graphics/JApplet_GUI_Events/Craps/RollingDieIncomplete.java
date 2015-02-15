//Don't forget to rename this file "RollingDie"
import java.awt.*;
import javax.swing.*;

public class RollingDie
{
  private static final double slowdown = .97,
                              speedFactor = .04,
                              speedLimit = 2.;

  private static int tableLeft, tableRight, tableTop, tableBottom;

  private final int dieSize = 24;
  private int xCenter, yCenter;
  private double xSpeed, ySpeed;
  private int points;

  public static void setBounds(int left, int right, int top, int bottom)
  {
    tableLeft = left;
    tableRight = right;
    tableTop = top;
    tableBottom = bottom;
  }

  public static int randomPoints()
  {
    return (int)(6 * Math.random()) + 1;
  }

  public RollingDie()
  {
    xCenter = -1;
    yCenter = -1;
  }

  public void roll()
  {
    int width = tableRight - tableLeft;
    int height = tableBottom - tableTop;
    xCenter = tableLeft;
    yCenter = tableTop + height / 2;
    xSpeed = width * (Math.random() + 1) * speedFactor;
    ySpeed = height * (Math.random() -.5) * 2. * speedFactor;
    points = randomPoints();
  }

  public boolean isRolling()
  {
    return xSpeed > speedLimit || xSpeed < -speedLimit
        || ySpeed > speedLimit || ySpeed < -speedLimit;
  }

  public void avoidCollision(RollingDie other)
  {
    if (other == this)
      return;

    while (Math.abs(xCenter - other.xCenter) < dieSize &&
           Math.abs(yCenter - other.yCenter) < dieSize)
      move();
  }

  public int getPoints()
  {
      return points;
  }

  private void move()
  {
    xCenter += xSpeed;
    yCenter += ySpeed;
    int radius = dieSize / 2;

    if (xCenter < tableLeft + radius)
    {
      xCenter = tableLeft + radius;
      xSpeed = -xSpeed;
    }
    if (xCenter > tableRight - radius)
    {
      xCenter = tableRight - radius;
      xSpeed = -xSpeed;
    }
    if (yCenter < tableTop + radius)
    {
      yCenter = tableTop + radius;
      ySpeed = -ySpeed;
    }
    if (yCenter > tableBottom - radius)
    {
      yCenter = tableBottom - radius;
      ySpeed = -ySpeed;
    }
  }

  public void draw(Graphics g)
  {
    if (xCenter < 0 || yCenter < 0)
      return;
    else if (isRolling())
    {
      move();
      drawRolling(g);
      xSpeed *= slowdown;
      ySpeed *= slowdown;
    }
    else
      drawStopped(g);
  }

  private void drawRolling(Graphics g)
  {
    int x, y;

    x = xCenter - dieSize / 2 + (int)(3 * Math.random()) - 1;
    y = yCenter - dieSize / 2 + (int)(3 * Math.random()) - 1;
    g.setColor(Color.red);

    if (x % 2 != 0)
      g.fillRoundRect(x, y, dieSize, dieSize, dieSize/4, dieSize/4);
    else
      g.fillOval(x - 2, y - 2, dieSize + 4, dieSize + 4);

    drawDots(g, x, y, randomPoints());
  }

  private void drawStopped(Graphics g)
  {
    int x, y;

    x = xCenter - dieSize / 2;
    y = yCenter - dieSize / 2;
    g.setColor(Color.red);
    g.fillRoundRect(x, y, dieSize, dieSize, dieSize/4, dieSize/4);
    drawDots(g, x, y, points);
  }

  private void drawDots(Graphics g, int x, int y, int points)
  {
    int x1, x2, x3, y1, y2, y3, dotSize;

    g.setColor(Color.white);

    dotSize = dieSize / 4;
    int step = dieSize / 8;
    x1 = x + step - 1;
    x2 = x + 3*step;
    x3 = x + 5*step + 1;
    y1 = y + step - 1;
    y2 = y + 3*step;
    y3 = y + 5*step + 1;

    switch (points)
    {
      case 1:
        g.fillOval(x2, y2, dotSize, dotSize);
        break;
      // missing code
    }
  }
}

