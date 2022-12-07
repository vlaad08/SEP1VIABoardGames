import Model.*;
import utils.MyFileHandler;

import java.util.ArrayList;

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
    PlayerList asd = modelManager.getAllPlayers();
    System.out.println(asd);

    GameCollection gameCollection = new GameCollection();
    gameCollection.addGame("Chess",2,modelManager.getPlayerByName("Ivan"));
    gameCollection.addGame("Catan",6,modelManager.getPlayerByName("Ivan"));
    gameCollection.addGame("Partners",4,modelManager.getPlayerByName("Emanuel"));
    gameCollection.addGame("UNO",10,modelManager.getPlayerByName("Vlad"));
    modelManager.saveCollection(gameCollection);
    GameCollection copyCollection = modelManager.getAllGames();
    System.out.println(copyCollection);


    ReservationList reservationList = new ReservationList();
    reservationList.addReservation(modelManager.getGame("Chess"),modelManager.getPlayerByName("Emanuel"),DateTime.today(),new DateTime(2022,12,8));
    reservationList.addReservation(modelManager.getGame("Chess"),modelManager.getPlayerByName("Ivan"),DateTime.today(),new DateTime(2022,12,8));
    reservationList.addReservation(modelManager.getGame("Chess"),modelManager.getPlayerByName("Agoston"),DateTime.today(),new DateTime(2022,12,8));
    reservationList.addReservation(modelManager.getGame("UNO"),modelManager.getPlayerByName("Ivan"),new DateTime(2022,12,3),new DateTime(2022,12,5,16));
    reservationList.addReservation(modelManager.getGame("UNO"),modelManager.getPlayerByName("Emanuel"),new DateTime(2022,12,3),new DateTime(2022,12,5,16));
    reservationList.addReservation(modelManager.getGame("UNO"),modelManager.getPlayerByName("Levente"),new DateTime(2022,12,3),new DateTime(2022,12,5,16));
    modelManager.saveReservations(reservationList);

    modelManager.editGame("Chess","newChess",2,4,modelManager.getGame("Chess").getOwner());

    //modelManager.editGame("UNO"," NewUNO",12,12,modelManager.getPlayerByStudentID("1111"));

    ReservationList copyReservation = modelManager.getAllReservations();
    System.out.println(copyReservation);

    GameCollection g = modelManager.getAllGames();
    System.out.println(g);

     */

    EventList eventList = new EventList();
    Event event1 = new Event("Event1","des",new DateTime(2022,12,16),new DateTime(2022,12,18),"");
    eventList.addEvent("Event2","des",new DateTime(2022,12,16),new DateTime(2022,12,18),"");
    eventList.addEvent("Event3","des",new DateTime(2022,12,16),new DateTime(2022,12,18),"");
    eventList.removeEvent(event1);

    modelManager.saveEvents(eventList);
    modelManager.removeEvent(modelManager.getEvent("Event2"));

    EventList e = modelManager.getAllEvents();
    System.out.println(e);


    /*
    String text="";
    for(Reservation element: copyReservation.getByGame(modelManager.getGame("UNO")))
    {
      text+=element+"\n";
    }
    System.out.println(text);
    */

  }
}
