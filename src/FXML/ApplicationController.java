package FXML;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.util.ArrayList;

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
  @FXML private ComboBox<Reservation> reservationBox_BorrowReserve;
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
  @FXML private Button removeRes_BorrowReserve;

  public void initialize()
  {
    updateGameBox();
    updateGameArea();

    updatePlayersArea();
    resetPlayer();

    updateEventBox();
    updateEventArea();

    updateReservationArea();
    updateReservationBox();
  }

  public void updateGameBox()
  {
    editGames_Game.getItems().clear();
    removeGames_Game.getItems().clear();
    gameBorr_BorrowReserve.getItems().clear();
    gameRes_BorrowReserve.getItems().clear();

    GameCollection gameCollection = modelManager.getAllGames();
    ArrayList<Game> games = gameCollection.getList();
    for(Game element: games)
    {
      editGames_Game.getItems().add(element);
      removeGames_Game.getItems().add(element);
      gameBorr_BorrowReserve.getItems().add(element);
      gameRes_BorrowReserve.getItems().add(element);
    }
  }
  public void updateGameArea()
  {
    GameCollection gameCollection = modelManager.getAllGames();
    displayGames_Game.setText(gameCollection.toString());
  }

  public void handlerGame (ActionEvent e)
  {
    if (e.getSource() == addSave_Game)
    {
      String title = addTitle_Game.getText();
      String MaxNumberOfPlayers = addMaxNumOfPlayers_Game.getText();

      Game newGame = new Game(title,Integer.parseInt(MaxNumberOfPlayers),
          addOwners_Game.getSelectionModel().getSelectedItem());

      modelManager.addGame(newGame);
      JOptionPane.showMessageDialog(null,"The game was added to the collection","Confirmation message",JOptionPane.INFORMATION_MESSAGE);
      addTitle_Game.clear();
      addMaxNumOfPlayers_Game.clear();

      updateGameBox();
      updateGameArea();
    }
    if (e.getSource() == editSave_Game)
    {
      Game selectedGame = editGames_Game.getSelectionModel().getSelectedItem();

      if(selectedGame != null)
      {
        modelManager.editGame(selectedGame.getTitle(),editTitle_Game.getText(),
            selectedGame.getMaxPlayers(),Integer.parseInt(editMaxNumOfPlayers_Game.getText())
            ,selectedGame.getOwner());
        JOptionPane.showMessageDialog(null,"The game was successfully edited","Confirmation message",JOptionPane.INFORMATION_MESSAGE);
      }

      editTitle_Game.setText("");
      editMaxNumOfPlayers_Game.setText("");

      updateGameBox();
      updateGameArea();
      updateReservationArea();
      updateReservationBox();
    }
    if (e.getSource()== removeSave_Game)
    {
      Game gameToRemove= removeGames_Game.getSelectionModel().getSelectedItem();

      if(gameToRemove!=null)
      {
        modelManager.removeGame(gameToRemove);
        JOptionPane.showMessageDialog(null,"The game was successfully removed","Confirmation message",JOptionPane.INFORMATION_MESSAGE);
      }
      updateGameArea();
      updateGameBox();

    }
    if(e.getSource() == editGames_Game)
    {
      Game game = editGames_Game.getSelectionModel().getSelectedItem();
      if(game!=null)
      {
        editTitle_Game.setText(game.getTitle());
        editMaxNumOfPlayers_Game.setText(String.valueOf(game.getMaxPlayers()));
      }
    }
  }

  private void updateEventBox()
  {
    int currentIndex = eventComboBox.getSelectionModel().getSelectedIndex();
    eventComboBox.getItems().clear();

    EventList eventList = modelManager.getAllEvents();
    ArrayList<Event> events = eventList.getList();
    for (Event element: events)
    {
      eventComboBox.getItems().add(element);
    }

    if (currentIndex == -1 && eventComboBox.getItems().size() > 0)
    {
      eventComboBox.getSelectionModel().select(0);
    }
    else
    {
      eventComboBox.getSelectionModel().select(currentIndex);
    }
  }
  public void handleEvent(ActionEvent e)
  {
    if(e.getSource() == saveButton_Event)
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

        updateEventBox();
        updateEventArea();
    }
    else if(e.getSource() == saveEditButton_Event)
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

        updateEventBox();
        updateEventArea();

        titleInputEdit_Event.setText("");
        descriptionInputEdit_Event.setText("");
        imageURLEDIT_Event.setText("");
        startDateEdit_Event.setValue(null);
        endDateEdit_Event.setValue(null);
    }
    else if(e.getSource() == removeButton_Event)
    {
      Event oldEvent = eventComboBox.getSelectionModel().getSelectedItem();


      int choice = JOptionPane.showConfirmDialog(null,"Are you sure?");
      if (oldEvent!=null && choice==0)
      {
        modelManager.removeEvent(oldEvent);

        titleInput_Event.clear();
        titleInputEdit_Event.clear();
        descriptionInputEdit_Event.clear();
        imageURLEDIT_Event.clear();
        startDateEdit_Event.setValue(null);
        endDateEdit_Event.setValue(null);

        updatePlayersBox();
        updatePlayersArea();
      }

      JOptionPane.showMessageDialog(null,"The event was successfully removed","Confirmation message",
            JOptionPane.INFORMATION_MESSAGE);

      updateEventBox();
      updateEventArea();


    }
    else if(e.getSource() == eventComboBox)
    {
      Event other = eventComboBox.getSelectionModel().getSelectedItem();

      if(other != null)
      {
        titleInputEdit_Event.setText(other.getTitle());
        descriptionInputEdit_Event.setText(other.getDescription());
        imageURLEDIT_Event.setText(other.getImage());
      }
    }
  }

  public void updateEventArea()
  {
    EventList eventList = modelManager.getAllEvents();
    eventsDisplayed.setText(eventList.toString());
  }
  public void updateReservationBox()
  {
    int currentIndex = reservationBox_BorrowReserve.getSelectionModel().getSelectedIndex();
    reservationBox_BorrowReserve.getItems().clear();

    ReservationList reservationList = modelManager.getAllReservations();
    ArrayList<Reservation> reservations = reservationList.getList();
    for(Reservation element: reservations)
    {
      reservationBox_BorrowReserve.getItems().add(element);
    }
    if (currentIndex == -1 && reservationBox_BorrowReserve.getItems().size() > 0)
    {
      playerBox.getSelectionModel().select(0);
    }
    else
    {
      playerBox.getSelectionModel().select(currentIndex);
    }
  }
  public void handlerBorrowReserve(ActionEvent e)
  {
    if(e.getSource() == borrow_BorrowReserve)
    {
      Player player = modelManager.getPlayerByStudentID(studentIdBorr_BorrowReserve.getText());
      Game gameSelect = gameBorr_BorrowReserve.getSelectionModel().getSelectedItem();

      int endDay = reserveToBorr_BorrowReserve.getValue().getDayOfMonth();
      int endMonth = reserveToBorr_BorrowReserve.getValue().getMonthValue();
      int endYear = reserveToBorr_BorrowReserve.getValue().getYear();
      int endHour = Integer.parseInt(hourBorr_BorrowReserve.getText());
      DateTime end = new DateTime(endYear,endMonth,endDay,endHour);

      modelManager.borrow(player,gameSelect,end);
      JOptionPane.showMessageDialog(null,"The borrow was created.","Confirmation message",
          JOptionPane.INFORMATION_MESSAGE);

      studentIdBorr_BorrowReserve.setText("");
      reserveToBorr_BorrowReserve.setValue(null);
      hourBorr_BorrowReserve.setText("");

      updateReservationArea();
      updateReservationBox();
    }
    else if(e.getSource() == reserve_BorrowReserve)
    {
      Player player = modelManager.getPlayerByStudentID(studentIdRes_BorrowReserve.getText());
      Game gameSelect = gameRes_BorrowReserve.getSelectionModel().getSelectedItem();

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
      JOptionPane.showMessageDialog(null,"The reservation was created.","Confirmation message",
          JOptionPane.INFORMATION_MESSAGE);

      studentIdRes_BorrowReserve.setText("");
      fromRes_BorrowReserve.setValue(null);
      startHour_BorrowReserve.setText("");
      toRes_BorrowReserve.setValue(null);
      endHour_BorrowReserve.setText("");

      updateReservationArea();
      updateReservationBox();
    }
    else if(e.getSource() == removeRes_BorrowReserve)
    {
      Reservation reservation = reservationBox_BorrowReserve.getSelectionModel().getSelectedItem();

      int choice = JOptionPane.showConfirmDialog(null,"Are you sure?");
      if(reservation != null && choice == 0)
      {
        int i = reservationBox_BorrowReserve.getSelectionModel().getSelectedIndex();
        modelManager.removeReservationByIndex(i);
        //modelManager.removeReservation(reservation);
      }

      updateReservationBox();
      updateReservationArea();
    }

  }

  public void updateReservationArea()
  {
    ReservationList reservationList = modelManager.getAllReservations();
    reservationList_BorrowReserve.setText(reservationList.toString());
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
    addOwners_Game.getItems().clear();

    PlayerList players = modelManager.getAllPlayers();
    ArrayList<Player> playerArrayList = players.getList();
    for (Player element: playerArrayList)
    {
      playerBox.getItems().add(element);
      addOwners_Game.getItems().add(element);
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
