package apcs.shreyas.stages;

import apcs.shreyas.stages.models.MultiStage;
import apcs.shreyas.stages.models.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import net.synedra.validatorfx.Validator;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MultiStageController implements Initializable {
  @FXML
  private TextField payloadMass;

  @FXML
  private Label deltaV;

  @FXML
  private VBox stageList;

  private Validator validator;

  private MultiStage rocket;

  @FXML
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.validator = new Validator();
    this.rocket = new MultiStage(Double.parseDouble(this.payloadMass.getText()));
    this.rocket.addStage(new Stage(450, 50000, 5000));
    this.rocket.addStage(new Stage(450, 50000, 5000));

    this.validator.createCheck().dependsOn("payloadMass", this.payloadMass.textProperty()).withMethod(c -> {
      try {
        double value = Double.parseDouble(c.get("payloadMass"));
        if (value < 0) {
          c.error("Must be greater than or equal to 0");
        }
      } catch (NumberFormatException e) {
        c.error("Must be a number");
      }
    }).decorates(payloadMass).immediate();

    this.updateList();
    this.updateDeltaV();
  }

  private void updateList() {
    this.stageList.getChildren().clear();
    List<Stage> stages = this.rocket.getStages();

    for (int i = 0; i < stages.size(); i++) {
      int finalI = i;
      this.stageList.getChildren().add(Utility.stageToFXView(
        stages.get(i),
        i,
        validator,
        x -> {
          this.rocket.removeStage(finalI);
          this.updateList();
          this.updateDeltaV();
          return null;
        },
        x -> {
          this.updateDeltaV();
          return null;
        }
      ));
    }
  }

  @FXML
  private void payloadMassChanged() {
    this.rocket.setPayloadMass(Double.parseDouble(this.payloadMass.getText()));
    this.updateDeltaV();
  }

  private void updateDeltaV() {
    if (validator.validate()) {
      this.deltaV.setText(String.valueOf(this.rocket.getDeltaV()));
    }
  }
}
