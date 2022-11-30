package Model;

public class Reservation
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

  public boolean isBorrow()
  {
    if(borrow)
      return true;
    else
      return false;
  }

  public Player getPlayer()
  {
    return player;
  }

  public String toString()
  {
    return "Model.Reservation: " + player.getName() + ", " + game.getTitle() + ", " + startDate + " - " + endDate + ". Is borrowed? " + isBorrow();
  }
}
