package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing PlayersList object.
 * @author Emanoil Duca
 * @version 1.0
 * */
public class PlayerList implements Serializable
{
  private ArrayList<Player> players;
  /**
   * A constructor with no variables as parameters
   * */
  public PlayerList()
  {
    players = new ArrayList<>(); //This takes 1 for the "=" and 1 for creating the ArrayList (This is a fast operation, which can be done in 1 step) = 2

    /*
    The Time Complexity of this method is:
    T(n) = 2 ---> T(n) = O(1)
    */
  }


  // A method that add a member in the array list
  public void addMember(String name, String studentID)
  {
    players.add(new Player(name,studentID)); //This takes 1 for the ".add()" and O(1) for the Player() constructor = O(1)
    players.get(players.size()-1).setMembership(true); //This takes 1 for the ".get()", 1 for the ".size()", 1 for the "-" and O(1) for the setMembership() = O(1)

    /*
    The time complexity of the addMember() method is:
    T(n) = O(1) + O(1) = O(1)
    */
  }

  // A method that add a guest in the array list
  public void addGuest(String name, String studentID)
  {
    players.add(new Player(name,studentID)); //This takes 1 for the ".add()" and O(1) for the Player() constructor = O(1)
    players.get(players.size()-1).setMembership(false); //This takes 1 for the ".get()", 1 for the ".size()",1 for the "-" and O(1) for the setMembership() = O(1)

    /*
    The time complexity of the addGuest() method is:
    T(n) = O(1) + O(1) = O(1)
    */
  }

  // Method that remove a player using his studentNumber
  public void removePlayer(Player player)
  {
    players.remove(player);
  }

  public ArrayList<Player> getList()
  {
    return players;
  }

  //This method return a list in order(first display members)
  public String toString()
  {
    String text="";
    ArrayList<Player> other = new ArrayList<>();

    for(Player element: players)
    {
      if(element.isMembership())
      {
        other.add(0,element);
      }
      else{
        other.add(other.size(),element);
      }
    }

    for(Player element: other)
    {
      text+=element+"\n";
    }

    return text;
  }
}