import java.util.ArrayList;

public class PlayerList
{
  private ArrayList<Player> players;

  public PlayerList()
  {
    players = new ArrayList<>();
  }

  public void addMember(String studentID, String name)
  {
    players.add(new Player(studentID,name));
  }



}
