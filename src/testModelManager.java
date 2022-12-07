import Model.*;
import utils.MyFileHandler;

import java.util.ArrayList;

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

    PlayerList asd = modelManager.getAllPlayers();
    System.out.println(asd);

    GameCollection gameCollection = new GameCollection();
    gameCollection.addGame("Chess",2,modelManager.getPlayerByName("Ivan"));
    gameCollection.addGame("Catan",6,modelManager.getPlayerByName("Ivan"));
    gameCollection.addGame("Partners",4,modelManager.getPlayerByName("Emanuel"));
    gameCollection.addGame("UNO",10,modelManager.getPlayerByName("Vlad"));

    GameCollection copyCollection = modelManager.getAllGames();
    System.out.println(copyCollection);


    ReservationList reservationList = new ReservationList();
    reservationList.addReservation(modelManager.getGame("Chess"),modelManager.getPlayerByName("Ivan"),DateTime.today(),new DateTime(2022,12,4));
    reservationList.addReservation(modelManager.getGame("UNO"),modelManager.getPlayerByName("Ivan"),new DateTime(2022,12,3),new DateTime(2022,12,5,16));
    modelManager.saveReservations(reservationList);

    ReservationList copyReservation = modelManager.getAllReservations();
    System.out.println(copyReservation);

    ArrayList<Game> game = modelManager.displayAvailableGames();
    System.out.println(game);
    EventList eventList = modelManager.getAllEvents();
    System.out.println(eventList);
  }
}
