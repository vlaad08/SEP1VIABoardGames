public class Player
{
  private String name;
  private String studentID;
  private boolean membership;

  public Player(String name, String studentID)
  {
    this.name = name;
    this.studentID = studentID;
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
  public void setStudentID(String studentID)
  {
    this.studentID = studentID;
  }
  public boolean isMembership()
  {
    return membership;
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
    return other.name.equals(name)&&other.studentID.equals(studentID)&&other.membership==membership;
  }
}
