package FXML;

import Model.DateTime;
import Model.EventList;
import Model.ModelManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;

public class EventController
{

  private ModelManager modelManager = new ModelManager("gameCollection.bin","playerList.bin",
      "reservationList.bin","eventList.bin");
  @FXML private TextField titleEventInput;
  @FXML private TextArea descriptionEventInput;
  @FXML private TextField imageURLEventInput;
  @FXML private DatePicker startDateEventInput;
  @FXML private DatePicker endDateEventInput;
  @FXML private Button saveEventButton;

  @FXML private TextArea eventsDisplayed;

  public void saveEvent(ActionEvent e)
  {
    if(e.getSource() == saveEventButton)
    {
      String title = titleEventInput.getText();
      String description = descriptionEventInput.getText();
      String imageURL = imageURLEventInput.getText();
      String startDateAsString = startDateEventInput.getValue().toString();
      String endDateAsString = endDateEventInput.getValue().toString();
      int startYear = 0, startMonth = 0, startDay = 0, endYear = 0, endMonth = 0, endDay = 0;
      int countDash = 0;


      for(int i = 0; i < startDateAsString.length(); i++)
      {
        if(startDateAsString.charAt(i) == '-')
        {
          countDash++;
        }
        else
        {
          int a = Integer.parseInt(Character.toString(startDateAsString.charAt(i)));
          if(countDash == 0)
          {
            startYear = startYear * 10 + a;
          }
          else if(countDash == 1)
          {
            startMonth = startMonth * 10 + a;
          }
          else
          {
            startDay = startDay * 10 + a;
          }
        }
      }

      countDash = 0;

      for(int i = 0; i < endDateAsString.length(); i++)
      {
        if(endDateAsString.charAt(i) == '-')
        {
          countDash++;
        }
        else
        {
          int a = Integer.parseInt(Character.toString(endDateAsString.charAt(i)));
          if(countDash == 0)
          {
            endYear = endYear * 10 + a;
          }
          else if(countDash == 1)
          {
            endMonth = endMonth * 10 + a;
          }
          else
          {
            endDay = endDay * 10 + a;
          }
        }
      }


      modelManager.addEvent(title, description, imageURL, new DateTime(startYear, startMonth, startDay), new DateTime(endYear, endMonth, endDay));
      JOptionPane.showMessageDialog(null,"The event was created","Confirmation message",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void reloadEventListAndDisplay()
  {
    EventList eventList = modelManager.getAllEvents();
    String text = eventList.toString();
    eventsDisplayed.setText(text);
  }


}
