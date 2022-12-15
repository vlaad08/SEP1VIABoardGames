package FXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationGUI extends Application
{
  public void start(Stage window) throws IOException
  {
    window.setTitle("VIA Board Games");
    window.getIcons().add(new Image("VIALogo.png"));
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("ApplicationGUI.fxml"));
    Scene scene= new Scene(loader.load());
    window.setResizable(false);
    window.setScene(scene);
    window.show();
  }

}
