import Model.ModelManager;
import Model.Player;
import Model.PlayerList;

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


    modelManager.removePlayer(modelManager.getPlayerByStudentID("5179"));
    modelManager.addPlayer("Ivan","7777",true);
    PlayerList other = modelManager.getAllPlayers();
    System.out.println(other);
  }
}
