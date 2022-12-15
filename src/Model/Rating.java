package Model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Class for rating games
 * @author Group 6
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
   * Calculates the average of all the ratings in the ArrayList
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

  /**
   * Displays rating
   * @return Returns empty string if there are no ratings to the game it's called on or
   *            returns the average of the ratings of the game rounded to two decimal points
   */
  public String toString()
  {
    if(getAverageRating()>=0)
    {
      DecimalFormat df = new DecimalFormat();
      df.setMaximumFractionDigits(2);
      return df.format(getAverageRating());
    }
    else return "";
  }
}
