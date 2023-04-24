package apcs.shreyas.stages;

import apcs.shreyas.stages.controllers.components.ValidatedDoubleField;
import apcs.shreyas.stages.models.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import net.synedra.validatorfx.Validator;

import java.util.function.Function;

public class Utility {
  /* public static VBox labeledTextField(String label) {
    VBox box = new VBox();
    box.setSpacing(5);
    box.getChildren().add(new Label(label));
    box.getChildren().add(new TextField());

    return box;
  }

  public static VBox labeledTextField(String label, TextField field) {
    VBox box = new VBox();
    box.setSpacing(5);
    box.getChildren().add(new Label(label));
    box.getChildren().add(field);

    return box;
  } */

  public static VBox stageToFXView(Stage stage, int i, Validator validator, Function<Void, Void> removeCallback, Function<Void, Void> updateCallback) {
    VBox stageBox = new VBox();

    stageBox.setSpacing(10);

    Label stageLabel = new Label("Stage " + (i + 1));
    stageLabel.setStyle("-fx-font-size: 16px");

    // Create a small icon to help distinguish stages easily
    // https://stackoverflow.com/questions/1961146/memory-address-of-variables-in-java
    Rectangle icon = new Rectangle(4, 16);
    icon.setStyle("-fx-fill: #" + Integer.toHexString(stage.hashCode()).substring(0, 6));
    stageLabel.setGraphic(icon);

    Button removeButton = new Button("Remove");
    removeButton.setOnAction(e -> removeCallback.apply(null));

    ValidatedDoubleField specificImpulse = new ValidatedDoubleField(
      "Specific impulse (s)",
      String.valueOf(stage.getSpecificImpulse()),
      validator
    );
    specificImpulse.textProperty().addListener((observable, oldValue, newValue) -> {
      stage.setSpecificImpulse(Double.parseDouble(newValue));
      updateCallback.apply(null);
    });

    ValidatedDoubleField propellantMass = new ValidatedDoubleField(
      "Propellant mass (kg)",
      String.valueOf(stage.getPropellantMass()),
      validator
    );
    propellantMass.textProperty().addListener((observable, oldValue, newValue) -> {
      stage.setPropellantMass(Double.parseDouble(newValue));
      updateCallback.apply(null);
    });

    ValidatedDoubleField structuralMass = new ValidatedDoubleField(
      "Structural mass (kg)",
      String.valueOf(stage.getStructuralMass()),
      validator
    );
    structuralMass.textProperty().addListener((observable, oldValue, newValue) -> {
      stage.setStructuralMass(Double.parseDouble(newValue));
      updateCallback.apply(null);
    });

    stageBox.getChildren().add(stageLabel);
    stageBox.getChildren().add(removeButton);
    stageBox.getChildren().add(specificImpulse);
    stageBox.getChildren().add(propellantMass);
    stageBox.getChildren().add(structuralMass);

    return stageBox;
  }
}
