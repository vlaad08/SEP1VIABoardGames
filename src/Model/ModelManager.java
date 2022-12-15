package Model;

import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class for Managing the game list, player list, event list and reservation list.
 * @author Group 6
 * @version 1.0
 * */
public class ModelManager
{
  private String gameCollectionFileName;
  private String playerListFileName;
  private String reservationListFileName;
  private String eventListFileName;

  /**
   * Constructor that initializing the ModelManager.Takes as argument the name of files.
   * @param fileGameCollection game collection file
   * @param filePlayerList player list file
   * @param fileReservationList reservation file
   * @param fileEventList event list file
   */
  public ModelManager(String fileGameCollection, String filePlayerList,
      String fileReservationList, String fileEventList)
  {
      this.gameCollectionFileName = fileGameCollection;
      this.playerListFileName = filePlayerList;
      this.reservationListFileName = fileReservationList;
      this.eventListFileName = fileEventList;
  }

  /**
   * Return the GameCollection object from the binary file
   * @return GameCollection object
   */
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

  /**
   * Return the ReservationList object from the binary file
   * @return ReservationList object
   */
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

  //This Class is used for updating the reservation
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

  /**
   * Return the EventList object from the binary file
   * @return EventList object
   */
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

  /**
   * Return the PlayerList object from the binary file
   * @return playerList object
   */
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

  /**
   * Save GameCollection object to the binary file.
   * @param collection GameCollection object
   */
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

  /**
   * Save ReservationList object to the binary file.
   * @param reservations ReservationList object
   */
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

  /**
   * Save EventList object to the binary file.
   * @param events EventList object
   */
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

  /**
   * Save PlayerList object to the binary file.
   * @param players PlayerList object
   */
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

  /**
   * Get a student with a specific studentID from the player file.
   * @param studentID studentID of a player
   * @return Player object that was found
   */
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

  /**
   * Remove a player from the PlayerList file
   * @param player player object to be removed
   */
  public void removePlayer(Player player)
  {
    PlayerList playerList = getAllPlayers();
    playerList.removePlayer(player);
    savePlayers(playerList);
  }

  /**
   * Add a game to the GameCollection file
   * @param game Game object that should be added
   */
  public void addGame(Game game)
  {
    GameCollection gameCollection = getAllGames();
    gameCollection.addGame(game);
    saveCollection(gameCollection);
  }

  /**
   * Get a game with a specific title from the GameCollection file.
   * @param title title of the game
   * @return Game object that was found
   */
  public Game getGame(String title)
  {
    GameCollection gameCollection = getAllGames();
    return gameCollection.getGame(title);
  }

  /**
   * Remove a game from the GameCollection file.
   * @param game Game object to be removed
   */
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

  /**
   * Add a rate to the specific Game.
   * @param game Game that was selected
   * @param rate new rate
   */
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

  /**
   * Add a reservation to the ReservationList file.
   * @param player player that make a reservation
   * @param game game that is reserved
   * @param startDate start date for reservation
   * @param endDate end date for reservation
   */
  public void reserve(Player player, Game game, DateTime startDate, DateTime endDate)
  {
    ReservationList reservationList = getAllReservations();
    reservationList.addReservation(game, player, startDate, endDate);
    saveReservations(reservationList);
  }

  /**
   * Add a borrow to the ReservationList file.
   * @param player player that make a borrow
   * @param game game that is borrowed
   * @param endDate end date for borrow
   */
  public void borrow(Player player, Game game,DateTime endDate)
  {
    ReservationList reservationList = getAllReservations();
    reservationList.addBorrow(game,player,DateTime.today(),endDate);
    saveReservations(reservationList);
  }

  /**
   * Remove a reservation from the ReservationList file.
   * @param reservation reservation that should be removed
   */
  public void removeReservation(Reservation reservation)
  {
    ReservationList reservationList = getAllReservations();
    reservationList.removeReservation(getReservation(reservation.getGame().getTitle(),reservation.getPlayer().getStudentID()));
    saveReservations(reservationList);
  }

  /**
   * Get a reservation with a specific game title and studentID of a player from the ReservationList file.
   * @param gameTitle title of a game
   * @param studentID student ID of a player
   * @return Reservation that was found
   */
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

  /**
   * Add and Event to the EventList file
   * @param title Title of the event
   * @param description Description of the event
   * @param image Image of the event
   * @param startDate start date of the event
   * @param endDate end date of the event
   */
  public void addEvent(String title, String description, String image, DateTime startDate, DateTime endDate)
  {
    EventList eventList = getAllEvents();
    eventList.addEvent(title, description, startDate, endDate, image);
    saveEvents(eventList);
  }

  /**
   * Remove an Event object from the EventList file
   * @param event Event that should be removed
   */
  public void removeEvent(Event event)
  {
    EventList eventList = getAllEvents();
    eventList.removeEvent(event);
    saveEvents(eventList);
  }

  /**
   * Get an Event object with a specific title.
   * @param title title of the Event
   * @return Event that was found
   */
  public Event getEvent(String title)
  {
    EventList eventList = getAllEvents();
    return eventList.getEvent(title);
  }

  /**
   * Add a player to the PlayerList file.
   * @param name Name of the player
   * @param studentID Student ID of the player
   * @param membership True - if is a member. False - if is a guest.
   */
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

  /**
   * Edit information of the Player from PlayerList file.
   * @param name new Name of the Player
   * @param studentID Student ID of a player
   * @param membership Revoke / Assign membership
   */
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

  /**
   * Method that refresh Reservations from ReservationList file, and change reservation to borrow.
   */
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

  /**
   * This method creates the XML file that is required to update the website
   * */
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
