import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CrapsTable extends JPanel
                        implements ActionListener
{

  private RollingDie die1, die2;
  private final int delay = 20;
  private Timer clock;
  private Craps craps;

  public CrapsTable(Craps applet)
  {
    craps = applet;
    die1 = new RollingDie();
    die2 = new RollingDie();
    clock = new Timer(delay, this);
  }

  public void rollDice()
  {
    RollingDie.setBounds(0, getWidth(), 0, getHeight());
    die1.roll();
    die2.roll();
    clock.start();
  }

  /**
   *  Timer event
   */
  public void actionPerformed(ActionEvent e)
  {
    if (diceAreRolling())
    {
      if (!clock.isRunning())
        clock.restart();
      if (die1.isRolling())
        die1.avoidCollision(die2);
      else if (die2.isRolling())
        die2.avoidCollision(die1);
    }
    else
    {
      clock.stop();
      craps.processRoll(die1.getPoints() + die2.getPoints());
    }
    
    repaint();
  }

  public boolean diceAreRolling()
  {
    return die1.isRolling() || die2.isRolling();
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    die1.draw(g);
    die2.draw(g);
  }
}


