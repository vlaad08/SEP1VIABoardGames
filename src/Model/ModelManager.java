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
      reservations = (ReservationList) MyFileHandler.readFromBinaryFile(reservationListFileName);
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
      events = (EventList) MyFileHandler.readFromBinaryFile(eventListFileName);
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
      players = (PlayerList) MyFileHandler.readFromBinaryFile(playerListFileName);
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
    try
    {
      MyFileHandler.writeToBinaryFile(gameCollectionFileName,collection);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
  }
  public void saveReservations(ReservationList reservations)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(reservationListFileName,reservations);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
  }
  public void saveEvents(EventList events)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(eventListFileName,events);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
  }
  public void savePlayers(PlayerList players)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(playerListFileName,players);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
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
      if(element.getName().equalsIgnoreCase(name))
      {
        return element;
      }
    }
    return null;
  }

  public void removePlayer(Player player)
  {
    PlayerList playerList = getAllPlayers();
    playerList.removePlayer(player);
    savePlayers(playerList);
  }

  public void addGame(Game game)
  {
    GameCollection gameCollection = getAllGames();
    gameCollection.addGame(game);
    saveCollection(gameCollection);
  }

  public Game getGame(String title)
  {
    GameCollection gameCollection = getAllGames();
    return gameCollection.getGame(title);
  }

  public void removeGame(Game game)
  {
    GameCollection gameCollection = getAllGames();
    gameCollection.removeGame(game);
    saveCollection(gameCollection);
  }

  public Game[] displayAvailableGames()
  {
    refreshAvailabilityOfGames();
    GameCollection gameCollection = getAllGames();

    ArrayList<Game> games = gameCollection.getList();
    ArrayList<Game> availableGames = new ArrayList<>();

    for(Game element: games)
    {
      if(element.isReserved()==false)
      {
        availableGames.add(element);
      }
    }

    Game[] other = availableGames.toArray(new Game[0]);
    return other;
  }

  public void rateAGame(Game game, int rate)
  {
    GameCollection gameCollection = getAllGames();
    ArrayList<Game> games = gameCollection.getList();

    for (Game element: games)
    {
      if (element.equals(game))
      {
        element.addRating(rate);
      }
    }
    saveCollection(gameCollection);
  }

  public ReservationList getReservationList()
  {
    ReservationList reservationList = getAllReservations();
    return reservationList;
  }

  public void reserve(Player player, Game game, DateTime startDate, DateTime endDate)
  {
    ReservationList reservationList = getReservationList();
    reservationList.addReservation(game, player, startDate, endDate);
    saveReservations(reservationList);
  }

  public void borrow(Player player, Game game, DateTime endDate)
  {
    ReservationList reservationList = getReservationList();
    reservationList.addBorrow(game,player,DateTime.today(),endDate);
    saveReservations(reservationList);
  }

  public void addEvent(String title, String description, DateTime startDate, DateTime endDate,String image)
  {
    EventList eventList = getAllEvents();
    eventList.addEvent(title, description, startDate, endDate, image);
    saveEvents(eventList);
  }

  public void removeEvent(Event event)
  {
    EventList eventList = getAllEvents();
    eventList.removeEvent(eventList.getEvent(event.getTitle()));
    saveEvents(eventList);
  }

  public Event getEvent(String title)
  {
    EventList eventList = getAllEvents();
    return eventList.getEvent(title);
  }

  public void addPlayer(String name, String studentID, boolean membership)
  {
    PlayerList playerList = getAllPlayers();
    if (membership==true)
    {
      playerList.addMember(name, studentID);
    }
    else
    {
      playerList.addMember(name, studentID);
    }
    savePlayers(playerList);
  }

  private void refreshAvailabilityOfGames()
  {
    ReservationList reservationList = getReservationList();
    GameCollection gameCollection = getAllGames();
    ArrayList<Reservation> reservations = reservationList.getList();

    for (Reservation element: reservations)
    {
      if (element.getStartDate().equals(DateTime.today()))
      {
        gameCollection.getGame(element.getGame()).setReserved(true);
      }
      else if (element.getStartDate().isBefore(DateTime.today()) && !(element.getEndDate().isBefore(DateTime.today())))
      {
        gameCollection.getGame(element.getGame()).setReserved(true);
      }
      else if(element.getEndDate().isBefore(DateTime.today()))
      {
        gameCollection.getGame(element.getGame()).setReserved(false);
        reservationList.removeReservation(element);
      }
    }
    saveReservations(reservationList);
    saveCollection(gameCollection);
  }



}
