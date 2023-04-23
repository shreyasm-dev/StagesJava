package apcs.shreyas.stages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Other than JavaFX and core Java, this project uses the following libraries:
// - ValidatorFX
// - FormsFX

// TODO: Actually use FormsFX

public class Application extends javafx.application.Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
    stage.setTitle("Stages");
    stage.setScene(scene);

    // Make the title bar look normal on macOS instead of slightly lighter
    stage.getScene().setFill(null);

    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
