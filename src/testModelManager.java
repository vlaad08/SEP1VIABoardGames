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

    /*
    GameCollection collection1 = modelManager.getAllGames();
    System.out.println(collection1);
    */



    EventList eventList = new EventList();
    eventList.addEvent("New Year Party","Everyone can join",new DateTime(2022,12,25,18),new DateTime(2022,12,26,5),"event1.jpg");
    eventList.addEvent("Weekly Event","For everyone",new DateTime(2022,11,3,18),new DateTime(2022,11,3,23),"event1.jpg");
    modelManager.saveEvents(eventList);

    //modelManager.addEvent("Drinking Party","Only for Members",new DateTime(2022,11,11,18),new DateTime(2022,11,12,6),"event1.jpg");

    //modelManager.removeEvent(modelManager.getEvent("New Year Party"));

    System.out.println("Now: ");
    EventList copyEvents1 = modelManager.getAllEvents();
    System.out.println(copyEvents1);




  }
}
