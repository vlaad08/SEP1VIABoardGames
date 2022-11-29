import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class containing Date and Time objects.
 * @author Levi Toth
 * @version 1.0
 * */
public class DateTime
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

  public boolean isLeapYear()
  {
    if (this.year % 400 == 0)
    {
      return true;
    }
    else if (this.year % 4 == 0 && this.year % 100 != 0)
    {
      return true;
    }

    return false;
  }

  public int daysInMonth()
  {
    if (month == 1)
    {
      return 31;
    }
    else if (month == 2 && isLeapYear() == true)
    {
      return 29;
    }
    else if (month == 2 && isLeapYear() == false)
    {
      return 28;
    }
    else if (month == 3)
    {
      return 31;
    }
    else if (month == 4)
    {
      return 30;
    }
    else if (month == 5)
    {
      return 31;
    }
    else if (month == 6)
    {
      return 30;
    }
    else if (month == 7)
    {
      return 31;
    }
    else if (month == 8)
    {
      return 31;
    }
    else if (month == 9)
    {
      return 30;
    }
    else if (month == 10)
    {
      return 31;
    }
    else if (month == 11)
    {
      return 30;
    }
    else if (month == 12)
    {
      return 31;
    }
    else
      return -1;
  }

  public String getMonthName()
  {
    switch (month)
    {
      case 1:
        return "January";
      case 2:
        return "February";
      case 3:
        return "March";
      case 4:
        return "April";
      case 5:
        return "May";
      case 6:
        return "June";
      case 7:
        return "July";
      case 8:
        return "August";
      case 9:
        return "September";
      case 10:
        return "Oktober";
      case 11:
        return "November";
      case 12:
        return "December";
      default:
        return "Non existent month, please provide value between 1-12!";

    }
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
    if( this.year > date2.getYear() || this.year == date2.getYear() && this.month > date2.getMonth() || this.year == date2.getYear() && this.month == date2.getMonth() && this.day > date2.getDay())
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public String toString()
  {
    return this.year +" / " +this.month +" / " +this.day +" hour: " +this.hour;
  }


}
