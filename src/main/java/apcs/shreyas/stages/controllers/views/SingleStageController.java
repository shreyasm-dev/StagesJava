package apcs.shreyas.stages.controllers.views;

import apcs.shreyas.stages.Providers;
import apcs.shreyas.stages.controllers.components.ValidatedDoubleField;
import apcs.shreyas.stages.models.SingleStage;
import apcs.shreyas.stages.models.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.synedra.validatorfx.Validator;

import java.net.URL;
import java.util.ResourceBundle;

public class SingleStageController implements Initializable {
  @FXML
  private VBox fieldRoot;

  private ValidatedDoubleField specificImpulse;

  private ValidatedDoubleField propellantMass;

  private ValidatedDoubleField structuralMass;

  private ValidatedDoubleField payloadMass;

  @FXML
  private Label deltaV;

  private Validator validator;

  private SingleStage rocket;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.validator = new Validator();

    this.specificImpulse = new ValidatedDoubleField("Specific impulse (s)", "450.0", this.validator, Providers.SPECIFIC_IMPULSE);
    this.propellantMass = new ValidatedDoubleField("Propellant mass (kg)", "100000.0", this.validator, null);
    this.structuralMass = new ValidatedDoubleField("Structural mass (kg)", "10000.0", this.validator, Providers.STRUCTURAL_MASS);
    this.payloadMass = new ValidatedDoubleField("Payload mass (kg)", "5000.0", this.validator, Providers.PAYLOAD_MASS, 0, true);

    this.specificImpulse.setEventHandler(e -> this.valueChanged());
    this.propellantMass.setEventHandler(e -> this.valueChanged());
    this.structuralMass.setEventHandler(e -> this.valueChanged());
    this.payloadMass.setEventHandler(e -> this.valueChanged());

    this.fieldRoot.getChildren().addAll(
      this.specificImpulse,
      this.propellantMass,
      this.structuralMass,
      this.payloadMass
    );

    this.rocket = new SingleStage(
      new Stage(
        Double.parseDouble(this.specificImpulse.getText()),
        Double.parseDouble(this.propellantMass.getText()),
        Double.parseDouble(this.structuralMass.getText())
      ),
      Double.parseDouble(this.payloadMass.getText())
    );

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
