package apcs.shreyas.stages;

import apcs.shreyas.stages.controllers.components.ValidatedDoubleField;
import apcs.shreyas.stages.models.Stage;
import apcs.shreyas.stages.models.provider.Providable;
import apcs.shreyas.stages.models.provider.ProviderGroup;
import apcs.shreyas.stages.models.provider.ProviderItem;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import net.synedra.validatorfx.Validator;

import java.util.Arrays;
import java.util.function.Function;

// Random utilities sorted into a class (many are only used once, but it makes the code more readable and cleaner)
public class Utility {
  // Unused
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

  // Convert a Stage to a JavaFX view
  public static VBox stageToFXView(Stage stage, int i, Validator validator, Function<Void, Void> removeCallback, Function<Void, Void> updateCallback) {
    VBox stageBox = new VBox();

    stageBox.setSpacing(10);

    Label stageLabel = new Label("Stage " + (i + 1));
    stageLabel.setStyle("-fx-font-size: 16px");

    // Create a small icon to help distinguish stages easily when deleting
    // https://stackoverflow.com/questions/1961146/memory-address-of-variables-in-java
    // Based on the hashCode of the stage, so it stays the same for the same Stage objects (easier to distinguish)
    Rectangle icon = new Rectangle(4, 16);
    icon.setStyle("-fx-fill: #" + Integer.toHexString(stage.hashCode()).substring(0, 6));
    stageLabel.setGraphic(icon);

    // On click, call the passed callback to remove this stage from the list
    Button removeButton = new Button("Remove");
    removeButton.setOnAction(e -> removeCallback.apply(null));

    ValidatedDoubleField specificImpulse = new ValidatedDoubleField(
      "Specific impulse (s)",
      String.valueOf(stage.getSpecificImpulse()),
      validator,
      Providers.SPECIFIC_IMPULSE
    );
    specificImpulse.textProperty().addListener((observable, oldValue, newValue) -> {
      stage.setSpecificImpulse(Double.parseDouble(newValue));
      updateCallback.apply(null);
    });

    ValidatedDoubleField propellantMass = new ValidatedDoubleField(
      "Propellant mass (kg)",
      String.valueOf(stage.getPropellantMass()),
      validator,
      null
    );
    propellantMass.textProperty().addListener((observable, oldValue, newValue) -> {
      stage.setPropellantMass(Double.parseDouble(newValue));
      updateCallback.apply(null);
    });

    ValidatedDoubleField structuralMass = new ValidatedDoubleField(
      "Structural mass (kg)",
      String.valueOf(stage.getStructuralMass()),
      validator,
      null
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

  // Convert a ProviderGroup to a JavaFX Menu to use in ValidatedDoubleField
  public static Menu providerGroupToMenu(String label, ProviderGroup<?> provider, Function<ProviderItem<?>, Void> callback) {
    Menu menu = new Menu(label);

    for (Providable<?> providable : provider.getItems()) {
      if (providable instanceof ProviderGroup) {
        menu.getItems().add(providerGroupToMenu(providable.getName(), (ProviderGroup<?>) providable, callback));
      } else if (providable instanceof ProviderItem) {
        MenuItem item = new MenuItem(providable.toString());
        item.setOnAction(e -> callback.apply((ProviderItem) providable));
        menu.getItems().add(item);
      }
    }

    return menu;
  }
}
