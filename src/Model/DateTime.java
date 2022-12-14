package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class containing Date and Time objects.
 * @author Levi Toth
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
   * */
  public DateTime (int year, int month, int day)
  {
    this.year = year;
    this.month = month;
    this.day = day;
    this.hour = 10; //reservations end at a reasonable 10am
  }

  public int getYear()
  {
    return year;
  }

  public int getMonth()
  {
    return month;
  }

  public int getDay()
  {
    return day;
  }

  public int getHour()
  {
    return hour;
  }

  public DateTime copy()
  {
    return new DateTime(year,month,day,hour);
  }

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

  //We use "today" for the borrows start date
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

  public String toString()
  {
    return this.year +"/" +this.month +"/" +this.day +" hour:" +this.hour;
  }
}
