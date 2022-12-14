package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ReservationList implements Serializable
{
  private ArrayList<Reservation> reservations;

  /**
   * @author Vlad Nita and Emanoil Duca
   * @version 1.0
   * */

  /**
   * No argument constructor, which initialize the ArrayList of reservation
   */
  public ReservationList()
  {
    reservations = new ArrayList<>();
  }
  public void addReservation(Game game, Player player, DateTime startDate, DateTime endDate)
  {
      Reservation temp = new Reservation(game, player, startDate, endDate, false);
      if(!reservations.contains(temp))
      {
        reservations.add(temp);
      }
  }

  public void addBorrow(Game game, Player player, DateTime startDate, DateTime endDate)
  {
    Reservation temp = new Reservation(game, player, startDate, endDate, true);
    if(!reservations.contains(temp))
    {
      reservations.add(temp);
    }
  }

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

  public ArrayList<Reservation> getList()
  {
    return reservations;
  }

  public String toString()
  {
    String text="";
    for(Reservation element: reservations)
    {
      text+=element+"\n";
    }
    return text;
  }

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