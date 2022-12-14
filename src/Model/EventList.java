package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing Date and Time objects.
 * @author Levi Toth
 * @version 1.0
 * */
public class EventList implements Serializable
{
  private ArrayList<Event> events;

  /**
   * No-argument constructor
   * */
  public EventList()
  {
    events = new ArrayList<>();
  }

  /**
   * @param title the title of the event
   * @param description the description of the event
   * @param image the image displayed on the website next to the event
   * @param startDate the start date of the event
   * @param endDate the end date of the event
   * */
  public void addEvent(String title, String description, DateTime startDate, DateTime endDate, String image)
  {
    Event temp = new Event(title,description,startDate,endDate,image);
    events.add(temp);
  }

  /**
   * @param event the event we wan to remove
   * */
  public void removeEvent(Event event)
  {
    events.remove(event);
  }

  /**
   * toString of Class
   * */
  public String toString()
   {
     String text="";
     for(Event element:events)
     {
       text+=element+"\n";
     }
     return text;
   }

   public Event getEvent(String title)
   {
     for(Event element: events)
     {
       if(element.getTitle().equals(title))
       {
         return element;
       }
     }
     return null;
   }

   public ArrayList<Event> getList()
   {
     return events;
   }

}


