public class Player
{
  private String studentID,name;
  private boolean membership;

  public Player(String studentID, String name)
  {
    this.studentID = studentID;
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getStudentID()
  {
    return studentID;
  }

  public void setMembership(boolean membership)
  {
    this.membership = membership;
  }
  public boolean getMembership()
  {
    return membership;
  }

  public boolean equals(Object obj)
  {
    if(obj==null || getClass()!=obj.getClass())
    {
      return false;
    }

    Player other = (Player) obj;

    return name.equals(other.name)&&studentID.equals(other.studentID)
        &&membership== other.membership;
  }
}
