package Model;

import java.io.Serializable;

/**
 * A class for making Event objects and manage them.
 * @author Group 6
 * @version 1.0
 * */
public class Event implements Serializable
{
  private String title;
  private String description;
  private String image;
  private DateTime startDate;
  private DateTime endDate;

  /**
   * Constructor for creating an Event object.
   * @param title title of the event
   * @param description description of the event
   * @param startDate start date of the event
   * @param endDate end date of the event
   * @param image image of the event
   */
  public Event(String title, String description, DateTime startDate, DateTime endDate, String image)
  {
    this.title = title;
    this.description = description;
    this.image = image;
    this.startDate = startDate.copy();
    this.endDate = endDate.copy();
  }

  /**
   * Accessor method to get the title of the event
   * @return The title of the event
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * Set the title of the event
   * @param title The title of the event
   * */
  public void setTitle(String title)
  {
    this.title = title;
  }

  /**
   * Accessor method to get the description of the event
   * @return The description of the event
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * Set the title of the event
   * @param description The description of the event
   * */
  public void setDescription(String description)
  {
    this.description = description;
  }

  /**
   * Get the source of the image
   * @return the source of image
   * */
  public String getImage()
  {
    return image;
  }

  /**
   * Set the source of image
   * @param image the source of image
   */
  public void setImage(String image)
  {
    this.image = image;
  }

  /**
   * Get the start date time of the Event
   * @return start date time of the Event
   */
  public DateTime getStartDate()
  {
    return startDate;
  }

  /**
   * Set the start date time of the Event
   * @param startDate start date time of the event
   */
  public void setStartDate(DateTime startDate)
  {
    this.startDate = startDate.copy();
  }

  /**
   * Get the end date time of the Event
   * @return end date time of the Event
   */
  public DateTime getEndDate()
  {
    return endDate;
  }

  /**
   * Set the end date time of the Event
   * @param endDate end date time of the event
   */
  public void setEndDate(DateTime endDate)
  {
    this.endDate = endDate.copy();
  }

  /**
   * Display the information of an Event as a String
   * @return Event information as a String
   */
  public String toString()
  {
    return "Event: "+title+" |Description: "+description
        +" |Date: "+startDate+" - "+endDate;
  }
}
