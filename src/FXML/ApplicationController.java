package FXML;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ApplicationController
{
  ModelManager modelManager=new ModelManager("gameCollection.bin","playerList.bin",
      "reservationList.bin","eventList.bin");


  private  ObservableList<Player> playerData= FXCollections.observableArrayList();
  private  ObservableList<Player> memberData= FXCollections.observableArrayList();
  private  ObservableList<Game> gameData= FXCollections.observableArrayList();
  private  ObservableList<Reservation> reservationData = FXCollections.observableArrayList();
  private  ObservableList<Integer> ratingData = FXCollections.observableArrayList();
  private  ObservableList<Integer> hourData = FXCollections.observableArrayList();




  // Game - Add Game
  @FXML private ComboBox<Player> addOwners_Game;
  @FXML private TextField addTitle_Game;
  @FXML private TextField addMaxNumOfPlayers_Game;
  @FXML private Button addSave_Game;
  // Game - Edit Game
  @FXML private ComboBox<Player> editOwners_Game;
  @FXML private ComboBox<Game> editGames_Game;
  @FXML private TextField editTitle_Game;
  @FXML private TextField editMaxNumOfPlayers_Game;
  @FXML private Button editSave_Game;
  //Game - Remove Game
  @FXML private ComboBox<Game> removeGames_Game;
  @FXML private Button removeSave_Game;
  //Game - Game List
  @FXML private TextArea displayGames_Game;

  @FXML private ComboBox<Game> ratingTabGameComboBox_Game;
  @FXML private ComboBox<Integer> ratingTabRatingComboBox_Game;
  @FXML private Button ratingTabSaveButton_Game;

  @FXML private ComboBox<Player> studentIdBorr_BorrowReserve;
  @FXML private ComboBox<Game> gameBorr_BorrowReserve;
  @FXML private DatePicker reserveToBorr_BorrowReserve;
  @FXML private Button borrow_BorrowReserve;
  @FXML private ComboBox<Integer> hourBorr_BorrowReserve;



  @FXML private ComboBox<Player> studentIdRes_BorrowReserve;
  @FXML private ComboBox<Game> gameRes_BorrowReserve;
  @FXML private DatePicker fromRes_BorrowReserve;
  @FXML private DatePicker toRes_BorrowReserve;
  @FXML private Button reserve_BorrowReserve;
  @FXML private ComboBox<Integer> startHour_BorrowReserve;
  @FXML private ComboBox<Integer> endHour_BorrowReserve;

  @FXML private Button removeReservation_BorrowReserve;
  @FXML private ComboBox<Reservation> reservationsToRemove_BorrowReserve;

  @FXML private TextArea reservationList_BorrowReserve;


  @FXML private TextField playerName;
  @FXML private TextField playerID;
  @FXML private TextField name2;
  @FXML private ComboBox<Player> playerBox;
  @FXML private Label labelForPlayers;
  @FXML private Button revokeButton;
  @FXML private Button saveChangesButton;
  @FXML private Button removePlayerButton;
  @FXML private Button addMember_Player;
  @FXML private Button addGuest_Player;

  @FXML private TextField titleInput_Event;
  @FXML private TextArea descriptionInput_Event;
  @FXML private TextField imageURLInput_Event;
  @FXML private DatePicker startDateInput_Event;
  @FXML private DatePicker endDateInput_Event;
  @FXML private Button saveButton_Event;
  @FXML private TextArea eventsDisplayed;
  @FXML private ComboBox<Event> eventComboBox;

  @FXML private TextField titleInputEdit_Event;
  @FXML private TextArea descriptionInputEdit_Event;
  @FXML private TextField imageURLEDIT_Event;
  @FXML private DatePicker startDateEdit_Event;
  @FXML private DatePicker endDateEdit_Event;
  @FXML private Button saveEditButton_Event;
  @FXML private Button removeButton_Event;

  public void handleEvent(ActionEvent e) throws FileNotFoundException
  {
    if(e.getSource() == saveButton_Event)
    {
      try
      {
        String title = titleInput_Event.getText();
        String description = descriptionInput_Event.getText();
        String imageURL = imageURLInput_Event.getText();
        int startYear = startDateInput_Event.getValue().getYear(), startMonth = startDateInput_Event.getValue().getMonthValue(), startDay = startDateInput_Event.getValue().getDayOfMonth();
        int endYear = endDateInput_Event.getValue().getYear(), endMonth = endDateInput_Event.getValue().getMonthValue(), endDay = endDateInput_Event.getValue().getDayOfMonth();

        modelManager.addEvent(title, description, imageURL, new DateTime(startYear, startMonth, startDay), new DateTime(endYear, endMonth, endDay));
        JOptionPane.showMessageDialog(null,"The event was created","Confirmation message",
            JOptionPane.INFORMATION_MESSAGE);


        titleInput_Event.setText("");
        descriptionInput_Event.setText("");
        imageURLInput_Event.setText("");
        startDateInput_Event.setValue(null);
        endDateInput_Event.setValue(null);


        refreshComboEvent();
        reloadEventListAndDisplay();
      }catch (RuntimeException f)
      {
        f.fillInStackTrace();
        JOptionPane.showMessageDialog(null,"Fill out all the fields", "Missing information",JOptionPane.ERROR_MESSAGE);
      }



    }
    else if(e.getSource() == saveEditButton_Event)
    {

        try
        {
          EventList eventList = modelManager.getAllEvents();
          Event temp = eventList.getEvent(eventComboBox.getSelectionModel().getSelectedItem().getTitle());
          eventList.removeEvent(temp);
          modelManager.saveEvents(eventList);

          String title = titleInputEdit_Event.getText();
          String description = descriptionInputEdit_Event.getText();
          String imageURL = imageURLEDIT_Event.getText();
          int startYear = startDateEdit_Event.getValue().getYear(), startMonth = startDateEdit_Event.getValue().getMonthValue(), startDay = startDateEdit_Event.getValue().getDayOfMonth();
          int endYear = endDateEdit_Event.getValue().getYear(), endMonth = endDateEdit_Event.getValue().getMonthValue(), endDay = endDateEdit_Event.getValue().getDayOfMonth();

          modelManager.addEvent(title, description, imageURL, new DateTime(startYear, startMonth, startDay), new DateTime(endYear, endMonth, endDay));

          JOptionPane.showMessageDialog(null,"The event was successfully edited","Confirmation message",
              JOptionPane.INFORMATION_MESSAGE);


          reloadEventListAndDisplay();
          refreshComboEvent();

          titleInputEdit_Event.clear();
          descriptionInputEdit_Event.clear();
          imageURLEDIT_Event.clear();
          startDateEdit_Event.setValue(null);
          endDateEdit_Event.setValue(null);
          eventComboBox.getSelectionModel().clearSelection();
        }
        catch (NullPointerException exception)
        {
          exception.fillInStackTrace();
        }

    }
    else if(e.getSource() == removeButton_Event)
    {
      try
      {
        EventList eventList = modelManager.getAllEvents();
        Event temp = eventList.getEvent(eventComboBox.getSelectionModel().getSelectedItem().getTitle());
        eventList.removeEvent(temp);
        modelManager.saveEvents(eventList);

        reloadEventListAndDisplay();
        refreshComboEvent();

        JOptionPane.showMessageDialog(null,"The event was successfully removed","Confirmation message",
            JOptionPane.INFORMATION_MESSAGE);

        titleInputEdit_Event.clear();
        descriptionInputEdit_Event.clear();
        imageURLEDIT_Event.clear();
        startDateEdit_Event.setValue(null);
        endDateEdit_Event.setValue(null);
        eventComboBox.getSelectionModel().clearSelection();

      }
      catch (NullPointerException exception)
      {
        exception.fillInStackTrace();
      }
    }
    else if(e.getSource() == eventComboBox)
    {
      try
      {
        Event event = eventComboBox.getSelectionModel().getSelectedItem();


        titleInputEdit_Event.setText(event.getTitle());
        descriptionInputEdit_Event.setText(event.getDescription());
        imageURLEDIT_Event.setText(event.getImage());
      }
      catch (NullPointerException exception)
      {
        exception.fillInStackTrace();
      }
    }

    modelManager.XMLFile();
  }

  public void reloadEventListAndDisplay()
  {
    String text="";
    ArrayList<Event> events = modelManager.getAllEvents().getList();
    for (int i = 0; i < events.size(); i++)
    {
      text += events.get(i).toString()+"\n";
    }
    eventsDisplayed.setText(text);
  }

  public void refreshComboEvent()
  {
    try
    {
      ArrayList<Event> events = modelManager.getAllEvents().getList();
      eventComboBox.getItems().clear();

      for(Event element: events)
      {
        eventComboBox.getItems().add(element);
      }
    }
    catch (NullPointerException exception)
    {
      exception.fillInStackTrace();
    }
  }



  public void handlerGame (ActionEvent e) throws FileNotFoundException
  {
    if (e.getSource()== addSave_Game)
    {
      try
      {
        Game newGame=new Game(addTitle_Game.getText(),Integer.parseInt(
            addMaxNumOfPlayers_Game.getText()),
            addOwners_Game.getSelectionModel().getSelectedItem());
        modelManager.addGame(newGame);

        initialize();
        displayRefreshedGameList();

        JOptionPane.showMessageDialog(null,"The game was added to the collection","Confirmation message",JOptionPane.INFORMATION_MESSAGE);

      }
      catch (RuntimeException f)
      {
        f.fillInStackTrace();
        JOptionPane.showMessageDialog(null,"Fill out all the fields", "Missing information",JOptionPane.ERROR_MESSAGE);
      }
      }
    if (e.getSource()== editSave_Game)
    {
      Game selectedGame = editGames_Game.getSelectionModel().getSelectedItem();

      if(selectedGame!=null)
      {
        modelManager.editGame(selectedGame.getTitle(),editTitle_Game.getText(),
            selectedGame.getMaxPlayers(),Integer.parseInt(editMaxNumOfPlayers_Game.getText())
            ,selectedGame.getOwner());
        editTitle_Game.setText("");
        editMaxNumOfPlayers_Game.setText("");
      }
      JOptionPane.showMessageDialog(null,"The game was successfully edited","Confirmation message",JOptionPane.INFORMATION_MESSAGE);
      initialize();

      /*
      Game oldGame= editGames_Game.getSelectionModel().getSelectedItem();
      modelManager.removeGame(oldGame);
      Game editedGame=new Game(editTitle_Game.getText(),Integer.parseInt(
          editMaxNumOfPlayers_Game.getText()),
          editOwners_Game.getSelectionModel().getSelectedItem());
      modelManager.addGame(editedGame);

      initialize();
      displayRefreshedGameList();

       */

//      JOptionPane.showMessageDialog(null,"The game was successfully edited","Confirmation message",JOptionPane.INFORMATION_MESSAGE);
    }
    if (e.getSource()== removeSave_Game)
    {
      Game gameToRemove= removeGames_Game.getSelectionModel().getSelectedItem();
      modelManager.removeGame(gameToRemove);


      initialize();
      displayRefreshedGameList();

      JOptionPane.showMessageDialog(null,"The game was successfully removed","Confirmation message",JOptionPane.INFORMATION_MESSAGE);
    }

    if(e.getSource() == ratingTabSaveButton_Game)
    {
      Game game = ratingTabGameComboBox_Game.getValue();
      int rating = ratingTabRatingComboBox_Game.getValue();
      modelManager.rateAGame(game,rating);
      initialize();
      System.out.println(game);
    }

    if (e.getSource()==editGames_Game)
    {
      Game game=editGames_Game.getSelectionModel().getSelectedItem();
      editTitle_Game.setText(game.getTitle());
      editMaxNumOfPlayers_Game.setText(Integer.toString(game.getMaxPlayers()));
    }


    modelManager.XMLFile();
  }


  public void initialize()
  {
    ArrayList<Player> players = modelManager.getAllPlayers().getList();
    ArrayList<Game> collection = modelManager.getAllGames().getList();
    ArrayList<Reservation> reservations = modelManager.getAllReservations().getList();
    ArrayList<Player> members=modelManager.getAllPlayers().getList();
    members.removeIf(element -> !element.isMembership());

    memberData.clear();
    memberData.addAll(members);
    studentIdRes_BorrowReserve.setItems(memberData);

    reservationData.clear();
    reservationData.addAll(reservations);
    reservationsToRemove_BorrowReserve.setItems(reservationData);

    playerData.clear();
    playerData.addAll(players);
    addOwners_Game.setItems(playerData);
    editOwners_Game.setItems(playerData);
    studentIdBorr_BorrowReserve.setItems(playerData);

    gameData.clear();
    gameData.addAll(collection);
    editGames_Game.setItems(gameData);
    removeGames_Game.setItems(gameData);
    ratingTabGameComboBox_Game.setItems(gameData);
    gameBorr_BorrowReserve.setItems(gameData);
    gameRes_BorrowReserve.setItems(gameData);

    name2.setEditable(true);
    updatePlayersArea();
    resetPlayer();
    reloadEventListAndDisplay();
    refreshComboEvent();

    ratingData.clear();
    Integer[] ratings = {1,2,3,4,5};
    ratingData.addAll(ratings);
    ratingTabRatingComboBox_Game.setItems(ratingData);

    hourData.clear();
    Integer[] hours={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
    hourData.addAll(hours);
    startHour_BorrowReserve.setItems(hourData);
    endHour_BorrowReserve.setItems(hourData);
    hourBorr_BorrowReserve.setItems(hourData);
  }
  public void displayRefreshedGameList()
  {
    String text="";
    ArrayList<Game> collection=modelManager.getAllGames().getList();
    for (int i = 0; i < collection.size(); i++)
    {
      text += collection.get(i).toString()+"\n";
    }
    displayGames_Game.setText(text);
  }



  public void handlerBorrowReserve(ActionEvent e) throws FileNotFoundException
  {

    if(e.getSource() == borrow_BorrowReserve)
    {
      if(studentIdBorr_BorrowReserve.getValue().getStudentID() != null && gameBorr_BorrowReserve.getValue() != null && reserveToBorr_BorrowReserve.getValue() != null && hourBorr_BorrowReserve.getValue() != null)
      {
        Player player = modelManager.getPlayerByStudentID(
            studentIdBorr_BorrowReserve.getValue().getStudentID());
        Game gameSelect = gameBorr_BorrowReserve.getValue();

        int endDay = reserveToBorr_BorrowReserve.getValue().getDayOfMonth();
        int endMonth = reserveToBorr_BorrowReserve.getValue().getMonthValue();
        int endYear = reserveToBorr_BorrowReserve.getValue().getYear();
        int endHour = hourBorr_BorrowReserve.getValue();
        DateTime end = new DateTime(endYear, endMonth, endDay, endHour);
        DateTime start=DateTime.today();

        if (!end.isBefore(DateTime.today()))
        {
          boolean isTrue=true;
          ArrayList<Reservation> reservations=modelManager.getAllReservations().getList();
          //          System.out.println(reservations);
          for (Reservation element:reservations)
          {
            if (element.getGame().equals(gameBorr_BorrowReserve.getValue()))
            {
              if (end.isBefore(element.getEndDate())&&element.getStartDate().isBefore(end))
              {
                //                JOptionPane.showMessageDialog(null,"Cannot reserve in this time period\n"
                //                    +"The game is reserved from: "+element.getStartDate()+"\n"
                //                    + "To: "+element.getEndDate(),"Error message",JOptionPane.ERROR_MESSAGE);
                System.out.println("Cannot reserve in this time period\n"
                    +"The game is reserved from: "+element.getStartDate()+"\n"
                    + "To: "+element.getEndDate());
                isTrue=false;
                break;
                //                initialize();
              }
              if (!start.isBefore(element.getStartDate())&&start.isBefore(element.getEndDate()))
              {
                //                JOptionPane.showMessageDialog(null,"Cannot reserve in this time period\n"
                //                    +"The game is reserved from: "+element.getStartDate()+"\n"
                //                    + "To: "+element.getEndDate(),"Error message",JOptionPane.ERROR_MESSAGE);
                System.out.println("Cannot reserve in this time period\n"
                    +"The game is reserved from: "+element.getStartDate()+"\n"
                    + "To: "+element.getEndDate());
                isTrue=false;
                break;
                //                initialize();
              }
              if (!start.isBefore(element.getStartDate())&&start.isBefore(element.getEndDate())&&end.isBefore(element.getEndDate())&&!end.isBefore(element.getStartDate()))
              {
                //                JOptionPane.showMessageDialog(null,"Cannot reserve in this time period\n"
                //                    +"The game is reserved from: "+element.getStartDate()+"\n"
                //                    + "To: "+element.getEndDate(),"Error message",JOptionPane.ERROR_MESSAGE);
                System.out.println("Cannot reserve in this time period\n"
                    +"The game is reserved from: "+element.getStartDate()+"\n"
                    + "To: "+element.getEndDate());
                isTrue=false;
                break;
                //                initialize();
              }
              if (start.isBefore(element.getStartDate())&&!end.isBefore(element.getEndDate()))
              {
                //                JOptionPane.showMessageDialog(null,"Cannot reserve in this time period\n"
                //                    +"The game is reserved from: "+element.getStartDate()+"\n"
                //                    + "To: "+element.getEndDate(),"Error message",JOptionPane.ERROR_MESSAGE);
                System.out.println("Cannot reserve in this time period\n"
                    +"The game is reserved from: "+element.getStartDate()+"\n"
                    + "To: "+element.getEndDate());
                isTrue=false;
                break;
                //                initialize();
              }
            }
          }
          if (isTrue)
          {
            modelManager.borrow(player, gameSelect, end);

            JOptionPane.showMessageDialog(null,
                gameSelect + "game has been borrowed to: " + player + "till: "
                    + endHour + "hour", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            initialize();
          }

        }else
        {
//          JOptionPane.showMessageDialog(null,"The date is in the past!","Error message",JOptionPane.ERROR_MESSAGE);
          System.out.println("past");
          initialize();
        }
      }
      else {
//        JOptionPane.showMessageDialog(null,"Please fill out all fields!:)", "Missing information", JOptionPane.ERROR_MESSAGE);
        System.out.println("fill out");
        initialize();
      }
    }

    if(e.getSource() == reserve_BorrowReserve)
    {
      if(studentIdRes_BorrowReserve.getValue().getStudentID() != null && gameRes_BorrowReserve.getValue() != null && fromRes_BorrowReserve.getValue() != null && toRes_BorrowReserve.getValue() != null &&
          startHour_BorrowReserve.getValue()!= null && endHour_BorrowReserve.getValue() != null)
      {
        Player player = modelManager.getPlayerByStudentID(
            studentIdRes_BorrowReserve.getValue().getStudentID());
        Game gameSelect = gameRes_BorrowReserve.getValue();

        int startDay = fromRes_BorrowReserve.getValue().getDayOfMonth();
        int startMonth = fromRes_BorrowReserve.getValue().getMonthValue();
        int startYear = fromRes_BorrowReserve.getValue().getYear();
        int startHour = startHour_BorrowReserve.getValue();
        DateTime start = new DateTime(startYear, startMonth, startDay, startHour);

        int endDay = toRes_BorrowReserve.getValue().getDayOfMonth();
        int endMonth = toRes_BorrowReserve.getValue().getMonthValue();
        int endYear = toRes_BorrowReserve.getValue().getYear();
        int endHour = endHour_BorrowReserve.getValue();
        DateTime end = new DateTime(endYear, endMonth, endDay, endHour);

        if (start.isBefore(end))
        {
          boolean isTrue=true;
          ArrayList<Reservation> reservations=modelManager.getAllReservations().getList();
//          System.out.println(reservations);
          for (Reservation element:reservations)
          {
            if (element.getGame().equals(gameRes_BorrowReserve.getValue()))
            {
              if (end.isBefore(element.getEndDate())&&element.getStartDate().isBefore(end))
              {
//                JOptionPane.showMessageDialog(null,"Cannot reserve in this time period\n"
//                    +"The game is reserved from: "+element.getStartDate()+"\n"
//                    + "To: "+element.getEndDate(),"Error message",JOptionPane.ERROR_MESSAGE);
                System.out.println("Cannot reserve in this time period\n"
                    +"The game is reserved from: "+element.getStartDate()+"\n"
                    + "To: "+element.getEndDate());
                isTrue=false;
                break;
//                initialize();
              }
              if (!start.isBefore(element.getStartDate())&&start.isBefore(element.getEndDate()))
              {
//                JOptionPane.showMessageDialog(null,"Cannot reserve in this time period\n"
                    //                    +"The game is reserved from: "+element.getStartDate()+"\n"
                    //                    + "To: "+element.getEndDate(),"Error message",JOptionPane.ERROR_MESSAGE);
                System.out.println("Cannot reserve in this time period\n"
                    +"The game is reserved from: "+element.getStartDate()+"\n"
                    + "To: "+element.getEndDate());
                isTrue=false;
                break;
//                initialize();
              }
              if (!start.isBefore(element.getStartDate())&&start.isBefore(element.getEndDate())&&end.isBefore(element.getEndDate())&&!end.isBefore(element.getStartDate()))
              {
//                JOptionPane.showMessageDialog(null,"Cannot reserve in this time period\n"
                    //                    +"The game is reserved from: "+element.getStartDate()+"\n"
                    //                    + "To: "+element.getEndDate(),"Error message",JOptionPane.ERROR_MESSAGE);
                    System.out.println("Cannot reserve in this time period\n"
                        +"The game is reserved from: "+element.getStartDate()+"\n"
                        + "To: "+element.getEndDate());
                isTrue=false;
                break;
                //                initialize();
              }
              if (start.isBefore(element.getStartDate())&&!end.isBefore(element.getEndDate()))
              {
                //                JOptionPane.showMessageDialog(null,"Cannot reserve in this time period\n"
                //                    +"The game is reserved from: "+element.getStartDate()+"\n"
                //                    + "To: "+element.getEndDate(),"Error message",JOptionPane.ERROR_MESSAGE);
                System.out.println("Cannot reserve in this time period\n"
                    +"The game is reserved from: "+element.getStartDate()+"\n"
                    + "To: "+element.getEndDate());
                isTrue=false;
                break;
                //                initialize();
              }
            }
          }
          if (isTrue)
          {
            modelManager.reserve(player, gameSelect, start, end);

            //          JOptionPane.showMessageDialog(null,gameSelect + "Game has been borrowed by: " + player + "from: "
            //                  + start + "til: " + end ,"Confirmation", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("done");
            initialize();
          }
        }else
        {
//          JOptionPane.showMessageDialog(null,"The date is in the past!","Error message",JOptionPane.ERROR_MESSAGE);
          System.out.println("past");
          System.out.println(start.getYear());
          System.out.println(start.getMonthName());
          System.out.println(start.getDay());
          System.out.println(start.getHour());
          System.out.println("fasz");
          System.out.println(end.getYear());
          System.out.println(end.getMonthName());
          System.out.println(end.getDay());
          System.out.println(end.getHour());
          System.out.println("Today");
          System.out.println(DateTime.today().getYear());
          System.out.println(DateTime.today().getMonthName());
          System.out.println(DateTime.today().getDay());
          System.out.println(DateTime.today().getHour());
          System.out.println(start.isBefore(DateTime.today()));
          System.out.println(start.isBefore(end));
//          initialize();
        }
      }
      else {
//        JOptionPane.showMessageDialog(null,"Please fill out all fields!:)", "Missing information", JOptionPane.ERROR_MESSAGE);
        System.out.println("fill out");
      }

    }

    if (e.getSource() == removeReservation_BorrowReserve)
    {
      try{
        Reservation reservationToRemove=modelManager.getReservation(reservationsToRemove_BorrowReserve.getValue().getGame().getTitle(),reservationsToRemove_BorrowReserve.getValue().getPlayer().getStudentID());
        modelManager.removeReservation(reservationToRemove);
        System.out.println(reservationToRemove);
        initialize();
        displayRefreshedReservationList();
      }catch (RuntimeException f)
      {
        f.fillInStackTrace();
      }

    }

    try
    {
      modelManager.XMLFile();
    }

    catch(NullPointerException f)
    {
      f.fillInStackTrace();
    }
  }

  public void displayRefreshedReservationList()
  {
    String text="";
    ArrayList<Reservation> reservations = modelManager.getAllReservations().getList();
    for (int i = 0; i < reservations.size(); i++)
    {
      if (reservations.get(i).getEndDate().isBefore(DateTime.today()))
      {
        reservations.remove(reservations.get(i));
      }else
      {
        text+=reservations.get(i).toString()+"\n";
      }

    }
    reservationList_BorrowReserve.setText(text);
  }



  public void addPlayer(ActionEvent e) throws FileNotFoundException
  {
    String name = playerName.getText();
    String iD = playerID.getText();

    if(e.getSource()==addMember_Player)
    {
      modelManager.addPlayer(name, iD, true);
      JOptionPane.showMessageDialog(null,"Member was created.");
      updatePlayersArea();
      updatePlayersBox();
    } else if(e.getSource()==addGuest_Player)
    {
      modelManager.addPlayer(name, iD, false);
      JOptionPane.showMessageDialog(null,"Guest was created.");
      updatePlayersArea();
      updatePlayersBox();
    }
    playerName.setText("");
    playerID.setText("");

    modelManager.XMLFile();
  }
  private void updatePlayersArea()
  {
    PlayerList playerList = modelManager.getAllPlayers();
    labelForPlayers.setText(playerList.toString());
  }

  public void resetPlayer()
  {
    if(modelManager!=null)
    {
      updatePlayersBox();
      Player temp = playerBox.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        name2.setText(temp.getName());
      }
    }
  }

  private void updatePlayersBox()
  {
    try{
      int currentIndex = playerBox.getSelectionModel().getSelectedIndex();
    playerBox.getItems().clear();

    PlayerList players = modelManager.getAllPlayers();
    ArrayList<Player> playerArrayList = players.getList();
    for (Player element: playerArrayList)
    {
      playerBox.getItems().add(element);
    }

    if (currentIndex == -1 && playerBox.getItems().size() > 0)
    {
      playerBox.getSelectionModel().select(0);
    }
    else
    {
      playerBox.getSelectionModel().select(currentIndex);
    }
    }
    catch(IndexOutOfBoundsException p)
    {
      p.fillInStackTrace();
    }
  }

  public void handleActionsPlayer(ActionEvent e) throws FileNotFoundException
  {
    if (e.getSource() == saveChangesButton)
    {
      Player temp = playerBox.getSelectionModel().getSelectedItem();
      String firstName = name2.getText();
      int choice = JOptionPane.showConfirmDialog(null,"Are you sure?");

      if(temp != null && choice == 0)
      {
        modelManager.editPlayer(firstName, playerBox.getSelectionModel().getSelectedItem().getStudentID(),
            playerBox.getSelectionModel().getSelectedItem().isMembership());
        updatePlayersBox();
        updatePlayersArea();
      }
    }
    else if (e.getSource() == playerBox)
    {
      Player temp = playerBox.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        name2.setText(temp.getName());
      }
    }
    else if (e.getSource() == revokeButton)
    {
      Player temp = playerBox.getSelectionModel().getSelectedItem();
      int choice = JOptionPane.showConfirmDialog(null,"Are you sure?");
      if (temp != null && choice==0)
      {
        temp.setMembership(!temp.isMembership());
        modelManager.editPlayer(temp.getName(), temp.getStudentID(), temp.isMembership());
        updatePlayersBox();
        updatePlayersArea();
      }
    }
    else if (e.getSource() == removePlayerButton)
    {
      Player temp = playerBox.getSelectionModel().getSelectedItem();
      int choice = JOptionPane.showConfirmDialog(null,"Are you sure?");
      ReservationList reservations = modelManager.getAllReservations();
      ArrayList<Reservation> copy;
      if (temp!=null && choice==0)
      {
        copy=reservations.getByPlayer(temp);

        reservations.getList().removeAll(copy);
        modelManager.saveReservations(reservations);

        modelManager.removePlayer(temp);
        name2.clear();
        updatePlayersBox();
        updatePlayersArea();
        initialize();
        displayRefreshedReservationList();

      }

    }

    modelManager.XMLFile();
  }

}
