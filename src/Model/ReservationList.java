package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Reservation objects.
 * @author Group 6
 * @version 1.0
 * */
public class ReservationList implements Serializable
{
  private ArrayList<Reservation> reservations;

  /**
   * No argument constructor, which initialize the ArrayList of reservation
   */
  public ReservationList()
  {
    reservations = new ArrayList<>();
  }

  /**
   *  Adds a reservation
   *  @param game is the game being reserved
   *  @param player is the player reserving it
   *  @param startDate is the date of the start of the reservation
   *  @param endDate is the date of the end of the reservation
   * */
  public void addReservation(Game game, Player player, DateTime startDate, DateTime endDate)
  {
      Reservation temp = new Reservation(game, player, startDate, endDate, false);
      if(!reservations.contains(temp))
      {
        reservations.add(temp);
      }
  }
  /**
   *  Adds a borrow
   *  @param game is the game being borrowed
   *  @param player is the player borrowing it
   *  @param startDate is the date of the start of the borrow
   *  @param endDate is the date of the end of the borrow
   * */
  public void addBorrow(Game game, Player player, DateTime startDate, DateTime endDate)
  {
    Reservation temp = new Reservation(game, player, startDate, endDate, true);
    if(!reservations.contains(temp))
    {
      reservations.add(temp);
    }
  }

  /**
   * Removes a reservation
   * @param reservation which is the reservation to be removed
   * @throws NullPointerException
   */
  public void removeReservation(Reservation reservation)
  {
    try
    {
      reservations.removeIf(
          element -> element.getGame().equals(reservation.getGame()) && element.getPlayer().equals(reservation.getPlayer())
              && element.getStartDate().equals(reservation.getStartDate()) && element.getEndDate().equals(reservation.getEndDate())
              && element.isBorrow() == reservation.isBorrow());
    }
    catch (NullPointerException f)
    {
      f.fillInStackTrace();
    }
  }

  /**
   * Gets reservation(s) based on game in said reservation
   * @param game Game that the reservation(s) which we wish to get, contains
   * @return Returns an ArrayList containing the reservation(s) that are made for 'game'
   */
  public ArrayList<Reservation> getByGame(Game game)
  {
    ArrayList<Reservation> byGame = new ArrayList<>();
    for(Reservation element: reservations)
    {
      if(element.getGame().equals(game))
      {
        byGame.add(element);
      }
    }
    return byGame;
  }

  /**
   * Gets reservation(s) based on player who made it
   * @param player The player whose reservations we wish to get
   * @return Returns an ArrayList of the reservation(s) of 'player'
   */
  public ArrayList<Reservation> getByPlayer(Player player)
  {
    ArrayList<Reservation> byPlayer = new ArrayList<>();
    for(Reservation element: reservations)
    {
      if(element.getPlayer().equals(player))
      {
        byPlayer.add(element);
      }
    }
    return byPlayer;
  }

  /**
   * Get the list of reservations in an ArrayList
   * @return Returns an ArrayList of the reservations
   */
  public ArrayList<Reservation> getList()
  {
    return reservations;
  }

  /**
   * Display all the reservations in ReservationList
   * @return Returns reservations, each in a new line, as a String
   */
  public String toString()
  {
    String text="";
    for(Reservation element: reservations)
    {
      text+=element+"\n";
    }
    return text;
  }

  /**
   * Gets a lists of all borrows
   * @return Returns all the borrows as an ArrayList
   */
  public ArrayList<Game> getBorrowedGames()
  {
    ArrayList<Game> other = new ArrayList<>();
    for(Reservation element: reservations)
    {
      if(element.isBorrow())
      {
        other.add(element.getGame());
      }
    }
    return other;
  }

}