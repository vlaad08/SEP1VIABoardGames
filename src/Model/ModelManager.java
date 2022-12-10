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
      System.out.println("IO Error reading game file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return collection;
  }

  public ReservationList getAllReservations()
  {
    refreshReservation();
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
      System.out.println("IO Error reading reservation file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return reservations;
  }

  private ReservationList getReservations()
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
      System.out.println("IO Error reading reservation file");
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
      System.out.println("IO Error reading event file");
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
      System.out.println("IO Error reading player file");
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

  public ArrayList<Game> displayAvailableGames()
  {
    refreshReservation();
    GameCollection gameCollection = getAllGames();
    ArrayList<Game> games = gameCollection.getList();

    ArrayList<Game> reservedGames = getAllReservations().getBorrowedGames();
    for(int i=0;i< games.size();i++)
    {
      for(Game borrowedGame: reservedGames)
      {
        if(games.get(i).equals(borrowedGame))
        {
          games.remove(games.get(i));
        }
      }
    }
    return games;
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



  public void reserve(Player player, Game game, DateTime startDate, DateTime endDate)
  {
    ReservationList reservationList = getAllReservations();
    reservationList.addReservation(game, player, startDate, endDate);
    saveReservations(reservationList);
  }

  public void borrow(Player player, Game game,DateTime endDate)
  {
    ReservationList reservationList = getAllReservations();
    reservationList.addBorrow(game,player,DateTime.today(),endDate);
    saveReservations(reservationList);
  }

  public void removeReservation(Reservation reservation)
  {
    ReservationList reservationList = getAllReservations();
    reservationList.removeReservation(getReservation(reservation.getGame().getTitle(),reservation.getPlayer().getStudentID()));
    saveReservations(reservationList);
  }

  public Reservation getReservation(String gameTitle, String studentID)
  {
    ReservationList reservationList = getReservations();
    ArrayList<Reservation> reservations = reservationList.getList();
    try
    {
      for(Reservation element: reservations)
      {
        if(element.getGame().equals(getGame(gameTitle)) &&
            element.getPlayer().equals(getPlayerByStudentID(studentID)))
        {
          return element;
        }
      }
    } catch (NullPointerException e)
    {
      e.fillInStackTrace();
    }
    return null;
  }

  public void addEvent(String title, String description, String image, DateTime startDate, DateTime endDate)
  {
    EventList eventList = getAllEvents();
    eventList.addEvent(title, description, startDate, endDate, image);
    saveEvents(eventList);
  }

  public void removeEvent(Event event)
  {
    EventList eventList = getAllEvents();
    eventList.removeEvent(event);
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
      playerList.addGuest(name, studentID);
    }
    savePlayers(playerList);
  }

  public void editPlayer(String name, String studentID, boolean membership)
  {
    PlayerList playerList = getAllPlayers();
    ArrayList<Player> players = playerList.getList();
    for(Player element: players)
    {
      if(element.getStudentID().equals(studentID))
      {
        element.setName(name);
        element.setMembership(membership);
      }
    }
    savePlayers(playerList);
  }



  private void refreshReservation()
  {
    ReservationList  reservationList = getReservations();
    ArrayList<Reservation> reservations = reservationList.getList();
    for (Reservation element: reservations)
    {
      if (element.getStartDate().equals(DateTime.today()))
      {
        element.setBorrow(true);
      }
      else if (element.getStartDate().isBefore(DateTime.today()) && DateTime.today().isBefore(element.getEndDate()))
      {
        element.setBorrow(true);
      }
      else if(element.getEndDate().isBefore(DateTime.today()))
      {
        element.setBorrow(false);
      }
    }
    saveReservations(reservationList);
  }

  public void returnXMLFile() throws FileNotFoundException
  {
    ArrayList<Game> games = getAllGames().getList();
    ArrayList<Player> players = getAllPlayers().getList();
    ArrayList<Reservation> reservations = getAllReservations().getList();
    ArrayList<Event> events = getAllEvents().getList();


    String txt = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n <VIABoardGames> \n <players> \n";
    for(Player a: players)
    {
      txt += "<player>\n<name>" + a.getName() + "</name>\n<studentID>" + a.getStudentID() +  "</studentID>\n</player>\n";
    }
    txt += "</players>\n<games>\n";
    for(Game a: games)
    {
      txt += "<game>\n<title>" + a.getTitle() + "</title>\n<owner>" + a.getOwner() + "</owner>\n<maxNumberOfPlayers>" + a.getMaxPlayers() + "</maxNumberOfPlayers>\n<rating>" +
          a.getAverageRating() +  "</rating>\n</game>\n";
    }
    txt += "</games>\n<reservations>\n";
    for(Reservation a: reservations)
    {
      txt += "<reservation>\n<game>" + a.getGame().getTitle() + "</game> \n <borrower> <name>" + a.getPlayer().getName() + "</name><studentID>" + a.getPlayer().getStudentID() +
      "</studentID></borrower>\n<dates><startDate>" + a.getStartDate() + "</startDate><endDate>" + a.getEndDate() + "</endDate></dates>\n</reservation>\n";
    }
    txt += "</reservations>\n<events>\n";
    for(Event a: events)
    {
      txt += "<event>\n<title>" + a.getTitle() + "</title>\n<description>" + a.getDescription() + "</description>\n<imageURL>" + a.getImage() + "</imageURL>\n<dates><startDate>" + a.getStartDate() + "</startDate><endDate>" + a.getEndDate() + "</endDate></dates>\n</event>\n";
    }
    txt += "</events>\n</VIABoardGames>";
    MyFileHandler.writeToTextFile("VIABoardGames.xml", txt);
  }
}
