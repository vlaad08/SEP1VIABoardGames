import java.util.ArrayList;

public class EventList
{
  private ArrayList<Event> events;

  public EventList()
  {
    events =  new ArrayList<Event>();
  }

  /**
   * @param title the title of the event
   * */
  public void addEvent(String title, String description, DateTime startDate, DateTime endDate, String image)
  {
    Event temp = new Event(title,description,image,startDate,endDate);
    events.add(temp);
  }

  public void removeEvent(Event event)
  {
    events.remove(event);
  }

  public ArrayList<Event> getAllFutureEvents()
  {
    return events;
  }

  public String toString()
   {
     return events.toString();
   }



}


