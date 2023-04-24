package apcs.shreyas.stages.controllers.components;

import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.synedra.validatorfx.Validator;

import java.util.HashMap;

public class ValidatedDoubleField extends VBox {
  private Label label;
  private TextField field;
  private Validator validator;
  private HashMap<String, Double> provider;
  private double min = 0;
  private boolean minInclusive = false;

  public ValidatedDoubleField(String label, String value, Validator validator, HashMap<String, Double> provider) {
    this.setSpacing(5);

    this.label = new Label(label);
    this.field = new TextField(value);
    this.validator = validator;
    this.provider = provider;

    this.field.setId(label);

    HBox fieldContainer = new HBox();
    fieldContainer.setSpacing(5);

    fieldContainer.getChildren().add(this.field);
    if (provider != null) {
      ComboBox choices = new ComboBox<>();
      choices.setPromptText("Presets");

      // https://stackoverflow.com/questions/50569330/how-to-reset-combobox-and-display-prompttext
      choices.setButtonCell(new ListCell() {
        private void updateItem(String item, boolean empty) {
          super.updateItem(item, empty);
          setText("Presets");
        }
      });

      choices.getItems().addAll(provider.keySet().stream().sorted().toArray());
      choices.setOnAction(e -> {
        this.field.setText(provider.get(choices.getValue()).toString());
      });
      fieldContainer.getChildren().add(choices);
    }

    this.getChildren().addAll(this.label, fieldContainer);

    this.validator.createCheck().dependsOn(label, this.field.textProperty()).withMethod(c -> {
      try {
        double val = Double.parseDouble(c.get(label));
        if ((this.minInclusive && val < this.min) || (!this.minInclusive && val <= this.min)) {
          c.error("Must be greater than " + (this.minInclusive ? "or equal to " : "") + this.min);
        }
      } catch (NumberFormatException e) {
        c.error("Must be a number");
      }
    }).decorates(field).immediate();
  }

  public ValidatedDoubleField(String label, String value, Validator validator, HashMap<String, Double> provider, double min, boolean minInclusive) {
    this(label, value, validator, provider);
    this.min = min;
    this.minInclusive = minInclusive;
  }

  public String getText() {
    return this.field.getText();
  }

  public StringProperty textProperty() {
    return this.field.textProperty();
  }

  public void setEventHandler(EventHandler action) {
    this.field.addEventHandler(javafx.scene.input.KeyEvent.KEY_RELEASED, action);
  }
}
