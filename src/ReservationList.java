import java.util.ArrayList;

public class ReservationList
{
  private ArrayList<Reservation> reservations;

  /**
   * @author Vlad Nita
   * @version 1.0
   *
   * */

  /**
   * No argument constructor, which initialize the ArrayList of reservation
   */

  public ReservationList()
  {
    reservations = new ArrayList<>();
  }

  public void addReservation(Game game, Player player, DateTime startDate, DateTime endDate, boolean borrow)
  {
      Reservation temp = new Reservation(game, player, startDate, endDate, borrow);
      if(!reservations.contains(temp))
      {
        reservations.add(temp);
      }
  }

  public void removeReservation(Reservation reservation)
  {
    reservations.remove(reservation);
  }

  public ArrayList<Reservation> getList()
  {
    return reservations;
  }


}
