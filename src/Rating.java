import java.util.ArrayList;

/**
 * @author Agoston Babicz
 * @version 1.0
 * */

public class Rating
{
  private ArrayList<Integer> rating;

  public Rating()
  {
    rating=new ArrayList<Integer>();
  }

  public void addRate(int rate)
  {
    rating.add(rate);
  }

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
