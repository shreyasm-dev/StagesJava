package apcs.shreyas.stages.controllers.components;

import apcs.shreyas.stages.Utility;
import apcs.shreyas.stages.models.provider.ProviderGroup;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.synedra.validatorfx.Validator;

import java.util.HashMap;

public class ValidatedDoubleField extends VBox {
  private final Label label;
  private final TextField field;
  private final Validator validator;
  private MenuButton choices;
  private final ProviderGroup<Double> provider;
  private double min = 0;
  private boolean minInclusive = false;

  public ValidatedDoubleField(String label, String value, Validator validator, ProviderGroup<Double> provider) {
    this.setSpacing(5);

    this.label = new Label(label);
    this.field = new TextField(value);
    this.validator = validator;
    this.provider = provider;

    this.field.setId(label);

    HBox fieldContainer = new HBox();
    fieldContainer.setSpacing(5);

    fieldContainer.getChildren().add(this.field);

    // If a provider is provided, add a menu button to select from the presets
    if (this.provider != null) {
      this.choices = new MenuButton();

      // Add all the items from the provider to the menu button
      this.choices.getItems().addAll(Utility.providerGroupToMenu("Presets", this.provider, e -> {
        this.field.setText(e.getItem().toString());
        this.field.fireEvent(new KeyEvent(KeyEvent.KEY_TYPED, "", "", null, false, false, false, false));
        this.choices.setText(e.getName());
        return null;
      }).getItems());

      // When the field is changed, reset the menu button text
      this.field.addEventHandler(KeyEvent.KEY_TYPED, e -> {
        this.choices.setText("Presets");
      });

      // Set initial text
      this.choices.setText("Presets");

      fieldContainer.getChildren().add(this.choices);
    }

    this.getChildren().addAll(this.label, fieldContainer);

    // The 'validated' part of the ValidatedDoubleField
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

  public ValidatedDoubleField(String label, String value, Validator validator, ProviderGroup<Double> provider, double min, boolean minInclusive) {
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

  public void setEventHandler(EventHandler<? super KeyEvent> action) {
    this.field.addEventHandler(KeyEvent.ANY, action);
  }
}
