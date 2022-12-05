package FXML;

import Model.DateTime;
import Model.Event;
import Model.EventList;
import Model.ModelManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EventController
{

  private ModelManager modelManager = new ModelManager("gameCollection.bin","playerList.bin",
      "reservationList.bin","eventList.bin");
  @FXML private TextField titleInput;
  @FXML private TextArea descriptionInput;
  @FXML private TextField imageURLInput;
  @FXML private DatePicker startDateInput;
  @FXML private DatePicker endDateInput;
  @FXML private Button saveButton;

  @FXML private TextArea eventsDisplayed;

  public void saveEvent(ActionEvent e)
  {
    String title = titleInput.getText();
    String description = descriptionInput.getText();
    String imageURL = imageURLInput.getText();
    String startDateAsString = startDateInput.getValue().toString();
    String endDateAsString = endDateInput.getValue().toString();
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
  }

  public void reloadEventListAndDisplay()
  {
    EventList eventList = modelManager.getAllEvents();
    String text = eventList.toString();
    eventsDisplayed.setText(text);
  }


}
