package Model;

import java.io.Serializable;

/**
 * A class for the Game object
 * @author Group 6
 * @version 1.0
 * */

public class Game implements Serializable
{
  private String title;
  private int maxPlayers;
  private Player owner;
  private Rating rating;
  private String image;

  /**
   * Constructor for the Game class
   * @param title The title of the game
   * @param maxPlayers The maximum number of players that can play the game at the same time
   * @param owner The owner of the game
   * */
  public Game(String title, int maxPlayers, Player owner, String image)
  {
    this.title = title;
    this.maxPlayers = maxPlayers;
    this.owner = owner;
    this.image = image;
    rating = new Rating();
  }

  //this Constructor is used for making a copy of the Game
  private Game(String title, int maxPlayers, Player owner, String image, Rating rating)
  {
    this.title = title;
    this.maxPlayers = maxPlayers;
    this.owner = owner;
    this.image = image;
    this.rating = rating;
  }

  /**
   * Get the image of the game
   * @return the source of the image of the game
   */
  public String getImage()
  {
    return image;
  }

  /**
   * Set the image of the game
   * @param image source for the image of the game
   */
  public void setImage(String image)
  {
    this.image = image;
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
   * Accessor method to get the owner of the game
   * @return The owner of the game
   * */
  public Player getOwner()
  {
    return owner;
  }

  /**
   * Set new owner of the Game
   * @param owner new owner of the game
   */
  public void setOwner(Player owner)
  {
    this.owner = owner;
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
   * Equals method to compare 2 Game objects.
   * @return Whether the two Game objects are identical or not.
   * */
  public boolean equals(Object obj)
  {
    if (obj==null||obj.getClass()!=getClass())
    {
      return false;
    }
    Game other=(Game)obj;
    return other.title.equals(title) && other.maxPlayers==maxPlayers;
  }

  /**
   * Make a copy of a game
   * @return return a copy of the Game
   */
  public Game copy()
  {
    return new Game(title, maxPlayers, owner, image, rating);
  }

  /**
   * Display the information of a Game as a String
   * @return Game information as a String
   */
  public String toString()
  {
    return "Title: "+title+",  Maximum Number of Players: "+maxPlayers+",  Owner: "+ owner + ",  Rating: "+ rating.toString();
  }
}
