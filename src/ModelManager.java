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
    ArrayList<Game> games= gameCollection.getList();
    DateTime today = DateTime.today();

    for (Game element: games)
    {
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

}
