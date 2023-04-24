package apcs.shreyas.stages.controllers.views;

import apcs.shreyas.stages.models.SingleStage;
import apcs.shreyas.stages.models.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.synedra.validatorfx.Validator;

import java.net.URL;
import java.util.ResourceBundle;

public class SingleStageController implements Initializable {
  @FXML
  private TextField specificImpulse;

  @FXML
  private TextField propellantMass;

  @FXML
  private TextField structuralMass;

  @FXML
  private TextField payloadMass;

  @FXML
  private Label deltaV;

  private Validator validator;

  private SingleStage rocket;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.validator = new Validator();
    this.rocket = new SingleStage(
      new Stage(
        Double.parseDouble(this.specificImpulse.getText()),
        Double.parseDouble(this.propellantMass.getText()),
        Double.parseDouble(this.structuralMass.getText())
      ),
      Double.parseDouble(this.payloadMass.getText())
    );

    this.validator.createCheck().dependsOn("specificImpulse", this.specificImpulse.textProperty()).withMethod(c -> {
      try {
        double value = Double.parseDouble(c.get("specificImpulse"));
        if (value <= 0) {
          c.error("Must be greater than 0");
        }
      } catch (NumberFormatException e) {
        c.error("Must be a number");
      }
    }).decorates(specificImpulse).immediate();

    this.validator.createCheck().dependsOn("propellantMass", this.propellantMass.textProperty()).withMethod(c -> {
      try {
        double value = Double.parseDouble(c.get("propellantMass"));
        if (value <= 0) {
          c.error("Must be greater than 0");
        }
      } catch (NumberFormatException e) {
        c.error("Must be a number");
      }
    }).decorates(propellantMass).immediate();

    this.validator.createCheck().dependsOn("structuralMass", this.structuralMass.textProperty()).withMethod(c -> {
      try {
        double value = Double.parseDouble(c.get("structuralMass"));
        if (value <= 0) {
          c.error("Must be greater than 0");
        }
      } catch (NumberFormatException e) {
        c.error("Must be a number");
      }
    }).decorates(structuralMass).immediate();

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

    this.valueChanged();
  }

  @FXML
  private void valueChanged() {
    if (this.validator.validate()) {
      this.rocket.getStage().setSpecificImpulse(Double.parseDouble(this.specificImpulse.getText()));
      this.rocket.getStage().setPropellantMass(Double.parseDouble(this.propellantMass.getText()));
      this.rocket.getStage().setStructuralMass(Double.parseDouble(this.structuralMass.getText()));
      this.rocket.setPayloadMass(Double.parseDouble(this.payloadMass.getText()));

      this.deltaV.setText(String.valueOf(this.rocket.getDeltaV()));
    }
  }
}
