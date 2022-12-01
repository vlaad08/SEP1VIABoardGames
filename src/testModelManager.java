import Model.*;
import utils.MyFileHandler;

public class testModelManager
{
  public static void main(String[] args)
  {
    ModelManager modelManager = new ModelManager("gameCollection.bin","playerList.bin",
        "reservationList.bin","eventList.bin");

    PlayerList playerList = new PlayerList();
    playerList.addMember("Emanuel","5179");
    playerList.addGuest("Vlad","4869");
    playerList.addMember("Agoston","3579");
    playerList.addGuest("Levente","5189");

    modelManager.savePlayers(playerList);

    modelManager.addPlayer("Ivan","7777",true);
    PlayerList other = modelManager.getAllPlayers();
    System.out.println(other);


    GameCollection gameCollection = new GameCollection();
    gameCollection.addGame("Chess",2,modelManager.getPlayerByName("Ivan"));
    gameCollection.addGame("Catan",6,modelManager.getPlayerByName("Ivan"));
    modelManager.saveCollection(gameCollection);

    /*
    GameCollection games2 = modelManager.getAllGames();
    Game game1 = games2.getGame("Chess");
    game1.setOwner(modelManager.getPlayerByName("Agoston"));
    modelManager.saveCollection(games2);
    */
    GameCollection copyGames = modelManager.getAllGames();
    System.out.println(copyGames);


  }
}
