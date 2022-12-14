package Model;

import java.io.Serializable;

public class Reservation implements Serializable
{
  private DateTime startDate;
  private DateTime endDate;
  private boolean borrow;
  private Game game;
  private Player player;

  public Reservation(Game game, Player player, DateTime startDate, DateTime endDate, boolean borrow)
  {
    this.game = game;
    this.player = player;
    this.startDate = startDate;
    this.endDate = endDate;
    this.borrow = borrow;
  }

  public Game getGame()
  {
    return game;
  }

  public DateTime getEndDate()
  {
    return endDate;
  }

  public DateTime getStartDate()
  {
    return startDate;
  }

  public void setBorrow(boolean borrow)
  {
    this.borrow = borrow;
  }

  public boolean isBorrow()
  {
    return borrow;
  }

  public Player getPlayer()
  {
    return player;
  }

  public boolean equals(Object obj)
  {
    try{
      if (getClass() != obj.getClass())
      {
        return false;
      }
      Reservation other=(Reservation) obj;
      return other.startDate.equals(startDate)&&other.endDate.equals(endDate)&&other.borrow==borrow&&other.game.equals(game)&&other.player.equals(player);
    }
    catch (NullPointerException e)
    {
      e.fillInStackTrace();
    }
    return false;
  }

  public String toString()
  {
    return "Reservation: player: " + player + ", game: " + game + ", " + startDate + " - " + endDate + ". Is borrowed? " + isBorrow();
  }
}
