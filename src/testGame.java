import Model.Game;
import Model.GameCollection;
import Model.Player;

public class testGame
{
  public static void main(String[] args)
  {
    Game game1 = new Game("Chess",2,new Player("Ivan","5168"));
    game1.addRating(5);

    GameCollection gameCollection = new GameCollection();
    gameCollection.addGame(game1.getTitle(),game1.getMaxPlayers(),game1.getOwner());

    System.out.println(gameCollection);
  }
}
