import java.time.LocalDate;
import java.util.ArrayList;

public class ModelManager
{
  private GameCollection gameCollection;
  private ReservationList reservationList;
  private EventList eventList;
  private PlayerList playerList;

  public ModelManager(GameCollection gameCollection,
      ReservationList reservationList, EventList eventList,
      PlayerList playerList)
  {
    this.gameCollection = gameCollection;
    this.reservationList = reservationList;
    this.eventList = eventList;
    this.playerList = playerList;
  }

  private void refreshAvailabilityOfGames()
  {
    ArrayList<Reservation> reservations = reservationList.getList();
    for (Reservation element: reservations)
    {
      if (element.getStartDate().equals(DateTime.today()))
      {
        element.getGame().setReserved(true);
      }
      else if (element.getStartDate().isBefore(DateTime.today()) && !(element.getEndDate().isBefore(DateTime.today())))
      {
        element.getGame().setReserved(true);
      }
      if (element.getEndDate().isBefore(DateTime.today()))
      {
        element.getGame().setReserved(false);
        reservationList.removeReservation(element);
      }
    }
  }

  public void removePlayer(Player player)
  {
    playerList.removePlayer(player.getStudentID());
  }

  public void addGame(Game game)
  {
    gameCollection.addGame(game.getTitle(),game.getMaxPlayers(),game.getOwner());
  }

  public Game getGame(String title)
  {
    return gameCollection.getGame(title);
  }

  public void removeGame(Game game)
  {
    gameCollection.removeGame(game);
  }

  public void rateAGame(Game game, int rate)
  {
    ArrayList<Game> games=gameCollection.getList();
    for (int i = 0; i < games.size(); i++)
    {
      if (games.get(i).equals(game))
      {
        games.get(i).addRating(rate);
      }
    }
  }

  public ReservationList getReservationList()
  {
    return reservationList;
  }

  public void reserve(Player player, Game game, DateTime startDate, DateTime endDate)
  {
    reservationList.addReservation(game, player, startDate, endDate, false);
  }

  public void borrow(Player player, Game game, DateTime endDate)
  {
    reservationList.addReservation(game,player,DateTime.today(),endDate,true);
  }

  public void addEvent(String title, String description, String image, DateTime startDate, DateTime endDate)
  {
    eventList.addEvent(title, description, startDate, endDate, image);
  }

  public void removeEvent(Event event)
  {
    eventList.removeEvent(event);
  }

  public Event getEvent(String title)
  {
    return eventList.getEvent(title);
  }

  public void addPlayer(String name, String studentID, boolean membership)
  {
    if (membership==true)
    {
      playerList.addMember(studentID, name);
    }
    else
    {
      playerList.addMember(studentID, name);
    }
  }

  public Player getPlayerByStudentID(String studentID)
  {
    for (Player element:playerList.getList())
    {
      if (element.getStudentID().equals(studentID))
      {
        return element;
      }
    }
    return null;
  }

  public Player getPlayerByName(String name)
  {
    for (Player element:playerList.getList())
    {
      if (element.getName().equals(name))
      {
        return element;
      }
    }
    return null;
  }


}
