import java.util.ArrayList;

/**
 * A class containing PlayersList object.
 * @author Emanoil Duca
 * @version 1.0
 * */
public class PlayerList
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
  public void addMember(String studentID, String name)
  {
    players.add(new Player(studentID,name));
    players.get(players.size()-1).setMembership(true);
  }

  // A method that add a guest in the array list
  public void addGuest(String studentID, String name)
  {
    players.add(new Player(studentID,name));
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

}
