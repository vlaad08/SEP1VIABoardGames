package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyFileHandler
{
  // Writes the given string to a file with the given file name
  public static void writeToTextFile(String fileName, String str) throws FileNotFoundException
  {
    writeText(fileName, str, false);
  }

  // Appends the given string to a file with the given file name
  public static void appendToTextFile(String fileName, String str) throws FileNotFoundException
  {
    writeText(fileName, str, true);
  }

  // writeToTextFile and appendToTextFile are almost identical - only the boolean in the constructor
  // of the FileOutputStream differs. So I made this private method that both methods call
  private static void writeText(String fileName, String str, boolean append) throws FileNotFoundException
  {
    PrintWriter writeToFile = null;

    try
    {
      FileOutputStream fileOutStream = new FileOutputStream(fileName, append);
      writeToFile = new PrintWriter(fileOutStream);
      writeToFile.println(str);
    }
    finally
    {
      if (writeToFile != null)
      {
        writeToFile.close();
      }
    }
  }

  // Writes the strings in the given array to a file with the given file name
  public static void writeArrayToTextFile(String fileName, String[] strs) throws FileNotFoundException
  {
    writeText(fileName, strs, false);
  }

  // Appends the strings in the given array to a file with the given file name
  public static void appendArrayToTextFile(String fileName, String[] strs) throws FileNotFoundException
  {
    writeText(fileName, strs, true);
  }

  // Again, the writeArrayToTextFile and appendArrayToTextFile methods are almost identical.
  // So I made this private method that both methods call
  private static void writeText(String fileName, String[] strs, boolean append) throws FileNotFoundException
  {
    PrintWriter writeToFile = null;

    try
    {
      FileOutputStream fileOutStream = new FileOutputStream(fileName, append);
      writeToFile = new PrintWriter(fileOutStream);

      for (int i = 0; i < strs.length; i++)
      {
        writeToFile.println(strs[i]);
      }
    }
    finally
    {
      if (writeToFile != null)
      {
        writeToFile.close();
      }
    }
  }

  // Reads the first line from the file with the given file name and returns it as a String
  public String readFromTextFile(String fileName) throws FileNotFoundException
  {
    Scanner readFromFile = null;
    String str = "";

    try
    {
      FileInputStream fileInStream = new FileInputStream(fileName);
      readFromFile = new Scanner(fileInStream);
      str = readFromFile.nextLine();
    }
    finally
    {
      if (readFromFile != null)
      {
        readFromFile.close();
      }
    }
    return str;
  }

  // Reads all lines from the file with the given file name and returns it as a String[]
  public static String[] readArrayFromTextFile(String fileName) throws FileNotFoundException
  {
    Scanner readFromFile = null;
    ArrayList<String> strs = new ArrayList<String>();

    try
    {
      FileInputStream fileInStream = new FileInputStream(fileName);
      readFromFile = new Scanner(fileInStream);

      while (readFromFile.hasNext())
      {
        strs.add(readFromFile.nextLine());
      }
    }
    finally
    {
      if (readFromFile != null)
      {
        readFromFile.close();
      }
    }

    String[] strsArray = new String[strs.size()];
    return strs.toArray(strsArray);
  }


  // Writes the given object to a file with the given file name
  public static void writeToBinaryFile(String fileName, Object obj) throws FileNotFoundException, IOException
  {
    ObjectOutputStream writeToFile = null; //This takes 1 for the "=" = O(1)

    try
    {
      FileOutputStream fileOutStream = new FileOutputStream(fileName); // This takes 1 for the "=" and 1 for calling the FileOutputStream() constructor
                                                                        // (This is a fast operation, which can be done in 1 step) = O(1)
      writeToFile = new ObjectOutputStream(fileOutStream); //This takes 1 for the "=" = O(1)

      writeToFile.writeObject(obj); //This takes 1 for the "=" and O(n) for the ".writeObject()" = O(n)
    }
    finally
    {
      if (writeToFile != null) //This takes 1 for the "!=" check = O(1)
      {
        try
        {
          writeToFile.close(); //This takes 1 for the ".close()" method (This is a fast operation, which can be done in 1 step) = O(1)
        }
        catch (IOException e)
        {
          System.out.println("IO Error closing file " + fileName); //This takes 1 for the "System.out.println()" and 1 for the "+" = O(1)
        }
      }
    }

    // The worst case is when all the "try"-s happen and we get to the "finally" section's "try" part.
    // In this case the time complexity of this method is:
    // T(n) = O(1) + O(1) + O(1) + O(n) + O(1) + O(1) + O(1) ===> Ignoring all the coefficients and constants (O(1)), we get
    // T(n) = O(n)
  }

  // Writes the objects in the given array to a file with the given file name
  public static void writeArrayToBinaryFile(String fileName, Object[] objs) throws FileNotFoundException, IOException
  {
    ObjectOutputStream writeToFile = null;

    try
    {
      FileOutputStream fileOutStream = new FileOutputStream(fileName);
      writeToFile = new ObjectOutputStream(fileOutStream);

      for (int i = 0; i < objs.length; i++)
      {
        writeToFile.writeObject(objs[i]);
      }
    }
    finally
    {
      if (writeToFile != null)
      {
        try
        {
          writeToFile.close();
        }
        catch (IOException e)
        {
          System.out.println("IO Error closing file " + fileName);
        }
      }
    }
  }

  // Reads the first object from the file with the given file name and returns it.
  // Whoever calls the method will need to cast it from type Object to its actual type
  public static Object readFromBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
  {
    Object obj = null; // This takes 1 for "=" = O(1)
    ObjectInputStream readFromFile = null; //This takes 1 for "=" = O(1)
    try
    {
      FileInputStream fileInStream = new FileInputStream(fileName); // This takes 1 for the "=" and 1 for calling the FileInputStream() constructor
                                                                    // (This is a fast operation, which can be done in 1 step) = 2 = O(1)
      readFromFile = new ObjectInputStream(fileInStream); // This takes 1 for the "=" and 1 for calling the ObjectInputStream() constructor
                                                          // (This is a fast operation, which can be done in 1 step) = 2 = O(1)
      try
      {
        obj = readFromFile.readObject(); // This takes 1 for the "=" and O(n) for the ".readObject()" = O(n)
      }
      catch (EOFException eof)
      {
        //Done reading
      }
    }
    finally
    {
      if (readFromFile != null) //This takes 1 for the check ("!=") = O(1)
      {
        try
        {
          readFromFile.close(); //This takes 1 for the ".close()" method (This is a fast operation, which can be done in 1 step) = O(1)
        }
        catch (IOException e)
        {
          System.out.println("IO Error closing file " + fileName); //This takes 1 for "System.out.println" and 1 for the "+" = 2 = O(1)
        }
      }
    }
    return obj; //This takes 1 = O(1)

    /*
    The worst case is when all the "try"-s happen and we get to the "finally" section's "try" part.
    In this case the time complexity of this method is:
    T(n) = O(1) + O(1) + O(1) + O(1) + O(n) + O(1) + O(1) + O(1) + O(1) ===> Ignoring all the coefficients and constants (O(1)), we get
    T(n) = O(n)
    */
  }

  // Reads all objects from the file with the given file name and returns it as an Object[].
  // Whoever calls the method will need to cast the Objects to their actual type
  public static Object[] readArrayFromBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
  {
    ArrayList<Object> objs = new ArrayList<Object>();

    ObjectInputStream readFromFile = null;
    try
    {
      FileInputStream fileInStream = new FileInputStream(fileName);
      readFromFile = new ObjectInputStream(fileInStream);
      while (true)
      {
        try
        {
          objs.add(readFromFile.readObject());
        }
        catch (EOFException eof)
        {
          //Done reading
          break;
        }
      }
    }
    finally
    {
      if (readFromFile != null)
      {
        try
        {
          readFromFile.close();
        }
        catch (IOException e)
        {
          System.out.println("IO Error closing file " + fileName);
        }
      }
    }

    return objs.toArray();
  }
}
