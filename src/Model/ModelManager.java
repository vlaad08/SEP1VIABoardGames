package Model;

import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ModelManager
{
  //Put them in the  file
  private String gameCollectionFileName;
  private String playerListFileName;
  private String reservationListFileName;
  private String eventListFileName;

  public ModelManager(String fileGameCollection, String filePlayerList,
      String fileReservationList, String fileEventList)
  {
    this.gameCollectionFileName = fileGameCollection;
    this.playerListFileName = filePlayerList;
    this.reservationListFileName = fileReservationList;
    this.eventListFileName = fileEventList;
  }

  public GameCollection getAllGames()
  {
    GameCollection collection = new GameCollection();

    try
    {
      collection = (GameCollection) MyFileHandler.readFromBinaryFile(gameCollectionFileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }

    return collection;
  }

  public ReservationList getAllReservations()
  {
    ReservationList reservations = new ReservationList();

    try
    {
      reservations = (ReservationList) MyFileHandler.readFromBinaryFile(gameCollectionFileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }

    return reservations;
  }

  public EventList getAllEvents()
  {
    EventList events = new EventList();

    try
    {
      events = (EventList) MyFileHandler.readFromBinaryFile(gameCollectionFileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }

    return events;
  }

  public PlayerList getAllPlayers()
  {
    PlayerList players = new PlayerList();

    try
    {
      players = (PlayerList) MyFileHandler.readFromBinaryFile(gameCollectionFileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }

    return players;
  }

  public void saveCollection(GameCollection collection)
  {

  }
  public void saveReservations(ReservationList reservations)
  {

  }
  public void saveEvents(EventList events)
  {

  }
  public void savePlayers(PlayerList players)
  {

  }

  public Player getPlayerByStudentID(String studentID)
  {
    PlayerList playerList=getAllPlayers();
    ArrayList<Player> players = playerList.getList();

    for(Player element: players)
    {
      if(element.getStudentID().equals(studentID))
      {
        return element;
      }
    }
    return null;
  }

  public Player getPlayerByName(String name)
  {
    PlayerList playerList=getAllPlayers();
    ArrayList<Player> players = playerList.getList();

    for(Player element: players)
    {
      if(element.getName().equals(name))
      {
        return element;
      }
    }
    return null;
  }




  // I commented all the code bellow;
  /*
  private void refreshAvailabilityOfGames()
  {
    ArrayList<Model.Reservation> reservations = reservationList.getList();
    for (Model.Reservation element: reservations)
    {
      if (element.getStartDate().equals(Model.DateTime.today()))
      {
        element.getGame().setReserved(true);
      }
      else if (element.getStartDate().isBefore(Model.DateTime.today()) && !(element.getEndDate().isBefore(Model.DateTime.today())))
      {
        element.getGame().setReserved(true);
      }
      if (element.getEndDate().isBefore(Model.DateTime.today()))
      {
        element.getGame().setReserved(false);
        reservationList.removeReservation(element);
      }
    }
  }

  public void removePlayer(Model.Player player)
  {
    playerList.removePlayer(player.getStudentID());
  }

  public void addGame(Model.Game game)
  {
    gameCollection.addGame(game.getTitle(),game.getMaxPlayers(),game.getOwner());
  }

  public Model.Game getGame(String title)
  {
    return gameCollection.getGame(title);
  }

  public void removeGame(Model.Game game)
  {
    gameCollection.removeGame(game);
  }

  public void rateAGame(Model.Game game, int rate)
  {
    ArrayList<Model.Game> games=gameCollection.getList();
    for (int i = 0; i < games.size(); i++)
    {
      if (games.get(i).equals(game))
      {
        games.get(i).addRating(rate);
      }
    }
  }

  public Model.ReservationList getReservationList()
  {
    return reservationList;
  }

  public void reserve(Model.Player player, Model.Game game, Model.DateTime startDate, Model.DateTime endDate)
  {
    reservationList.addReservation(game, player, startDate, endDate, false);
  }

  public void borrow(Model.Player player, Model.Game game, Model.DateTime endDate)
  {
    reservationList.addReservation(game,player,Model.DateTime.today(),endDate,true);
  }

  public void addEvent(String title, String description, String image, Model.DateTime startDate, Model.DateTime endDate)
  {
    eventList.addEvent(title, description, startDate, endDate, image);
  }

  public void removeEvent(Model.Event event)
  {
    eventList.removeEvent(event);
  }

  public Model.Event getEvent(String title)
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

  public Model.Player getPlayerByStudentID(String studentID)
  {
    for (Model.Player element:playerList.getList())
    {
      if (element.getStudentID().equals(studentID))
      {
        return element;
      }
    }
    return null;
  }

  public Model.Player getPlayerByName(String name)
  {
    for (Model.Player element:playerList.getList())
    {
      if (element.getName().equals(name))
      {
        return element;
      }
    }
    return null;
  }
*/

}
