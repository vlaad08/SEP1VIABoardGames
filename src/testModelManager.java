import Model.*;
import utils.MyFileHandler;

public class testModelManager
{
  public static void main(String[] args)
  {
    ModelManager modelManager = new ModelManager("gameCollection.bin","playerList.bin",
        "reservationList.bin","eventList.bin");

    /*
    PlayerList playerList = new PlayerList();
    playerList.addMember("Emanuel","5179");
    playerList.addGuest("Vlad","4869");
    playerList.addMember("Agoston","3579");
    playerList.addGuest("Levente","5189");

    modelManager.savePlayers(playerList);

    modelManager.addPlayer("Ivan","7777",true);
    */
    PlayerList other = modelManager.getAllPlayers();
    System.out.println(other);


    modelManager.rateAGame(modelManager.getGame("Chess"),6);

    GameCollection collection1 = modelManager.getAllGames();
    System.out.println(collection1);





  }
}
