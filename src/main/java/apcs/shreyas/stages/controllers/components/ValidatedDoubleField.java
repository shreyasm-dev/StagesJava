package apcs.shreyas.stages.controllers.components;

import apcs.shreyas.stages.Providers;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.synedra.validatorfx.Validator;

import java.util.HashMap;

public class ValidatedDoubleField extends VBox {
  private Label label;
  private TextField field;
  private Validator validator;
  private MenuButton choices;
  private Label choiceLabel;
  private HashMap<Providers.Engine, Double> provider;
  private double min = 0;
  private boolean minInclusive = false;

  public ValidatedDoubleField(String label, String value, Validator validator, HashMap<Providers.Engine, Double> provider) {
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
      // this.choices = new ComboBox();
      this.choices = new MenuButton();
      this.choiceLabel = new Label("");

      this.field.addEventHandler(KeyEvent.KEY_TYPED, e -> {
        this.choiceLabel.setText("");
      });

      this.choices.setText("Presets");

      // This creates a tree structure within the menu
      // Probably could be done a lot better
      for (Providers.EngineType type : Providers.EngineType.values()) {
        Menu typeMenu = new Menu(type.toString());
        for (Providers.EngineOperator operator : Providers.EngineOperator.values()) {
          Menu operatorMenu = new Menu(operator.toString());
          for (Providers.Engine engine : provider.keySet()) {
            if (engine.getType() == type && engine.getOperator() == operator) {
              MenuItem engineItem = new MenuItem(engine.toString());
              engineItem.setOnAction(e -> {
                this.field.setText(this.provider.get(engine).toString());
                this.field.fireEvent(new KeyEvent(KeyEvent.KEY_TYPED, "", "", null, false, false, false, false));
                this.choiceLabel.setText(engine.toString());
              });
              operatorMenu.getItems().add(engineItem);
            }
          }
          typeMenu.getItems().add(operatorMenu);
        }
        this.choices.getItems().add(typeMenu);
      }

      fieldContainer.getChildren().addAll(this.choices, this.choiceLabel);
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

  public ValidatedDoubleField(String label, String value, Validator validator, HashMap<Providers.Engine, Double> provider, double min, boolean minInclusive) {
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
    this.field.addEventHandler(KeyEvent.ANY, action);
  }
}
