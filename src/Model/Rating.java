package Model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author Agoston Babicz
 * @version 1.0
 * */

public class Rating implements Serializable
{
  private ArrayList<Integer> rating;


  /**
   * Constructor for the Model.Rating class. It creates a new ArrayList
   * */
  public Rating()
  {
    rating = new ArrayList<>();
  }

  /**
   * Adds one rating to the ArrayList
   * @param rate The rating
   * */
  public void addRate(int rate)
  {
    rating.add(rate);
  }

  /**
   * Calculates the average of all the rating in the ArrayList
   * @return The average rating
   * */
  public double getAverageRating()
  {
    int sum=0;
    for (int i = 0; i < rating.size(); i++)
    {
      sum+=rating.get(i);
    }
    double average=(double)sum/(rating.size());

    return average;
  }

  public String toString()
  {
    if(getAverageRating()>=0)
    {
      DecimalFormat df = new DecimalFormat();
      df.setMaximumFractionDigits(2);
      return df.format(getAverageRating());
      //return String.valueOf(getAverageRating());
    }
    else return "";

  }
}
