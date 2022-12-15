package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class containing Date and Time objects.
 * @author Group 6
 * @version 1.0
 * */
public class DateTime implements Serializable
{
  private int year;
  private int month;
  private int day;
  private int hour;

  /**
   * Constructor which has as parameters variables for the date and hour.
   * @param year The year of the date
   * @param month The month of the date
   * @param day The day of the date
   * @param hour The hour of the date
   * */
  public DateTime (int year, int month, int day, int hour)
  {
    this.year = year;
    this.month = month;
    this.day = day;
    this.hour = hour;
  }

  /**
   * Constructor which has as parameters variables only for the date.
   *  @param year The year of the date
   *  @param month The month of the date
   *  @param day The day of the date
   * */
  public DateTime (int year, int month, int day)
  {
    this.year = year;
    this.month = month;
    this.day = day;
    this.hour = 10; //reservations end at a reasonable 10am
  }

  /**
   * Return the year as integer.
   * @return year
   * */
  public int getYear()
  {
    return year;
  }
  /**
   * Return the month as integer.
   * @return month
   * */
  public int getMonth()
  {
    return month;
  }
  /**
   * Return the day as integer.
   * @return day
   * */
  public int getDay()
  {
    return day;
  }
  /**
   * Return the day as integer.
   * @return hour
   * */
  public int getHour()
  {
    return hour;
  }

  /**
   * Return a copy of an DateTime object.
   * @return a copy DateTime object
   * */
  public DateTime copy()
  {
    return new DateTime(year,month,day,hour);
  }

  /**
   * Compare 2 objects and check if they are equals.
   * @return true if objects are equals or false if they are not
   * @param obj
   * */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    DateTime other = (DateTime)obj;

    return this.hour  == other.hour &&
           this.day   == other.day &&
           this.month == other.month &&
           this.year  == other.year;
  }

  /**
   * Return a DateTime object with current year, month, day and hour. This is used for borrowing
   * @return DateTime object with current year, month, day and hour.
   * */
  public static DateTime today()
  {
    LocalDate currentDate = LocalDate.now();
    LocalTime localTime = LocalTime.now();

    int currentDay = currentDate.getDayOfMonth();
    int currentMonth = currentDate.getMonthValue();
    int currentYear = currentDate.getYear();
    int currentHour = localTime.getHour();

    return new DateTime(currentYear,currentMonth,currentDay,currentHour);
  }

  /**
   * Compare 2 Datetime object and check if initial date is before the date that is compared with.
   * @return true if initial date is before the date that is compared with
   * @param date2
   * */
  public boolean isBefore(DateTime date2)
  {
    if (this.year<date2.getYear())
    {
      return true;
    }else if (this.year==date2.getYear()&&this.month<date2.getMonth())
    {
      return true;
    }else if (this.year==date2.getYear()&&this.month==date2.getMonth()&&this.day<date2.getDay())
    {
      return true;
    }else if (this.year==date2.getYear()&&this.month==date2.getMonth()&&this.day==date2.getDay()&&this.hour<=date2.getHour())
    {
      return true;
    }else
    {
      return false;
    }
  }

  /**
   * Display the information of an object as a String
   * @return objects information as a String
   */
  public String toString()
  {
    return this.year +"/" +this.month +"/" +this.day +" hour:" +this.hour;
  }
}
