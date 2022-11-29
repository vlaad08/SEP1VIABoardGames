public class Player1
{
<<<<<<< HEAD
  private String studentID;
  private String name;
=======
  private String studentID,name;
>>>>>>> 7a896b937198a3f34386f57ef34a93d799d018ef
  private boolean membership;

  public Player(String studentID, String name)
  {
    this.studentID = studentID;
    this.name = name;
  }

<<<<<<< HEAD
  public String getStudentID()
  {
    return studentID;
  }
=======
>>>>>>> 7a896b937198a3f34386f57ef34a93d799d018ef
  public String getName()
  {
    return name;
  }
<<<<<<< HEAD
  public boolean isMembership()
  {
    return membership;
  }
  public void setStudentID(String studentID)
  {
    this.studentID = studentID;
  }
=======

>>>>>>> 7a896b937198a3f34386f57ef34a93d799d018ef
  public void setName(String name)
  {
    this.name = name;
  }
<<<<<<< HEAD
=======

  public String getStudentID()
  {
    return studentID;
  }

>>>>>>> 7a896b937198a3f34386f57ef34a93d799d018ef
  public void setMembership(boolean membership)
  {
    this.membership = membership;
  }
<<<<<<< HEAD

  public boolean equals(Object obj)
  {
    if (obj==null||obj.getClass()!=getClass())
    {
      return false;
    }
    Player other=(Player) obj;
    return other.studentID.equals(studentID)&&other.name.equals(name)&&other.membership==membership;
=======
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
>>>>>>> 7a896b937198a3f34386f57ef34a93d799d018ef
  }
}
