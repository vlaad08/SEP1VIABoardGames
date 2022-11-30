import java.util.ArrayList;

/**
 * @author Agoston Babicz
 * @version 1.0
 * */

public class Rating
{
  private ArrayList<Integer> rating;


  /**
   * Constructor for the Rating class. It creates a new ArrayList
   * */
  public Rating()
  {
    rating=new ArrayList<Integer>();
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
    double average=(double)sum/rating.size();
    return average;
  }
}
