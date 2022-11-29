public class Player
{
  private String studentID;
  private String name;
  private boolean membership;

  public Player(String studentID, String name)
  {
    this.studentID = studentID;
    this.name = name;
  }

  public String getStudentID()
  {
    return studentID;
  }
  public String getName()
  {
    return name;
  }
  public boolean isMembership()
  {
    return membership;
  }
  public void setStudentID(String studentID)
  {
    this.studentID = studentID;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public void setMembership(boolean membership)
  {
    this.membership = membership;
  }

  public boolean equals(Object obj)
  {
    if (obj==null||obj.getClass()!=getClass())
    {
      return false;
    }
    Player other=(Player) obj;
    return other.studentID.equals(studentID)&&other.name.equals(name)&&other.membership==membership;
  }
}
