package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Game objects.
 * @author Group 6
 * @version 1.0
 * */
public class GameCollection implements Serializable
{
  private ArrayList<Game> games;

  /**
   * No-argument constructor initializing the GameCollection.
   * */
  public GameCollection()
  {
    games = new ArrayList<>();
  }

  /**
   * Add game to the game list.
   * @param game game to be added
   */
  public void addGame(Game game)
  {
    games.add(game);
  }

  /**
   * Remove game from the game list.
   * @param game the game that will be removed
   */
  public void removeGame(Game game)
  {
    games.remove(game);
  }

  // Method that search for a game with specific title and return it

  /**
   * Return a game from the game list that has a specific title.
   * @param title title of the Game
   * @return Game object that was found
   */
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

  /**
   * Get ArrayList of games from the GameCollection object
   * @return ArrayList of games
   */
  public ArrayList<Game> getList()
  {
    return games;
  }

  /**
   * Display the information of an GameCollection as a String
   * @return GameCollection information as a String
   */
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
