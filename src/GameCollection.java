import java.util.ArrayList;

public class GameCollection
{
  private ArrayList<Game> games;

  // Constructor with no argument
  public GameCollection()
  {
    games = new ArrayList<>();
  }

  // Method that add a game to the game list
  public void addGame(String title, int maxPlayers, Player owner)
  {
    games.add(new Game(title,maxPlayers,owner));
  }

  // Method that remove a game from game list
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
  }

  // Method that return how many games has a specific Player
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
  public ArrayList<Game> getGames()
  {
    return games;
  }
}
