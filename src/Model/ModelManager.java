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
    PlayerList players = new PlayerList(); //This takes 1 for the "=" and O(1) for creating the PlayerList() (See the PlayerList class's constructor) = O(1)

    try
    {
      players = (PlayerList) MyFileHandler.readFromBinaryFile(playerListFileName); //This takes 1 for the "=" and O(n) for ".readFromBinaryFile()" = O(n)
                                                                                    // (See the "readFromBinaryFile()" time complexity analysis in MyFileHandler class
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found"); //This takes 1 for the "System.out.println()" = O(1)
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading player file"); //This takes 1 for the "System.out.println()" = O(1)
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");//This takes 1 for the "System.out.println()" = O(1)
    }

    return players; //This takes 1

    /*
    The time complexity of the getAllPlayers() method is:
    T(n) = O(1) + O(n) + (O(1)+O(1)+O(1)) + O(1) ===> Ignoring all the coefficients and constants (O(1)), we get
    T(n) = O(n)
    ((O(1)+O(1)+O(1)) --> this expression shows the catches' time complexity which can occur, but not in every situation.
    T(n) is O(1) in this case, which is ignored, as the O(n) dominates in the expression above)
    */
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
      MyFileHandler.writeToBinaryFile(playerListFileName,players); //This takes O(n) (see the "writeToBinaryFile()" method's time complexity analysis
                                                                   // in the MyFileHandler class = O(n)
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found"); //This takes 1 for the " System.out.println()" = O(1)
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file"); // This takes 1 for the " System.out.println()" = O(1)
    }

    /*
    The time complexity of the savePlayer() is:
    T(n) = O(n) + O(1) + O(1) ===> T(n) = O(n)
    */
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

  public void editGame(String oldTitle, String newTitle, int newPlayers, Player owner)
  {
    Game oldGame = getGame(oldTitle);
    Game newGame = oldGame.copy();
    newGame.setTitle(newTitle);
    newGame.setMaxPlayers(newPlayers);
    newGame.setOwner(owner);

    addGame(newGame);

    ReservationList reservationList = getReservations();
    ArrayList<Reservation> reservations = reservationList.getList();

    ArrayList<Reservation> oldByGame = reservationList.getByGame(oldGame);

    ArrayList<Reservation> newByGame = new ArrayList<>();
    for(Reservation element: oldByGame)
    {
      newByGame.add(new Reservation(newGame, element.getPlayer(),element.getStartDate(),element.getEndDate(),element.isBorrow()));
    }

    //Removing past reservation with the oldGame
    for(Reservation element: oldByGame)
    {
      reservations.remove(element);
    }

    //Adding new reservation with newGame
    for(Reservation element: newByGame)
    {
      reservations.add(element);
    }

    removeGame(oldGame);
    saveReservations(reservationList);
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
    PlayerList playerList = getAllPlayers();//This takes 1 for the "=" and O(n) for the "getAllPlayer()" = O(n) (See the "getAllPlayer()"'s time complexity analysis)
    if (membership==true) //This takes 1 for the check ("==") = O(1)
    {
      playerList.addMember(name, studentID); // This takes O(1) (See the "addMember()" method's time complexity analysis in the PlayerList class)
    }
    else
    {
      playerList.addGuest(name, studentID); // This takes O(1) (See the "addGuest()" method's time complexity analysis in the PlayerList class)
    }
    savePlayers(playerList); //This takes O(n) (See the savePlayer() method's time complexity analysis)

    /*
    The time complexity of the addPlayer() method is:
    T(n) = O(n) + O(1) + O(1) + O(1) + O(n) ===> Ignoring all the coefficients and constants (O(1)), we get
    T(n) = O(n)
    */
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

  public void XMLFile() throws FileNotFoundException
  {
    try{ArrayList<Game> games = getAllGames().getList();
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
      txt += "<game>\n<title>" + a.getTitle() + "</title>\n<owner>" + a.getOwner().getName() + "</owner>\n<maxNumberOfPlayers>" + a.getMaxPlayers() + "</maxNumberOfPlayers>\n<rating>" +
          a.getAverageRating() +  "</rating>\n<image>"+ a.getImage() +"</image>\n</game>\n";
    }
    txt += "</games>\n<reservations>\n";
    for(Reservation a: reservations)
    {
      txt += "<reservation>\n<gameReservation>" + a.getGame().getTitle() + "</gameReservation> \n <borrower> <name>" + a.getPlayer().getName() + "</name><studentID>" + a.getPlayer().getStudentID() +
      "</studentID></borrower>\n<dates><startDate>" + a.getStartDate() + "</startDate><endDate>" + a.getEndDate() + "</endDate></dates>\n</reservation>\n";
    }
    txt += "</reservations>\n<events>\n";
    for(Event a: events)
    {
      txt += "<event>\n<title>" + a.getTitle() + "</title>\n<description>" + a.getDescription() + "</description>\n<imageURL>" + a.getImage() + "</imageURL>\n<dates><startDate>" + a.getStartDate() + "</startDate><endDate>" + a.getEndDate() + "</endDate></dates>\n</event>\n";
    }
    txt += "</events>\n</VIABoardGames>";
    MyFileHandler.writeToTextFile("VIABoardGamesWebsite/xml/VIABoardGames.xml", txt);}

    catch(NullPointerException e)
    {
      e.fillInStackTrace();
    }
  }
}
