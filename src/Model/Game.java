package Model;

import java.io.Serializable;

/**
 * A class for the Model.Game object
 * @author Agoston Babicz
 * @version 1.0
 * */

public class Game implements Serializable
{
  private String title;
  private int maxPlayers;
  private boolean reserved;
  private Player owner;
  private Player currentOwner;
  private Rating rating;

  /**
   * Constructor for the Model.Game class
   * @param title The title of the game
   * @param maxPlayers The maximum number of players that can play the game at the same time
   * @param owner The owner of the game
   * */
  public Game(String title, int maxPlayers, Player owner)
  {
    this.title = title;
    this.maxPlayers = maxPlayers;
    this.owner = owner;
    rating = new Rating();
    rating.addRate(0);
  }
  /**
   * Accessor method to get the title of the game
   * @return The title of the game
   * */
  public String getTitle()
  {
    return title;
  }
  /**
   * Mutator method for the title of the game
   * @param title The new title of the game
   * */
  public void setTitle(String title)
  {
    this.title = title;
  }
  /**
   * Accessor method to get the maximum number of players of the game
   * @return The maximum number of games
   * */
  public int getMaxPlayers()
  {
    return maxPlayers;
  }
  /**
   * Mutator method for the maximum number of players of the game
   * @param maxPlayers The new amount of players
   * */
  public void setMaxPlayers(int maxPlayers)
  {
    this.maxPlayers = maxPlayers;
  }
  /**
   * Accessor method to get whether the game is reserved or not
   * @return whether the game is reserved or not
   * */
  public boolean isReserved()
  {
    return reserved;
  }
  /**
   * Mutator method to set the game's availability
   * @param reserved The new availability of the game
   * */
  public void setReserved(boolean reserved)
  {
    this.reserved = reserved;
  }
  /**
   * Accessor method to get the owner of the game
   * @return The owner of the game
   * */
  public Player getOwner()
  {
    return owner;
  }
  /**
   * Mutator method to change the owner of the game
   * @param owner The new owner of the game
   * */
  public void setOwner(Player owner)
  {
    this.owner = owner;
  }
  /**
   * Accessor method to get the current owner of the game
   * @return The current owner of the game
   * */
  public Player getCurrentOwner()
  {
    return currentOwner;
  }
  /**
   * Mutator method to change the owner of the game
   * @param currentOwner The new owner after borrowing the game
   * */
  public void setCurrentOwner(Player currentOwner)
  {
    this.currentOwner = currentOwner;
  }

  /**
   * This method will calculate the average of the rating ArrayList, which will indicate the overall rating of the game
   * @return The overall rating of the game
   * */
  public double getAverageRating()
  {
    return this.rating.getAverageRating();
  }

  /**
   * This method will add a rating to the game's rating list.
   * */
  public void addRating(int rating)
  {
    this.rating.addRate(rating);
  }

  /**
   * Equals method to compare 2 Model.Game objects.
   * @return Whether the two Model.Game objects are identical or not.
   * */
  public boolean equals(Object obj)
  {
    if (obj==null||obj.getClass()!=getClass())
    {
      return false;
    }
    Game other=(Game)obj;
    return other.title.equals(title) && other.maxPlayers==maxPlayers &&other.reserved==reserved
        &&other.owner.equals(owner);
  }

  public void isReturned()
  {
    setReserved(false);
  }

  public String toString()
  {
    return "Game: "+title+" maxPlayers: "+maxPlayers+" owner: "+owner.getName()+" Rating: "+ rating;
  }
}
