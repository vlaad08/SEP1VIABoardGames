package Model;

import java.io.Serializable;

/**
 * @author Group 6
 * @version 1.0
 * */

public class Player implements Serializable
{
  private String name;
  private String studentID;
  private boolean membership;

  /**
   * The Constructor for the Model.Player class
   * */
  public Player(String name, String studentID)
  {
    this.name = name; //This takes 1 for the "=" = O(1)
    this.studentID = studentID; //This takes 1 for the "=" = O(1)

    /*
    The Player class's constructor's time complexity is:
    T(n) = O(1) + O(1) = O(1)
    */
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
    this.membership = membership; //This takes 1 for the "=" = O(1)

    /*
    The time complexity of the setMembership mutator method is:
    T(n) = O(1)
    */
  }

  /**
   * Method to compare 2 Model.Player objects
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

  public String toString()
  {
    if(membership==true)
    {
      return "Member: "+getName()+", ID: "+getStudentID();
    }
    else
    {
      return "Guest: "+getName()+", ID: "+getStudentID();
    }
  }
}
