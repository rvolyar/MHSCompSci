public class CrapsGame
{
  private int point = 0;

  /**
   *  Calculates the result of the next dice roll in the Craps game.
   *  @param pts the total number of points on two dice.
   *  <code>result</code> is set to 1 if player won, -1 if player lost,
   *  0 if player continues rolling.  <code>point</code> is set to the
   *  saved total if the game continues, 0 if the game has ended.
   */
  public int nextRoll(int pts)
  {
    int result;

    if (point == 0)
    {
      if (pts == 7 || pts == 11)
        result = 1;
      else if (pts == 2 || pts == 3 || pts == 12)
        result = -1;
      else
      {
        result = 0;
        point = pts;
      }
    }
    else  // if (point > 0)
    {
      if (pts == point)
      {
        result = 1;
        point = 0;
      }
      else if (pts == 7)
      {
        result = -1;
        point = 0;
      }
      else
        result = 0;
    }
    return result;
  }

  public int getPoint()
  {
    return point;
  }
}

