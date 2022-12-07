package FXML;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ApplicationController
{
  ModelManager modelManager=new ModelManager("gameCollection.bin","playerList.bin",
      "reservationList.bin","eventList.bin");


  private  ObservableList<Player> playerData= FXCollections.observableArrayList();
  private  ObservableList<Game> gameData= FXCollections.observableArrayList();
  private  ObservableList<Event> eventData= FXCollections.observableArrayList();
  private  ObservableList<Game> dataBorr_BorrowReserve = FXCollections.observableArrayList();
  private  ObservableList<Game> dataRes_BorrowReserve = FXCollections.observableArrayList();




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


  @FXML private TextField studentIdBorr_BorrowReserve;
  @FXML private ComboBox<Game> gameBorr_BorrowReserve;
  @FXML private DatePicker reserveToBorr_BorrowReserve;
  @FXML private Button borrow_BorrowReserve;
  @FXML private TextField hourBorr_BorrowReserve;



  @FXML private TextField studentIdRes_BorrowReserve;
  @FXML private ComboBox<Game> gameRes_BorrowReserve;
  @FXML private DatePicker fromRes_BorrowReserve;
  @FXML private DatePicker toRes_BorrowReserve;
  @FXML private Button reserve_BorrowReserve;
  @FXML private TextField startHour_BorrowReserve;
  @FXML private TextField endHour_BorrowReserve;

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

  public void handleEvent(ActionEvent e)
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
        initialize();
        reloadEventListAndDisplay();
      }
      catch (NullPointerException error)
      {
        error.fillInStackTrace();
      }

    }
    if(e.getSource() == saveEditButton_Event)
    {
      try
      {
        Event oldEvent = eventComboBox.getSelectionModel().getSelectedItem();
        modelManager.removeEvent(oldEvent);

        String title = titleInputEdit_Event.getText();
        String description = descriptionInputEdit_Event.getText();
        String imageURL = imageURLEDIT_Event.getText();
        int startYear = startDateEdit_Event.getValue().getYear(), startMonth = startDateEdit_Event.getValue().getMonthValue(), startDay = startDateEdit_Event.getValue().getDayOfMonth();
        int endYear = endDateEdit_Event.getValue().getYear(), endMonth = endDateEdit_Event.getValue().getMonthValue(), endDay = endDateEdit_Event.getValue().getDayOfMonth();

        modelManager.addEvent(title, description, imageURL, new DateTime(startYear, startMonth, startDay), new DateTime(endYear, endMonth, endDay));

        JOptionPane.showMessageDialog(null,"The event was successfully edited","Confirmation message",
            JOptionPane.INFORMATION_MESSAGE);
        initialize();
        reloadEventListAndDisplay();

        titleInputEdit_Event.setText("");
        descriptionInputEdit_Event.setText("");
        imageURLEDIT_Event.setText("");
        startDateEdit_Event.setValue(null);
        endDateEdit_Event.setValue(null);
      }
      catch (NullPointerException error)
      {
        error.fillInStackTrace();
      }
    }
    if(e.getSource() == removeButton_Event)
    {
      try{

        Event oldEvent = eventComboBox.getSelectionModel().getSelectedItem();
        modelManager.removeEvent(oldEvent);
        reloadEventListAndDisplay();
        initialize();

        JOptionPane.showMessageDialog(null,"The event was successfully removed","Confirmation message",
            JOptionPane.INFORMATION_MESSAGE);

      }
      catch (RuntimeException h)
      {
        h.fillInStackTrace();
      }

    }
  }

  public void reloadEventListAndDisplay()
  {
    EventList eventList = modelManager.getAllEvents();
    String text = eventList.toString();
    eventsDisplayed.setText(text);
  }



  public void handlerGame (ActionEvent e)
  {
    if (e.getSource()== addSave_Game)
    {
      Game newGame=new Game(addTitle_Game.getText(),Integer.parseInt(
          addMaxNumOfPlayers_Game.getText()),
          addOwners_Game.getSelectionModel().getSelectedItem());
      modelManager.addGame(newGame);
      initialize();
      JOptionPane.showMessageDialog(null,"The game was added to the collection","Confirmation message",JOptionPane.INFORMATION_MESSAGE);
    }
    if (e.getSource()== editSave_Game)
    {
      Game oldGame= editGames_Game.getSelectionModel().getSelectedItem();
      modelManager.removeGame(oldGame);
      Game editedGame=new Game(editTitle_Game.getText(),Integer.parseInt(
          editMaxNumOfPlayers_Game.getText()),
          editOwners_Game.getSelectionModel().getSelectedItem());
      modelManager.addGame(editedGame);
      initialize();
      JOptionPane.showMessageDialog(null,"The game was successfully edited","Confirmation message",JOptionPane.INFORMATION_MESSAGE);
    }
    if (e.getSource()== removeSave_Game)
    {
      Game gameToRemove= removeGames_Game.getSelectionModel().getSelectedItem();
      modelManager.removeGame(gameToRemove);
      initialize();
      JOptionPane.showMessageDialog(null,"The game was successfully removed","Confirmation message",JOptionPane.INFORMATION_MESSAGE);
    }
  }




  public void initialize()
  {
    ArrayList<Player> players = modelManager.getAllPlayers().getList();
    ArrayList<Game> collection = modelManager.getAllGames().getList();
    ArrayList<Event> events = modelManager.getAllEvents().getList();

    eventData.clear();
    eventData.addAll(events);
    eventComboBox.setItems(eventData);

    playerData.clear();
    playerData.addAll(players);
    addOwners_Game.setItems(playerData);
    editOwners_Game.setItems(playerData);

    gameData.clear();
    gameData.addAll(collection);
    editGames_Game.setItems(gameData);
    removeGames_Game.setItems(gameData);

    ArrayList<Game> collection1 = modelManager.getAllGames().getList();
    for (int i = 0; i < collection1.size(); i++)
    {
      dataBorr_BorrowReserve.addAll(collection1.get(i));
    }
    gameBorr_BorrowReserve.setItems(dataBorr_BorrowReserve);

    ArrayList<Game> collection2 = modelManager.getAllGames().getList();
    for (int i = 0; i < collection2.size(); i++)
    {
      dataRes_BorrowReserve.addAll(collection2.get(i));
    }
    gameRes_BorrowReserve.setItems(dataBorr_BorrowReserve);

    name2.setEditable(true);
    updatePlayersArea();
    resetPlayer();
    reloadEventListAndDisplay();
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

  public void handlerBorrowReserve(ActionEvent e)
  {

    if(e.getSource() == borrow_BorrowReserve)
    {
      Player player = modelManager.getPlayerByStudentID(studentIdBorr_BorrowReserve.getText());
      Game gameSelect = gameBorr_BorrowReserve.getValue();

      int endDay = reserveToBorr_BorrowReserve.getValue().getDayOfMonth();
      int endMonth = reserveToBorr_BorrowReserve.getValue().getMonthValue();
      int endYear = reserveToBorr_BorrowReserve.getValue().getYear();
      int endHour = Integer.parseInt(hourBorr_BorrowReserve.getText());
      DateTime end = new DateTime(endYear,endMonth,endDay,endHour);

      modelManager.borrow(player,gameSelect,end);

    }

    if(e.getSource() == reserve_BorrowReserve)
    {
      Player player = modelManager.getPlayerByStudentID(studentIdRes_BorrowReserve.getText());
      Game gameSelect = gameRes_BorrowReserve.getValue();

      int startDay = fromRes_BorrowReserve.getValue().getDayOfMonth();
      int startMonth = fromRes_BorrowReserve.getValue().getMonthValue();
      int startYear = fromRes_BorrowReserve.getValue().getYear();
      int startHour = Integer.parseInt(startHour_BorrowReserve.getText());
      DateTime start = new DateTime(startDay,startMonth,startYear,startHour);


      int endDay = toRes_BorrowReserve.getValue().getDayOfMonth();
      int endMonth = toRes_BorrowReserve.getValue().getMonthValue();
      int endYear = toRes_BorrowReserve.getValue().getYear();
      int endHour = Integer.parseInt(endHour_BorrowReserve.getText());
      DateTime end = new DateTime(endDay,endMonth,endYear,endHour);

      modelManager.reserve(player,gameSelect,start,end);

    }


  }

  public void displayRefreshedReservationList()
  {
    String text="";
    ArrayList<Reservation> reservations = modelManager.getAllReservations().getList();
    for (int i = 0; i < reservations.size(); i++)
    {
      text+=reservations.get(i).toString()+"\n";
    }
    reservationList_BorrowReserve.setText(text);
  }



  public void addPlayer(ActionEvent e)
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

  public void handleActionsPlayer(ActionEvent e)
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
      if (temp!=null && choice==0)
      {
        modelManager.removePlayer(temp);
        name2.clear();
        updatePlayersBox();
        updatePlayersArea();
      }
    }
  }

}
