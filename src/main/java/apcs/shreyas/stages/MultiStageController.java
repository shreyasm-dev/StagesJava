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

    this.updateList();
    this.updateDeltaV();
  }

  private void updateList() {
    this.stageList.getChildren().clear();
    List<Stage> stages = this.rocket.getStages();

    for (int i = 0; i < stages.size(); i++) {
      Stage stage = stages.get(i);
      VBox stageBox = new VBox();

      stageBox.setSpacing(10);
      stageBox.getChildren().add(new Label("Stage " + (i + 1)));

      Button removeButton = new Button("Remove");
      int x = i;
      removeButton.setOnAction(event -> {
        this.rocket.removeStage(x);
        this.updateList();
        this.updateDeltaV();
      });

      TextField specificImpulse = new TextField(String.valueOf(stage.getSpecificImpulse()));
      validator.createCheck().dependsOn("specificImpulse", specificImpulse.textProperty()).withMethod(c -> {
        try {
          double value = Double.parseDouble(c.get("specificImpulse"));
          if (value <= 0) {
            c.error("Must be greater than 0");
          }
        } catch (NumberFormatException e) {
          c.error("Must be a number");
        }
      }).decorates(specificImpulse).immediate();
      specificImpulse.textProperty().addListener((observable, oldValue, newValue) -> {
        stage.setSpecificImpulse(Double.parseDouble(newValue));
        this.updateDeltaV();
      });

      TextField propellantMass = new TextField(String.valueOf(stage.getPropellantMass()));
      validator.createCheck().dependsOn("propellantMass", propellantMass.textProperty()).withMethod(c -> {
        try {
          double value = Double.parseDouble(c.get("propellantMass"));
          if (value <= 0) {
            c.error("Must be greater than 0");
          }
        } catch (NumberFormatException e) {
          c.error("Must be a number");
        }
      }).decorates(propellantMass).immediate();
      propellantMass.textProperty().addListener((observable, oldValue, newValue) -> {
        stage.setPropellantMass(Double.parseDouble(newValue));
        this.updateDeltaV();
      });

      TextField structuralMass = new TextField(String.valueOf(stage.getStructuralMass()));
      validator.createCheck().dependsOn("structuralMass", structuralMass.textProperty()).withMethod(c -> {
        try {
          double value = Double.parseDouble(c.get("structuralMass"));
          if (value <= 0) {
            c.error("Must be greater than 0");
          }
        } catch (NumberFormatException e) {
          c.error("Must be a number");
        }
      }).decorates(structuralMass).immediate();
      structuralMass.textProperty().addListener((observable, oldValue, newValue) -> {
        stage.setStructuralMass(Double.parseDouble(newValue));
        this.updateDeltaV();
      });

      stageBox.getChildren().add(removeButton);
      stageBox.getChildren().add(specificImpulse);
      stageBox.getChildren().add(propellantMass);
      stageBox.getChildren().add(structuralMass);

      this.stageList.getChildren().add(stageBox);
    }
  }

  @FXML
  private void payloadMassChanged() {
    this.rocket.setPayloadMass(Double.parseDouble(this.payloadMass.getText()));
    this.updateDeltaV();
  }

  private void updateDeltaV() {
    this.deltaV.setText(String.valueOf(this.rocket.getDeltaV()));
  }
}
