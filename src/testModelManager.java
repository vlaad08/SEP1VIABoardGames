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

    PlayerList playerList = modelManager.getAllPlayers();
    System.out.println(playerList);

    GameCollection gameCollection = modelManager.getAllGames();
    System.out.println(gameCollection);


    ReservationList reservationList = new ReservationList();
    reservationList.addReservation(modelManager.getGame("Chess"),modelManager.getPlayerByName("Ivan"),DateTime.today(),new DateTime(2022,12,4));
    reservationList.addReservation(modelManager.getGame("Chess"),modelManager.getPlayerByName("Ivan"),new DateTime(2022,12,3),new DateTime(2022,12,5));
    modelManager.saveReservations(reservationList);

    modelManager.reserve(modelManager.getPlayerByName("Vlad"),modelManager.getGame("Catan"),DateTime.today(),new DateTime(2022,12,5));
    modelManager.borrow(modelManager.getPlayerByStudentID("5179"),modelManager.getGame("Chess"),new DateTime(2022,12,7,12));

    ReservationList copyReservation = modelManager.getAllReservations();
    System.out.println(copyReservation);

    ArrayList<Game> availableGame = modelManager.displayAvailableGames();
    System.out.println(availableGame);




  }
}
