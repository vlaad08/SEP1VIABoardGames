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
  private String fileName;

  /**
   * A constructor with no variables as parameters
   * */
  public PlayerList()
  {
    players = new ArrayList<>();
  }

  // A method that add a member in the array list
  public void addMember(String name, String studentID)
  {
    players.add(new Player(name,studentID));
    players.get(players.size()-1).setMembership(true);
  }

  // A method that add a guest in the array list
  public void addGuest(String name, String studentID)
  {
    players.add(new Player(name,studentID));
    players.get(players.size()-1).setMembership(false);
  }

  // Method that remove a player using his studentNumber
  public void removePlayer(String studentID)
  {
    for(Player element: players)
    {
      if(element.getStudentID().equals(studentID))
      {
        players.remove(element);
      }
    }
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
