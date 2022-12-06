package Model;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class GameController
{
  ModelManager manager=new ModelManager("gameCollection.bin","playerList.bin",
      "reservationList.bin","eventList.bin");
  private ObservableList<Player>playerData= FXCollections.observableArrayList();
  private ObservableList<Game>gameData= FXCollections.observableArrayList();
  // Game - Add Game
  @FXML private ComboBox<Player> addOwners;
  @FXML private TextField addTitle;
  @FXML private TextField addMaxNumOfPlayers;
  @FXML private Button addSave;
  // Game - Edit Game
  @FXML private ComboBox<Player> editOwners;
  @FXML private ComboBox<Game> editGames;
  @FXML private TextField editTitle;
  @FXML private TextField editMaxNumOfPlayers;
  @FXML private Button editSave;
  //Game - Remove Game
  @FXML private ComboBox<Player> removeOwners;
  @FXML private ComboBox<Game> removeGames;
  @FXML private Button removeSave;
  public void handler (ActionEvent e)
  {
    if (e.getSource()==addSave)
    {
      Game newGame=new Game(addTitle.getText(),Integer.parseInt(addMaxNumOfPlayers.getText()),addOwners.getSelectionModel().getSelectedItem());
      System.out.println(newGame);
      manager.addGame(newGame);
      initialize();
//      JOptionPane.showMessageDialog(null,"The game was added to the collection","Confirmation message",JOptionPane.INFORMATION_MESSAGE);
    }
    if (e.getSource()==editSave)
    {
      Game oldGame=editGames.getSelectionModel().getSelectedItem();
      manager.removeGame(oldGame);
      Game editedGame=new Game(editTitle.getText(),Integer.parseInt(editMaxNumOfPlayers.getText()),oldGame.getOwner());
      manager.addGame(editedGame);
      System.out.println(editedGame);
      initialize();
    }
    if (e.getSource()==removeSave)
    {
      Game gameToRemove=removeGames.getSelectionModel().getSelectedItem();
      manager.removeGame(gameToRemove);
    }
  }

  public void initialize()
  {
    ArrayList<Player> players=manager.getAllPlayers().getList();
    ArrayList<Game> collection=manager.getAllGames().getList();

    playerData.clear();
    playerData.addAll(players);
    addOwners.setItems(playerData);
    editOwners.setItems(playerData);
    removeOwners.setItems(playerData);

    gameData.clear();
    gameData.addAll(collection);
    editGames.setItems(gameData);
    removeGames.setItems(gameData);
  }




}
