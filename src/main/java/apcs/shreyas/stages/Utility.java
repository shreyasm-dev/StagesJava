package apcs.shreyas.stages;

import apcs.shreyas.stages.models.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import net.synedra.validatorfx.Validator;

import java.util.function.Function;

public class Utility {
  public static VBox labeledTextField(String label) {
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
  }

  public static VBox stageToFXView(Stage stage, int i, Validator validator, Function<Void, Void> removeCallback, Function<Void, Void> updateCallback) {
    VBox stageBox = new VBox();

    stageBox.setSpacing(10);

    Label stageLabel = new Label("Stage " + (i + 1));
    stageLabel.setStyle("-fx-font-size: 16px");

    // create a small icon to help distinguish stages easily
    // https://stackoverflow.com/questions/1961146/memory-address-of-variables-in-java
    Rectangle icon = new Rectangle(4, 16);
    icon.setStyle("-fx-fill: #" + Integer.toHexString(stage.hashCode()).substring(0, 6));
    stageLabel.setGraphic(icon);

    Button removeButton = new Button("Remove");
    removeButton.setOnAction(e -> removeCallback.apply(null));

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
      updateCallback.apply(null);
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
      updateCallback.apply(null);
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
      updateCallback.apply(null);
    });

    stageBox.getChildren().add(stageLabel);
    stageBox.getChildren().add(removeButton);
    stageBox.getChildren().add(Utility.labeledTextField("Specific impulse (s)", specificImpulse));
    stageBox.getChildren().add(Utility.labeledTextField("Propellant mass (kg)", propellantMass));
    stageBox.getChildren().add(Utility.labeledTextField("Structural mass (kg)", structuralMass));

    return stageBox;
  }
}
