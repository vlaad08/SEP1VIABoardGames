/**
 * @author Agoston Babicz
 * @version 1.0
 * */

public class Player
{
  private String name;
  private String studentID;
  private boolean membership;

  /**
   * The Constructor for the Player class
   * */
  public Player(String name, String studentID)
  {
    this.name = name;
    this.studentID = studentID;
  }

  /**
   * Accessor method to get the name of the current player
   * @return The name of the player
   * */
  public String getName()
  {
    return name;
  }
  /**
   * Mutator method to change the name of the current player
   * @param name The new name of the player
   * */
  public void setName(String name)
  {
    this.name = name;
  }
  /**
   * Accessor method for the current player's studentID
   * @return The player's studentID
   * */
  public String getStudentID()
  {
    return studentID;
  }
  /**
   * Accessor method to get whether the current player is a member or not
   * @return Whether the player pays membership or not
   * */
  public boolean isMembership()
  {
    return membership;
  }
  /**
   * Mutator method to change the player's status based on the payment of the membership
   * @param membership The new state of the player
   * */
  public void setMembership(boolean membership)
  {
    this.membership = membership;
  }

  /**
   * Method to compare 2 Player objects
   * @return Whether the Players are identical or not
   * */
  public boolean equals(Object obj)
  {
    if (obj==null||obj.getClass()!=getClass())
    {
      return false;
    }
    Player other=(Player) obj;
    return other.name.equals(name)&&other.studentID.equals(studentID)&&other.membership==membership;
  }
}
