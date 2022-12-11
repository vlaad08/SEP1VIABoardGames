import Model.Game;
import Model.GameCollection;
import Model.Player;

public class testGame
{
  public static void main(String[] args)
  {
    Game game1 = new Game("Chess",2,new Player("Ivan","5168"), "img");
    game1.addRating(5);
    game1.addRating(9);
    game1.addRating(9);

    GameCollection gameCollection = new GameCollection();
    gameCollection.addGame(game1);

    System.out.println(gameCollection);
  }
}
