package FXML;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class GameController
{
  ModelManager manager=new ModelManager("gameCollection.bin","playerList.bin",
      "reservationList.bin","eventList.bin");
  private ObservableList<Player>playerData= FXCollections.observableArrayList();
  private ObservableList<Game>gameData= FXCollections.observableArrayList();
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
  @FXML private Tab gameList_Game;

  public void handler (ActionEvent e)
  {
    if (e.getSource()== addSave_Game)
    {
      Game newGame=new Game(addTitle_Game.getText(),Integer.parseInt(
          addMaxNumOfPlayers_Game.getText()),
          addOwners_Game.getSelectionModel().getSelectedItem());
      manager.addGame(newGame);
      initialize();
//      JOptionPane.showMessageDialog(null,"The game was added to the collection","Confirmation message",JOptionPane.INFORMATION_MESSAGE);
    }
    if (e.getSource()== editSave_Game)
    {
      Game oldGame= editGames_Game.getSelectionModel().getSelectedItem();
      manager.removeGame(oldGame);
      Game editedGame=new Game(editTitle_Game.getText(),Integer.parseInt(
          editMaxNumOfPlayers_Game.getText()),
          editOwners_Game.getSelectionModel().getSelectedItem());
      manager.addGame(editedGame);
      initialize();
    }
    if (e.getSource()== removeSave_Game)
    {
      Game gameToRemove= removeGames_Game.getSelectionModel().getSelectedItem();
      manager.removeGame(gameToRemove);
      initialize();
    }
  }

  public void initialize()
  {
    ArrayList<Player> players=manager.getAllPlayers().getList();
    ArrayList<Game> collection=manager.getAllGames().getList();

    playerData.clear();
    playerData.addAll(players);
    addOwners_Game.setItems(playerData);
    editOwners_Game.setItems(playerData);

    gameData.clear();
    gameData.addAll(collection);
    editGames_Game.setItems(gameData);
    removeGames_Game.setItems(gameData);
  }
  public void displayRefreshedGameList()
  {
    String text="";
    ArrayList<Game> collection=manager.getAllGames().getList();
    for (int i = 0; i < collection.size(); i++)
    {
      text+=collection.get(i).toString()+"\n";
    }
    displayGames_Game.setText(text);
  }





}
