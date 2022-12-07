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
  @FXML private TextField titleInput_Event;
  @FXML private TextArea descriptionInput_Event;
  @FXML private TextField imageURLInput_Event;
  @FXML private DatePicker startDateInput_Event;
  @FXML private DatePicker endDateInput_Event;
  @FXML private Button saveButton_Event;

  @FXML private TextArea eventsDisplayed;

  public void saveEvent(ActionEvent e)
  {
    if(e.getSource() == saveButton_Event)
    {
      String title = titleInput_Event.getText();
      String description = descriptionInput_Event.getText();
      String imageURL = imageURLInput_Event.getText();
      int startYear = startDateInput_Event.getValue().getYear(), startMonth = startDateInput_Event.getValue().getMonthValue(), startDay = startDateInput_Event.getValue().getDayOfMonth();
      int endYear = endDateInput_Event.getValue().getYear(), endMonth = endDateInput_Event.getValue().getMonthValue(), endDay = endDateInput_Event.getValue().getDayOfMonth();
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
