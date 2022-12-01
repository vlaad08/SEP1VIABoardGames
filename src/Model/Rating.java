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
  private ArrayList<Integer> rating = new ArrayList<>();


  /**
   * Constructor for the Model.Rating class. It creates a new ArrayList
   * */
  public Rating()
  {}

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
    if(rating.equals(null))
      return 0;
    int sum=0;
    for (int i = 0; i < rating.size(); i++)
    {
      sum+=rating.get(i);
    }
    double average=(double)sum/(rating.size()-1);

    return average;
  }

  public String toString()
  {
    if(getAverageRating()>=0)
    {
      DecimalFormat format = new DecimalFormat("0.00");
      return format.format(getAverageRating());
    }
    else return "0";

  }
}
