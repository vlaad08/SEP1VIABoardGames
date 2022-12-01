package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing Model.Game Collection object.
 * @author Emanoil Duca
 * @version 1.0
 * */
public class GameCollection implements Serializable
{
  private ArrayList<Game> games;

  /**
   * A constructor for GameCollection that create an empty ArrayList
   * */
  public GameCollection()
  {
    games = new ArrayList<>();
  }

  /**
   * Method that add a game to the Collection which has as parameters variables for the Game:
   * @param title The title of the Game
   * @param maxPlayers Maximum number of players
   * @param owner Thw owner of the game
   * */
  public void addGame(String title, int maxPlayers, Player owner)
  {
    games.add(new Game(title, maxPlayers, owner));
  }

  public void addGame(Game game)
  {
    games.add(game);
  }

<<<<<<< Updated upstream:src/Model/GameCollection.java


  // Method that remove a game from game list
=======
  /**
   * Method that remove a game from the Collection which has as parameters:
   * @param game The game object
   * */
>>>>>>> Stashed changes:src/GameCollection.java
  public void removeGame(Game game)
  {
    games.remove(game);
  }

  // Method that search for a game with specific title and return it
  public Game getGame(String title)
  {
    for(Game element: games)
    {
      if(element.getTitle().equals(title))
      {
        return element;
      }
    }
    return null;
  }

  public Game getGame(Game game)
  {
    for(Game element:games)
    {
      if(element.equals(game))
      {
        return element;
      }
    }
    return null;
  }

  // Method that return how many games has a specific Model.Player
  public int getPersonGames(Player player)
  {
    int i=0;
    for(Game element: games)
    {
      if(element.getOwner().equals(player))
      {
        i++;
      }
    }
    return i;
  }

  // Method that return how many games are in collection
  public int size()
  {
    return games.size();
  }

  // Method that return list of games
  public ArrayList<Game> getList()
  {
    return games;
  }

  public String toString()
  {
    String text="";
    for(Game element: games)
    {
      text+=element+"\n";
    }
    return text;
  }
}
