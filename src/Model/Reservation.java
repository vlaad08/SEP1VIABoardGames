package Model;

import java.io.Serializable;

/**
 * Class for making reservations
 * @author Group 6
 * @version 1.0
 */
public class Reservation implements Serializable
{
  private DateTime startDate;
  private DateTime endDate;
  private boolean borrow;
  private Game game;
  private Player player;

  /**
   * Constructor for making a  reservation
   * @param game the game that is to be reserved
   * @param player the player who makes the reservation
   * @param startDate the date of the start of the reservation
   * @param endDate the date of the end of the reservation
   * @param borrow a boolean which decides if the reservation is a borrow or not
   */
  public Reservation(Game game, Player player, DateTime startDate, DateTime endDate, boolean borrow)
  {
    this.game = game;
    this.player = player;
    this.startDate = startDate;
    this.endDate = endDate;
    this.borrow = borrow;
  }

  /**
   * Gets the game on which the reservations is made
   * @return Returns the game on which the reservation is made, as a Game object
   */
  public Game getGame()
  {
    return game;
  }

  /**
   * Gets the date when the reservations ends
   * @return Returns the date on which the reservation ends, as a DateTime object
   */
  public DateTime getEndDate()
  {
    return endDate;
  }

  /**
   * Gets the date on which the reservations starts
   * @return Returns the game on which the reservatioon is made, as a Game object
   */
  public DateTime getStartDate()
  {
    return startDate;
  }

  /**
   * Sets the borrow status to given value of the reservation that it's used on
   * @param borrow the value to be set
   */
  public void setBorrow(boolean borrow)
  {
    this.borrow = borrow;
  }

  /**
   * Tells us if the reservation is a borrow or not
   * @return Returns the value of the borrow boolean
   */
  public boolean isBorrow()
  {
    return borrow;
  }

  /**
   * Gets the player who made the reservation
   * @return Returns the player who made the reservation, as a Player object
   */
  public Player getPlayer()
  {
    return player;
  }

  /**
   * Equals method comparing reservation and given object
   * @param obj the object we want to compare
   * @return Returns true/false if the two object we are comparing are/aren't equal
   */
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

  /**
   * Display all the reservation's information
   * @return Returns everything we know about the reservation as a String
   */
  public String toString()
  {
    return "Reservation: player: " + player + ", game: " + game + ", " + startDate + " - " + endDate + ". Is borrowed? " + isBorrow();
  }
}
