package apcs.shreyas.stages;

import apcs.shreyas.stages.models.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MultiStageController implements Initializable {
  @FXML
  private ListView stageList;

  @FXML
  private Label deltaV;

  private List<Stage> stages;

  @FXML
  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }
}
