package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing Event objects.
 * @author Group 6
 * @version 1.0
 * */
public class EventList implements Serializable
{
  private ArrayList<Event> events;

  /**
   * No-argument constructor initializing the EventList.
   * */
  public EventList()
  {
    events = new ArrayList<>();
  }

  /**
   * Add Event to the event list
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
   * Remove event object from the event list
   * @param event the event that will be removed
   * */
  public void removeEvent(Event event)
  {
    events.remove(event);
  }

  /**
   * Display the information of an Eventlist as a String
   * @return Eventlist information as a String
   */
  public String toString()
   {
     String text="";
     for(Event element:events)
     {
       text+=element+"\n";
     }
     return text;
   }

  /**
   * Get an event with a specific title from the event list
   * @param title the title of the event
   * @return Event that was found.
   */
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

  /**
   * Get ArrayList of events from the Event list object
   * @return ArrayList of events
   */
   public ArrayList<Event> getList()
   {
     return events;
   }

}


